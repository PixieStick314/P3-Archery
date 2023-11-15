<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
    const numberRegex = /\d/;

    import { format } from 'date-fns';
    let formattedDate = format(new Date(data.user.dateOfBirth), 'yyyy-MM-dd');

    $: fields = {
        email: {
            value: data.user.email,
            message: "Vi deler aldrig din email.",
            textColor: "black"
        },
        password: {
            value: data.user.password,
            message: "",
            textColor: "black"
        },
        confirmPassword: {
            value: "",
            message: "",
            textColor: "black"
        },
        name: {
            value: data.user.name,
            message: "Fornavn og efternavn.",
            textColor: "black"
        },
        address: {
            value: data.user.address,
            message: "Vej og husnr.",
            textColor: "black"
        },
        postcode: {
            value: data.user.postcode,
            message: "",
            textColor: "black"
        },
        cellphoneNr: {
            value: data.user.cellphoneNr,
            message: "",
            textColor: "black"
        },
        dateOfBirth: {
            value: formattedDate,
            message: "Du skal være mindst 13 for at oprette som bruger.",
            textColor: "black"
        },

    };
    function validateEmail() {
        let emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;;
        const field = fields.email;

        if(!emailRegex.test(field.value)) {
            field.message = "Indtast venligst en brugbar email.";
            field.textColor = "red";
            return false;
        }
        else {
            field.message = "Vi deler aldrig din email.";
            field.textColor = "black";
            return true;
        }
    }
    function validatePassword() {
        const capitalRegex = /[A-Z]/;
        const field = fields.password;

        const hasCapital = capitalRegex.test(field.value);
        const hasNumber = numberRegex.test(field.value);
        const hasSpecial = specialRegex.test(field.value);

        field.message = "";
        if(hasNumber && hasSpecial && hasCapital && field.value.length > 7) {
            field.message = "OBS: Medarbejdere vil aldrig spørge efter din kode";
            field.textColor = "black";
            return true;
        }
        else {
            field.message = "Du mangler følgende i din kode:" + "<br/>";
            field.textColor = "red";

            field.message += (field.value.length > 7)
                ?  ''
                : 'Koden skal være mindst 8 tegn' + "<br/>";
            field.message += hasCapital
                ? ''
                : ' Stort bogstav' + "<br/>";

            field.message += hasNumber
                ? ''
                : ' Et nummer' + "<br/>";

            field.message += hasSpecial
                ? ''
                : ' Et af følgende specialtegn: (! @ # $ % ^ & * ( ) _ + { }  \[ \ ] : ; < > , . ? ~ \ \ \ / - ) ' + "<br/>";
            return false;
        }
    }
    function validateConfirmPassword(){
        const field = fields.confirmPassword;
        field.message = "";
        field.textColor = "red";
        const oldPassword = data.user.password;

        if(fields.password.value === oldPassword) {
            return true
        } else if (fields.password.value === fields.confirmPassword.value){
            field.message = ""
            return true;
        } else {
            field.message = "Matcher ikke din kode"
            return false;
        }
    }


    function validateName(){
        const field = fields.name;
        field.message = "";
        const nameRegex = /^[A-Za-zæøåÆØÅ]+ [A-Za-zæøåÆØÅ]+$/;
        if(nameRegex.test(field.value)){
            field.message = "";
            return true;
        } else {
            field.message = "Indtast venligst dit navn og efternavn separeret af et mellemrum." + "<br/>";
            field.textColor = "red";
            field.message += !numberRegex.test(field.value)
                ?  ''
                :  'Fjern venligst tal fra dit navn' + "<br/>";
            field.message += !specialRegex.test(field.value)
                ? ''
                : 'Fjern venligst specialtegn fra dit navn' + "<br/>";
            return false;
            console.log()
        }
    }

    function validateAddress() {
        const field = fields.address;
        const addressRegex = /^(.+) (\d{1,3}[a-z]?) ? ?(\d{1,2}|tv|mf|th)?/;
        field.message = "";
        if (field.value.includes(" ") && numberRegex.test(field.value) && addressRegex.test(field.value)) {
            field.message = "";
            return true;
        } else {
            field.message = "Indtast venligst din adresse og husnr." + "<br/>";
            field.textColor = "red";
            field.message += addressRegex.test(field.value)
                ? ''
                : ' Ugyldig adresseformat.';
            return false;
        }
    }

    function validatePostcode() {
        const field = fields.postcode;
        field.message = "";
        if(field.value < "1000" || field.value > "9999") {
            field.message = "Indtast venligst et reelt postnummer";
            field.textColor = "red";
            return false;
        } else {
            field.message = ""
            return true;
        }
    }

    function validatePhonenumber() {
        const field = fields.cellphoneNr;
        let cellphoneNrRegex = /^\(?(\d{2})\)??(\d{2})?(\d{2})?(\d{2})$/;

        if(!cellphoneNrRegex.test(field.value)) {
            field.message = "Indtast venligst et gyldigt dansk telefonummer (undlad landkode og specialtegn)";
            field.textColor = "red";
            return false;
        }
        else {
            field.message = "";
            return true;
        }
    }

    function validate(event) {
        if(!validateEmail() || !validatePassword() || !validateConfirmPassword() || !validateName() || !validateAddress() || !validatePostcode() || !validatePhonenumber()) {
            event.preventDefault()
            alert("OBS: Du mangler at udfylde et eller flere af felterne!");
            return false;
        }
        else{return true;}
    }
</script>

<form name="userCreation" method="POST" action="?/update" class="container-sm mt-5">
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email address</label>
        <input required bind:value={fields.email.value} on:input={validateEmail} name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" >
        <div id="emailHelp" class="form-text" style="color: {fields.email.textColor}" >{fields.email.message}</div>
    </div>

    <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input value={fields.password.value} name="password" type="password" class="form-control" id="passwordInput" required on:input={validatePassword}>
        <div id="passHelp" class="form-text" style="color: {fields.password.textColor}" >{@html fields.password.message}</div>
    </div>

    <div class="mb-3">
        <label for="confirmPasswordInput" class="form-label">Confirm Password</label>
        <input bind:value={fields.confirmPassword.value} name="confirmPassword" type="password" class="form-control" id="confirmPasswordInput" required on:input={validateConfirmPassword}>
        <div id="confPassHelp" class="form-text" style="color: {fields.confirmPassword.textColor}" >{@html fields.confirmPassword.message}</div>
    </div>

    <div class="mb-3">
        <label for="nameInput" class="form-label">Name</label>
        <input bind:value={data.user.name} name="name" type="text" class="form-control" id="nameInput" required on:input={validateName} >
        <div id="nameHelp" class="form-text" style="color: {fields.name.textColor}" >{@html fields.name.message}</div>
    </div>
    <div class="mb-3">
        <label for="genderInput" class="form-label">Gender</label>
        <select name="gender" id="genderInput" class="custom-select form-control" required>
            <option value="Select" disabled >Vælg en af følgende:</option>
            <option value="Mand">Mand</option>
            <option value="Kvinde">Kvinde</option>
            <option value="Andet">Andet</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="addressInput" class="form-label">Address</label>
        <input bind:value={data.user.address} name="address" type="text" class="form-control" id="addressInput" required on:input={validateAddress}>
        <div id="addressHelp" class="form-text" style="color: {fields.address.textColor}" >{@html fields.address.message}</div>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postcode</label>
        <input bind:value={data.user.postcode} name="postcode" type="number" class="form-control" id="postcodeInput" required on:input={validatePostcode}>
        <div id="postcode" class="form-text" style="color: {fields.postcode.textColor}" >{fields.postcode.message}</div>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Cellphone Number</label>
        <input value={data.user.cellphoneNr} name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" required on:input={validatePhonenumber}>
        <div id="cellphoneNr" class="form-text" style="color: {fields.cellphoneNr.textColor}" >{fields.cellphoneNr.message}</div>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Date of Birth</label>
        <input bind:value={formattedDate} name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput" required>
    </div>
    <button type="submit" class="btn btn-primary" on:click={validate}>Opdatér</button>

</form>

<!--<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;
</script>
<div>Hej {data.user.name}, her kan du opdatere dine kontoinformationer!</div>
<form method="POST" action="?/update" class="container-sm mt-5">
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email</label>
        <input name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" value={data.user.email}>
        <div id="emailHelp" class="form-text">Vi deler ikke din email med nogen.</div>
    </div>
    <div class="mb-3">
        <label for="passwordInput" class="form-label">Kode</label>
        <input name="password" type="password" class="form-control" id="passwordInput">
    </div>
    <div class="mb-3">
        <label for="nameInput" class="form-label">Navn</label>
        <input name="name" type="text" class="form-control" id="nameInput" value={data.user.name}>
    </div>
    <div class="mb-3">
        <label for="genderInput" class="form-label">Køn</label>
        <select name="gender" id="genderInput" class="custom-select form-control">
            <option value="Select">Vælg en af følgende:</option>
            {#if data.user.gender == "Mand"}
                <option value="Mand" selected>Mand</option>
                <option value="Kvinde">Kvinde</option>
                <option value="Andet">Andet</option>
            {:else if data.user.gender == "Kvinde"}
                <option value="Mand">Mand</option>
                <option value="Kvinde" selected>Kvinde</option>
                <option value="Andet">Andet</option>
            {:else}
                <option value="Mand">Mand</option>
                <option value="Kvinde">Kvinde</option>
                <option value="Andet" selected>Andet</option>
            {/if}
        </select>
    </div>
    <div class="mb-3">
        <label for="addressInput" class="form-label">Addresse</label>
        <input name="address" type="text" class="form-control" id="addressInput" value={data.user.address}>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postnummer</label>
        <input name="postcode" type="number" class="form-control" id="postcodeInput" value={data.user.postcode}>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Telefon nummer</label>
        <input name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" value={data.user.cellphoneNr}>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Fødselsdato</label>
        <input name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput" value={data.user.dateOfBirth}>
    </div>


    <button type="submit" class="btn btn-primary">Opdatér</button>
</form>

{#if form?.success}
    <h1>Successfully updated</h1>
{/if} -->

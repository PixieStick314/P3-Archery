<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
    const numberRegex = /\d/;

    import { format } from 'date-fns';
    let formattedDate = format(new Date(data.user.dateOfBirth), 'yyyy-MM-dd');

    console.log(data);

    $: fields = {
        email: {
            value: "",
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
            value: "",
            message: "Fornavn og efternavn.",
            textColor: "black"
        },
        address: {
            value: "",
            message: "Vej og husnr.",
            textColor: "black"
        },
        postcode: {
            value: "",
            message: "",
            textColor: "black"
        },
        cellphoneNr: {
            value: "",
            message: "",
            textColor: "black"
        },
        dateOfBirth: {
            value: new Date(),
            message: "Du skal være mindst 13 for at oprette som bruger.",
            textColor: "black"
        },

    };

    let emailValue = "";
    function validateEmail() {
        let emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;;
        const field = fields.email;
        fields.email.value = emailValue;

        if(!emailRegex.test(field.value)) {
            field.message = "Indtast venligst en brugbar email.";
            field.textColor = "red";
            return false;
        }
        else if (fields.email.value === ""){
            field.message = "Vi deler aldrig din email.";
            field.textColor = "black";
            fields.email.value = data.user.email;
            return true
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
        else if (field.value === ""){
            field.message = "Vi deler aldrig din email.";
            field.textColor = "black";
            field.value = data.user.password;
            return true
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

        if(fields.password.value === "") {
            return true
        } else if (fields.password.value === fields.confirmPassword.value){
            field.message = ""
            return true;
        } else {
            field.message = "Matcher ikke din kode"
            return false;
        }
    }

    let nameValue = ""
    function validateName(){
        const field = fields.name;
        fields.name.value = nameValue;

        field.message = "";
        const nameRegex = /^[A-Za-zæøåÆØÅ]+ [A-Za-zæøåÆØÅ]+$/;

        if(nameRegex.test(field.value)){
            field.message = "";
            return true;
        }
            else if(fields.name.value === "") {
                field.message = "";
                fields.name.value = data.user.value;
                return true;
        }
            else {
            field.message = "Indtast venligst dit navn og efternavn separeret af et mellemrum." + "<br/>";
            field.textColor = "red";
            field.message += !numberRegex.test(field.value)
                ?  ''
                :  'Fjern venligst tal fra dit navn' + "<br/>";
            field.message += !specialRegex.test(field.value)
                ? ''
                : 'Fjern venligst specialtegn fra dit navn' + "<br/>";
            return false;
        }
    }

    let addressValue = ""
    function validateAddress() {
        const field = fields.address;
        fields.address.value = addressValue

        const addressRegex = /^(.+) (\d{1,3}[a-z]?) ? ?(\d{1,2}|tv|mf|th)?/;
        field.message = "";
        if (field.value.includes(" ") && numberRegex.test(field.value) && addressRegex.test(field.value)) {
            field.message = "";
            return true;
        } else if (fields.address.value == ""){
            field.message = "";
            fields.address.value = data.user.value;
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

    let postcodeValue = "";
    function validatePostcode() {
        const field = fields.postcode;
        field.message = "";

        fields.postcode.value = postcodeValue;

        if(field.value < "1000" || field.value > "9999") {
            field.message = "Indtast venligst et reelt postnummer";
            field.textColor = "red";
            return false;
        } else if(fields.postcode.value == "") {
            field.message = ""
            fields.postcode.value = data.user.postcode;
            return true;
        } else {
            field.message = ""
            return true;
        }
    }

    let cellphoneNrValue = "";
    function validatePhonenumber() {
        const field = fields.cellphoneNr;
        let cellphoneNrRegex = /^\d{8}$/;

        fields.cellphoneNr.value = cellphoneNrValue;

        if(!cellphoneNrRegex.test(field.value)) {
            field.message = "Indtast venligst et gyldigt dansk telefonummer (undlad landkode og specialtegn)";
            field.textColor = "red";
            return false;
        } else if (fields.cellphoneNr.value = "") {
            field.message = "";
            fields.cellphoneNr.value = data.user.cellphoneNr;
            return true;
        }
        else {
            field.message = "";
            return true;
        }
    }

    function validate(event) {
        //The user should not be allowed to send a form with empty text fields
        if(emailValue.trim() === ""){
            emailValue = data.user.email;
        }
        else if(nameValue.trim() === ""){
            nameValue = data.user.name;
            console.log(nameValue);
        }
        else if(addressValue.trim() === ""){
            addressValue = data.user.address;
        }
        else if(cellphoneNrValue.trim() === ""){
            cellphoneNrValue = data.user.cellphoneNr;
        }
        else if(!validateEmail() ||
            !validatePassword() ||
            !validateConfirmPassword() ||
            !validateName() ||
            !validateAddress() ||
            !validatePostcode() ||
            !validatePhonenumber()) {
            event.preventDefault()
            alert("OBS: Du mangler at udfylde et eller flere af felterne.");
            return false;
        }
    }
</script>

<form name="userUpdate" method="POST" action="?/update" class="container-sm mt-5" on:submit={validate}>
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email addresse</label>
        <input bind:value={emailValue} on:input={validateEmail} name="email" type="text" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder={data.user.email}>
        <div id="emailHelp" class="form-text" style="color: {fields.email.textColor}" >{fields.email.message}</div>
    </div>

    <div class="mb-3">
        <label for="passwordInfo" class="form-label">Nuværende kodeord</label>
        <div id="passwordInfo" class="form-text">{fields.password.value}</div>
    </div>

    <div class="mb-3">
        <label for="passwordInput" class="form-label">Kodeord</label>
        <input name="password" type="password" class="form-control" id="passwordInput" on:input={validatePassword}>
        <div id="passHelp" class="form-text" style="color: {fields.password.textColor}" >{@html fields.password.message}</div>
    </div>

    <div class="mb-3">
        <label for="confirmPasswordInput" class="form-label">Bekræft kodeord</label>
        <input name="confirmPassword" type="password" class="form-control" id="confirmPasswordInput" on:input={validateConfirmPassword}>
        <div id="confPassHelp" class="form-text" style="color: {fields.confirmPassword.textColor}" >{@html fields.confirmPassword.message}</div>
    </div>

    <div class="mb-3">
        <label for="nameInput" class="form-label">Fulde navn</label>
        <input bind:value={nameValue} name="name" type="text" class="form-control" id="nameInput" on:input={validateName} placeholder={data.user.name}>
        <div id="nameHelp" class="form-text" style="color: {fields.name.textColor}" >{@html fields.name.message}</div>
    </div>
    <div class="mb-3">
        <label for="genderInput" class="form-label">Køn</label>
        <select name="gender" id="genderInput" class="custom-select form-control" placeholder={data.user.gender}>
            <option value="Select" disabled >Vælg en af følgende:</option>
            <option value="Mand">Mand</option>
            <option value="Kvinde">Kvinde</option>
            <option value="Andet">Andet</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="addressInput" class="form-label">Adresse</label>
        <input bind:value={addressValue} name="address" type="text" class="form-control" id="addressInput" on:input={validateAddress} placeholder={data.user.address}>
        <div id="addressHelp" class="form-text" style="color: {fields.address.textColor}" >{@html fields.address.message}</div>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postnr.</label>
        <input bind:value={postcodeValue} name="postcode" type="number" class="form-control" id="postcodeInput" on:input={validatePostcode} placeholder={data.user.postcode}>
        <div id="postcode" class="form-text" style="color: {fields.postcode.textColor}" >{fields.postcode.message}</div>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Tlf. nr.</label>
        <input bind:value={cellphoneNrValue} name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" on:input={validatePhonenumber} placeholder={data.user.cellphoneNr}>
        <div id="cellphoneNr" class="form-text" style="color: {fields.cellphoneNr.textColor}" >{fields.cellphoneNr.message}</div>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Fødselsdato</label>
        <input value={formattedDate} name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput">
    </div>
    <button type="submit" class="btn btn-primary">Opdatér</button>

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

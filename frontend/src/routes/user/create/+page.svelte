<script>

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
    const numberRegex = /\d/;

    $: fields = {
        email: {
            value: "",
            message: "Vi deler aldrig din email.",
            textColor: "black"
        },
        password: {
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
    /*
    let email = "";
    let password = "";
    let name = "";
    let gender = "";
    let address = "";
    let postcode = "";
    let cellphoneNr = "";
    let dateOfBirth = new Date();

    let emailMessage = "Vi deler aldrig din email.";
    let passwordMessage = "";
    let nameMessage = "Fornavn og efternavn.";
    let addressMessage = "Vej og husnr.";
    let postcodeMessage = "";
    let cellphoneNrMessage = "";

    let emailTextColor = "black";
    let passwordTextColor = "black";
    let nameTextColor = "black";
    let addressTextColor = "black";
    let postcodeTextColor = "black";
    let cellphoneNrTextColor = "black";
    */
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

    function validateName(){
        const field = fields.name;
        field.message = "";
        if(field.value.includes(" ") && !specialRegex.test(field.value) && !numberRegex.test(field.value)){
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
    function validate() {
        if(!validateEmail() ||
            !validatePassword() ||
            !validateName() ||
            !validateAddress() ||
            !validatePhonenumber()) {
            alert("OBS: Du mangler at udfylde et eller flere af felterne!");
            return false;
        }
    }

</script>

<form name="userCreation" method="POST" action="?/register" class="container-sm mt-5">
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email address</label>
        <input required bind:value={fields.email.value} on:input={validateEmail} name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" >
        <div id="emailHelp" class="form-text" style="color: {fields.email.textColor}" >{fields.email.message}</div>
    </div>

    <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input bind:value={fields.password.value} name="password" type="password" class="form-control" id="passwordInput" required on:input={validatePassword}>
            <div id="passHelp" class="form-text" style="color: {fields.password.textColor}" >{@html fields.password.message}</div>
    </div>

    <div class="mb-3">
        <label for="nameInput" class="form-label">Name</label>
        <input bind:value={fields.name.value} name="name" type="text" class="form-control" id="nameInput" required on:input={validateName}>
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
        <input bind:value={fields.address.value} name="address" type="text" class="form-control" id="addressInput" required on:input={validateAddress}>
        <div id="addressHelp" class="form-text" style="color: {fields.address.textColor}" >{@html fields.address.message}</div>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postcode</label>
        <input bind:value={fields.postcode.value} name="postcode" type="number" class="form-control" id="postcodeInput" required on:input={validatePostcode}>
        <div id="postcode" class="form-text" style="color: {fields.postcode.textColor}" >{fields.postcode.message}</div>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Cellphone Number</label>
        <input bind:value={fields.cellphoneNr.value} name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" required on:input={validatePhonenumber}>
        <div id="cellphoneNr" class="form-text" style="color: {fields.cellphoneNr.textColor}" >{fields.cellphoneNr.message}</div>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Date of Birth</label>
        <input bind:value={fields.dateOfBirth.value} name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput" required>
    </div>

    <div class="mb-3">
        <label for="archerySkillLevelInput" class="form-label">Archery Skill Level</label>
        <!--<input name="archerySkillLevel" type="number" class="form-control" id="archerySkillLevelInput" required> 1-->
        <select name="archerySkillLevel" id="archerySkillLevelInput" class="custom-select form-control" required>
            <option value="Select" disabled >Vælg en af følgende:</option>
            <option value= 1>Begynder</option>
            <option value= 2>Middelmådig</option>
            <option value= 3>Professionel</option>
        </select>
    </div>
    <button on:click={validate} type="submit" class="btn btn-primary">Submit</button>
</form>
<script>

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;

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

        console.log(emailRegex.test(field.value));
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
        const numberRegex = /\d/;
        const field = fields.password;

        const hasCapital = capitalRegex.test(field.value);
        const hasNumber = numberRegex.test(field.value);
        const hasSpecial = specialRegex.test(field.value);

        console.log(capitalRegex.test(field.value), numberRegex.test(field.value), specialRegex.test(field.value));
        if(hasCapital && hasNumber && hasSpecial) {
            field.message = "";
            return true;
        }
        else {
            field.message = "Dit kodeord skal indeholde store og små bogstaver, mindst 1 tal og mindst 1 specialtegn.";
            field.textColor = "red";
            return false;
        }
    }

    function validateName(){
        const field = fields.name;

        if(field.value.includes(" ") && !specialRegex.test(field.value)){
            field.message = "";
            return true;
        } else {
            field.message = "Indtast venligst dit navn og efternavn separeret af et mellemrum.";
            field.textColor = "red";
            return false;
        }

    }

    function validateAddress(){
        const pattern = /^[a-zA-Z]+\s\d+$/;
        const field = fields.address;

        if(pattern.test(field.value) && !specialRegex.test(field.value)){
            field.message = "";
            return true;
        } else {
            field.message = "indtast venligst vejnavn efterfulgt af husnummer";
            field.textColor = "red";
            return false;
        }
    }

    function validatePostcode() {
        const field = fields.postcode;

        if(field.value <1000 || field.value > 9999) {
            field.message = "Indtast venligst et reelt postnummer";
            field.textColor = "red";
            return false;
        } else {
            field.message = ""
            return true
        }
    }
    function validatePhonenumber() {
        const field = fields.cellphoneNr;

        let cellphoneNrRegex = /^\(?(\d{2})\)?[- ]?(\d{2})[- ]?(\d{2})[- ]?(\d{2})$/;

        if(!cellphoneNrRegex.test(field.value)) {
            field.message = "Indtast venligst et gyldigt dansk telefonummer (undlad landkode)";
            field.textColor = "red";
            return false;
        }
        if(cellphoneNrRegex.test(field.value)) {
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
        <input bind:value={fields.password.value} name="password" type="password" class="form-control" id="passwordInput" required on:blur={validatePassword}>
            <div id="passHelp" class="form-text" style="color: {fields.password.textColor}" >{fields.password.message}</div>
    </div>

    <div class="mb-3">
        <label for="nameInput" class="form-label">Name</label>
        <input bind:value={fields.name.value} name="name" type="text" class="form-control" id="nameInput" required>
        <div id="nameHelp" class="form-text" style="color: {fields.name.textColor}" >{fields.name.message}</div>
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
        <input bind:value={fields.address.value} name="address" type="text" class="form-control" id="addressInput" required>
        <div id="addressHelp" class="form-text" style="color: {fields.address.textColor}" >{fields.address.message}</div>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postcode</label>
        <input bind:value={fields.postcode.value} name="postcode" type="number" class="form-control" id="postcodeInput" required on:change={validatePostcode}>
        <div id="postcode" class="form-text" style="color: {fields.postcode.textColor}" >{fields.postcode.message}</div>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Cellphone Number</label>
        <input bind:value={fields.cellphoneNr.value} name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" required on:change={validatePhonenumber}>
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
            <option value="Begynder">Begynder</option>
            <option value="Middelmådig">Middelmådig</option>
            <option value="Professionel">Professionel</option>
        </select>
    </div>
    <button onsubmit="return validate()" type="submit" class="btn btn-primary" on:change={validate}>Submit</button>
</form>
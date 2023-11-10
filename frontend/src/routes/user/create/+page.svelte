<script>

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;

    let email = "";
    let password = "";
    let name = "";
    let gender = "";
    let address = "";
    let postcode = "";
    let cellphoneNr = "";
    let dateOfBirth = new Date();

    let emailMessage = "Vi deler aldrig din email."
    let passwordMessage = ""
    let nameMessage = "Fornavn og efternavn."
    let addressMessage = "Vej og husnr."
    let postcodeMessage = ""
    let cellphoneNrMessage = ""

    let textColor = "black"

    function validateEmail() {
        var re = /\S+@\S+\.\S+/;
        console.log(re.test(email));
        if(!re.test(email)) {
            emailMessage = "Indtast venligst en brugbar email.";
            textColor = "red";
            return false;
        }
        else {
            emailMessage = "Vi deler aldrig din email.";
            textColor = "black";
            return true;
        }
    }

    function validatePassword() {
        const capitalRegex = /[A-Z]/;
        const numberRegex = /\d/;


        const hasCapital = capitalRegex.test(password);
        const hasNumber = numberRegex.test(password);
        const hasSpecial = specialRegex.test(password);

        console.log(capitalRegex.test(password), numberRegex.test(password), specialRegex.test(password));
        if(hasCapital && hasNumber && hasSpecial) {
            passwordMessage = "";
            return true;
        }
        else {
            passwordMessage = "Dit kodeord skal indeholde store og små bogstaver, mindst 1 tal og mindst 1 specialtegn.";
            return false;
        }
    }

    function validateName(){

        if(name.includes(" ") && !specialRegex.test(name)){
            nameMessage = "";
            return true;
        } else {
            nameMessage = "Indtast venligst dit navn og efternavn separeret af et mellemrum.";
            return false;
        }

    }

    function validateAddress(){
        const pattern = /^[a-zA-Z]+\s\d+$/;

        if(pattern.test(address) && !specialRegex.test(address)){
            addressMessage = "";
            return true;
        } else {
            addressMessage = "indtast venligst vejnavn efterfulgt af husnummer";
            return false;
        }
    }

    function validatePostcode() {
        if(postcode <1000 || postcode > 9999) {
            postcodeMessage = "Indtast venligst et reelt postnummer";
            textColor = "red";
            return false;
        } else {
            postcodeMessage = ""
            return true
        }
    }
    function validatePhonenumber() {
        var re = /^\(?(\d{2})\)?[- ]?(\d{2})[- ]?(\d{2})[- ]?(\d{2})$/;

        if(!re.test(cellphoneNr)) {
            cellphoneNrMessage = "Indtast venligst et gyldigt dansk telefonummer (undlad landkode)";
            textColor = "red";
            return false;
        }
        if(re.test(cellphoneNr)) {
            cellphoneNrMessage = "";
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
        <input bind:value={email} name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" required on:change={validateEmail}>
        <div id="emailHelp" class="form-text" style="color: {textColor}" >{emailMessage}</div>
    </div>
    <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input bind:value={password} name="password" type="password" class="form-control" id="passwordInput" required on:change={validatePassword}>
        <div id="passHelp" class="form-text" style="color: {textColor}" >{passwordMessage}</div>
    </div>
    <div class="mb-3">
        <label for="nameInput" class="form-label">Name</label>
        <input bind:value={name} name="name" type="text" class="form-control" id="nameInput" required>
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
        <input bind:value={address} name="address" type="text" class="form-control" id="addressInput" required>
        <div id="addressHelp" class="form-text" style="color: {textColor}" >{addressMessage}</div>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postcode</label>
        <input bind:value={postcode} name="postcode" type="number" class="form-control" id="postcodeInput" required on:change={validatePostcode}>
        <div id="postcode" class="form-text" style="color: {textColor}" >{postcodeMessage}</div>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Cellphone Number</label>
        <input bind:value={cellphoneNr} name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" required on:change={validatePhonenumber}>
        <div id="cellphoneNr" class="form-text" style="color: {textColor}" >{cellphoneNrMessage}</div>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Date of Birth</label>
        <input bind:value={dateOfBirth} name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput" required on:change={signatureReminder}>
    </div>

    <div class="mb-3">
        <label for="archerySkillLevelInput" class="form-label">Archery Skill Level</label>
        <!--<input name="archerySkillLevel" type="number" class="form-control" id="archerySkillLevelInput" required>-->
        <select name="archerySkillLevel" id="archerySkillLevelInput" class="custom-select form-control" required>
            <option value="Select" disabled >Vælg en af følgende:</option>
            <option value="Begynder">Begynder</option>
            <option value="Middelmådig">Middelmådig</option>
            <option value="Professionel">Professionel</option>
        </select>
    </div>

    <button onsubmit="return validate()" type="submit" class="btn btn-primary" on:change={validate}>Submit</button>
</form>
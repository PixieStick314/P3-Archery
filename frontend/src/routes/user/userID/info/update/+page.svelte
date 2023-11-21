<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;

    const specialRegex = /[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]/;
    const numberRegex = /\d/;

    new Date(data.user.dateOfBirth);
    $: formattedDate = new Date(data.user.dateOfBirth).toISOString().split('T')[0];

    $: fields = {
        email: {
            value: "",
            message: "Vi deler aldrig din email.",
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

    let emailValue = data.user.email;
    function validateEmail() {
        let emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;;
        const field = fields.email;
        fields.email.value = emailValue;

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

    let nameValue = data.user.name;
    function validateName() {
        const field = fields.name;
        fields.name.value = nameValue;
        field.message = "";
        const nameRegex = /^[A-Za-zæøåÆØÅ]+(?:\s+[A-Za-zæøåÆØÅ]+)*\s[A-Za-zæøåÆØÅ]+$/;

        if (nameRegex.test(field.value)) {
            field.message = "";
            return true;
        } else {
            field.message = "Indtast venligst dit navn og efternavn separeret af et mellemrum." + "<br/>";
            field.textColor = "red";
            field.message += !numberRegex.test(field.value)
                ? ''
                : 'Fjern venligst tal fra dit navn' + "<br/>";
            field.message += !specialRegex.test(field.value)
                ? ''
                : 'Fjern venligst specialtegn fra dit navn' + "<br/>";
            return false;
        }
    }

    let addressValue = data.user.address;
    function validateAddress() {
        const field = fields.address;
        fields.address.value = addressValue

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

    let postcodeValue = data.user.postcode;
    function validatePostcode() {
        const field = fields.postcode;
        field.message = "";

        fields.postcode.value = postcodeValue;

        if(field.value < "1000" || field.value > "9999") {
            field.message = "Indtast venligst et reelt postnummer";
            field.textColor = "red";
            return false;
        } else {
            field.message = ""
            return true;
        }
    }

    let cellphoneNrValue = data.user.cellphoneNr;
    function validatePhonenumber() {
        const field = fields.cellphoneNr;
        let cellphoneNrRegex = /^\d{8}$/;

        fields.cellphoneNr.value = cellphoneNrValue;

        if(!cellphoneNrRegex.test(field.value)) {
            field.message = "Indtast venligst et gyldigt dansk telefonummer (undlad landkode, specialtegn og mellemrum)";
            field.textColor = "red";
            return false;
        } else {
            field.message = "";
            return true;
        }
    }

    function validate(event) {
        const isEmailValid = validateEmail();
        const isNameValid = validateName();
        const isAddressValid = validateAddress();
        const isPostcodeValid = validatePostcode();
        const isPhonenumberValid = validatePhonenumber();
        if (
            !isEmailValid ||
            !isNameValid ||
            !isAddressValid ||
            !isPostcodeValid ||
            !isPhonenumberValid
        ) {
            event.preventDefault();
            alert("OBS: Der er fejl i et eller flere af felterne.");
            return false;
        } else {
            userUpdateForm.submit();
            alert("Dine informationer er blevet opdateret!")
            return true;
        }
    }
</script>

<form name="userUpdate" method="POST" action="?/update" class="container-sm mt-5" id="userUpdateForm" on:submit|preventDefault={validate}>
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email addresse</label>
        <input bind:value={emailValue} on:input={validateEmail} name="email" type="text" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder={data.user.email}>
        <div id="emailHelp" class="form-text" style="color: {fields.email.textColor}" >{fields.email.message}</div>
    </div>

    <div class="mb-3">
        <label for="nameInput" class="form-label">Fulde navn</label>
        <input bind:value={nameValue} name="name" type="text" class="form-control" id="nameInput" on:input={validateName} placeholder={data.user.name}>
        <div id="nameHelp" class="form-text" style="color: {fields.name.textColor}" >{@html fields.name.message}</div>
    </div>

    <div class="mb-3">
        <label for="genderInput" class="form-label">Køn</label>
        <select id="genderInput" class="custom-select form-control" name="gender">
            <option disabled>Vælg et køn:</option>
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


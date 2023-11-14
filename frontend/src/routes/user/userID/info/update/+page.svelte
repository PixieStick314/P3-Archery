<script>
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

    <div class="mb-3">
        <label for="archerySkillLevelInput" class="form-label">Bueskytte niveau</label>
        <input name="archerySkillLevel" type="number" class="form-control" id="archerySkillLevelInput" value={data.user.archerySkillLevel}>
    </div>

    <button type="submit" class="btn btn-primary">Opdatér</button>
</form>

{#if form?.success}
    <h1>Successfully updated</h1>
{/if}

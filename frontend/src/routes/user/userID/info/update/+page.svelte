<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;
</script>
<div>Hey {data.user.name}, let's edit your user!</div>
<form method="POST" action="?/update" class="container-sm mt-5">
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email address</label>
        <input name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" value={data.user.email}>
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="passwordInput">
    </div>
    <div class="mb-3">
        <label for="nameInput" class="form-label">Name</label>
        <input name="name" type="text" class="form-control" id="nameInput" value={data.user.name}>
    </div>
    <div class="mb-3">
        <label for="genderInput" class="form-label">Gender</label>
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
        <label for="addressInput" class="form-label">Address</label>
        <input name="address" type="text" class="form-control" id="addressInput" value={data.user.address}>
    </div>
    <div class="mb-3">
        <label for="postcodeInput" class="form-label">Postcode</label>
        <input name="postcode" type="number" class="form-control" id="postcodeInput" value={data.user.postcode}>
    </div>
    <div class="mb-3">
        <label for="cellphoneNrInput" class="form-label">Cellphone Number</label>
        <input name="cellphoneNr" type="tel" class="form-control" id="cellphoneNrInput" value={data.user.cellphoneNr}>
    </div>
    <div class="mb-3">
        <label for="dateOfBirthInput" class="form-label">Date of Birth</label>
        <input name="dateOfBirth" type="date" class="form-control" id="dateOfBirthInput" value={data.user.dateOfBirth}>
    </div>

    <div class="mb-3">
        <label for="archerySkillLevelInput" class="form-label">Archery Skill Level</label>
        <input name="archerySkillLevel" type="number" class="form-control" id="archerySkillLevelInput" value={data.user.archerySkillLevel}>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form>

{#if form?.success}
    <h1>Successfully updated</h1>
{/if}

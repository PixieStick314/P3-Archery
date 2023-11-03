<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;
</script>

<form method="POST" action="?/register" class="container-sm mt-5">
    <div class="mb-3">
        <label for="nameInput" class="form-label">First name</label>
        <input name="name" type="text" class="form-control" id="nameInput">
    </div>
    <div class="mb-3">
        <label for="emailInput" class="form-label">Email address</label>
        <input name="email" type="email" class="form-control" id="emailInput" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="passwordInput">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

{#if form?.res.ok}
    <h4>Success!</h4>
{/if}
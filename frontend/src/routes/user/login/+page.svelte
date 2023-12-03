<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;

</script>
<main>
    <h1>Login</h1>
    <form method="POST" action="?/login">
        <label for="email">Email:</label>
        <input name="email" type="email" id="email" required />
        <br />

        <label for="password">Password:</label>
        <input name="password" type="password" id="password" required />
        <br />

        <button type="submit">Login</button>
    </form>

    <p><a href="/forgot-password">Forgot your password?</a></p>
</main>

<style>

</style>
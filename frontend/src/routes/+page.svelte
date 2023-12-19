<script>

    import { browser } from '$app/environment';
    // ...Your other imports

    import {goto} from "$app/navigation";
    import {redirect} from "@sveltejs/kit";

    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;

    $: if (form?.success) {
        if (browser) {
            goto('/event')
        }
    }


/*
    if (data.success == true) {
        if (browser) { // to prevent error window is not defined, because it's SSR
            window.location.href = '/event/';
        }
    } else {
        if (browser) { // to prevent error window is not defined, because it's SSR
            window.location.href = "https://youtu.be/ZZ5LpwO-An4";
        }
    }
*/

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

    {#if form?.success}
        <p>success</p>
        {:else}
        <p>failed</p>
    {/if}
</main>

<style>

</style>
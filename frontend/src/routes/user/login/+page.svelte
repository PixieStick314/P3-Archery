<script>

    //@ts-ignore
    import {setContext} from "svelte";
    import {goto} from "$app/navigation";

    const handleLogin = async (e) => {
        const ACTION_URL = e.target.action;
        const formData = new FormData(e.target);
        const data = new URLSearchParams()
        for (let field of formData) {
            const [key, value] = field;
            data.append(key, value.toString())
        }


        const res = await fetch("http://localhost:8080/user/login", {
            method: 'POST',
            body: JSON.stringify({
                email: data.get("email"),
                password: data.get("password"),
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        });

        if (res.ok) {
            const result = await res.json();
            const user = result;

            if (user != null) {
                console.log(user)
                setContext('user', user);

                await goto('/event');
            } else {
                await goto('')
            }

        }

    }



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
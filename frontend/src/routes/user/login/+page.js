import {writable} from "svelte/store";
import {redirect} from "@sveltejs/kit";
import {createEventDispatcher, setContext} from "svelte";
import {goto} from "$app/navigation";
import {browser} from "$app/environment";

export const ssr = false;

export const actions = {
    //@ts-ignore
    login: async({request}) => {
        const data = await request.formData();
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

        console.log(res)

        if (res.ok) {
            // Redirect to the users event page upon successful login
            const data = await res.json();
            const user = data;

            if (user != null) {
                const token = writable();
                console.log(token)
                setContext('user', user);

                throw redirect(302, '/event')
            } else {
                throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
            }
        } else {
            throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
        }
    }
}
import {writable} from "svelte/store";
import {redirect} from "@sveltejs/kit";

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
                console.log(user)

                return {
                    success: true,
                    user: user
                }

            } else {
                throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
            }
        } else {
            throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
        }
    }
}

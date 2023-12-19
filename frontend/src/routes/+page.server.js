import {writable} from "svelte/store";
import {redirect} from "@sveltejs/kit";

export const actions = {
    //@ts-ignore
    login: async({request, cookies}) => {
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

        //console.log(res)

        if (res.ok) {
            // Redirect to the users event page upon successful login
            const data = await res.json();

            if (data != null) {
                //console.log(data)
                cookies.set('user', data.token,
                    {
                        path: '/',
                    })
                console.log("user cookie: " + cookies.get('user'));

                return {
                    success: true,
                    user: data
                }

            } else {
                throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
            }
        } else {
            throw redirect(302, 'https://youtu.be/dQw4w9WgXcQ')
        }
    }
}

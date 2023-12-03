
export const actions = {
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

        if (res.ok) {
            // Redirect to the users event page upon successful login
            const data = await res.json();
            const { token, user} = data;

            localStorage.setItem('token', token); //    to get the token, use auth.js in components
            localStorage.setItem('user', JSON.stringify(user));

            window.location.href = `/${user.id}/dashboard`; //   not final endpoint.
            return { success: true };
        } else {
            // Handle login failure
            return { success: false };
        }

    }
}
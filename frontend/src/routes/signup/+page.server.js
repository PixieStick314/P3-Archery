/** @type {import('./$types').Actions} */
export const actions = {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    register: async({request}) => {
        const data = await request.formData();
        const user = {
            name: data.get('name'),
            email: data.get('email'),
            password: data.get('password')
        }

        const res = await fetch("http://localhost:8080/user/register", {
            method: 'POST',
            body: JSON.stringify({
                "name": user.name,
                email: user.email,
                password: user.password
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        })

        console.log(res)
        return { success: true, res: res.status }
}
};
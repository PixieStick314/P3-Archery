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

        console.log("Name: " + user.name);
        console.log("Email: " + user.email);
        console.log("Password: " + user.password);

        return { success: true, user: user }
}
};
let userId = "65560d75d6f5ed2df2b46f6a"

export const load = async () => {
    const response = await fetch(`http://localhost:8080/user/${userId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        }
    })
    const user = await response.json();

    console.log(user)

    return { user }
}

export const actions = {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    //@ts-ignore
    update: async({request}) => {
        const data = await request.formData();
        const res = await fetch(`http://localhost:8080/user/update/${userId}`, {
            method: 'POST',
            body: JSON.stringify({
                email: data.get("email"),
                password: data.get("password"),
                name: data.get("name"),
                gender: data.get("gender"),
                address: data.get("address"),
                postcode: data.get("postcode"),
                cellphoneNr: data.get("cellphoneNr"),
                dateOfBirth: data.get("dateOfBirth"),
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        })

        const reply = res.json();

        return { success: true }

    }
};

export const actions = {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    //@ts-ignore
    register: async({request}) => {
        const data = await request.formData();
        const res = await fetch("http://localhost:8080/user/create", {
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
                archerySkillLevel: data.get("archerySkillLevel"),
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        })

        return { success: true }


}
};
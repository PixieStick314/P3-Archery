/** @type {import('./$types').Actions} */

export const actions = {
    create: async({request}) => {
        const data = await request.formData();

        const res = await fetch("http://localhost:8080/create", {
            method: 'POST',
            body: JSON.stringify({
                eventName: data.get("eventName"),
                startTime: data.get("startTime"),
                endTime: data.get("endTime"),
                location: data.get("location"),
                eventType: data.get("eventType"),
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        })

        console.log(res)
    }


}

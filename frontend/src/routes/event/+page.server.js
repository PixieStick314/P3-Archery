export const load = async () => {
    const res = await fetch("http://localhost:8080/event/", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdW1AY3VtLmNvbSIsImlkIjoiNjU3NjI1MTMxYjVmY2Q2ZGMwNmU3ODRkIiwibmFtZSI6InNoaXQiLCJleHAiOjE5MTg4NTQ3NzV9.m9vy1wK8xQBUPSqjjJ5qvCJ2_mAZH9-rckhzR9YYfy0'
        }
    })

    console.log(res)
    if (res.ok) {
        const events = await res.json();
        return {events}
    } else {
        return {events : {} }
    }

}

export const actions = {
    //@ts-ignore
    create: async ({request}) => {
        const data = await request.formData();

        const res = await fetch("http://localhost:8080/event/create", {
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

        //await load();

        console.log(res);
    },

}

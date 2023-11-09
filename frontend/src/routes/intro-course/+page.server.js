export const load = async () => {
    const res = await fetch("http://localhost:8080/event/introcourse", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        }
    })

    const intros = await res.json();

    return { intros }
}
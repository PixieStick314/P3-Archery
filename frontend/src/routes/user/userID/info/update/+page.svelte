<script>
    import {onMount} from 'svelte';

    let userId = "6544dfb97570455370934800"

    let user = {}

    onMount( async () => {
        fetch(`http://localhost:8080/user/${userId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        }).then(response => response.json()).then( data => {user = data })
        console.log(user)
    })

</script>
<div>{user}</div>
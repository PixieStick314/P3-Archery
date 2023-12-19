<script>
    import {createEventDispatcher} from 'svelte';
    import {browser} from "$app/environment";

    const dispatch = createEventDispatcher();

    let testEvent = {
        eventID: "1",
        eventName: "test event",
        eventType: "Placeholder event",
        startTime: "10:00",
        endTime: "14:00",
        location: "Your mum's house"
    }

    export let event = testEvent;

    function register(eventID) {
            dispatch('message', {
                eventID: eventID,

            });
    }

</script>

<form action="/event?/register" method="post">
<div class="row justify-content-center mx-1 my-3">
    <div class="col card">
        <div class="card-body">
            <h5 class="card-title">{event.eventName}</h5>
            <p class="card-text">{event.eventType}</p>
            <p class="card-text">{event.startTime} - {event.endTime}</p>
            <p class="card-text">Location: {event.location}</p>
            <input type="hidden" name = "eventId" value = {event.eventID}>
            <button type="submit" class="btn btn-primary">Tilmeld</button>
        </div>
    </div>
</div>
</form>


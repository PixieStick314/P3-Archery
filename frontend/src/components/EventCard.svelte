<script>
    import { createEventDispatcher } from 'svelte';

    const dispatch = createEventDispatcher();

    let testEvent = {
        eventId: "1",
        eventName: "test event",
        eventType: "Placeholder event",
        startTime: "10:00",
        endTime: "14:00",
        location: "Aalborg"
    }

    export let event = testEvent;

    function register() {
        dispatch('message', {
            eventId: event.eventId
        });
    }

</script>

<div class="row justify-content-center mx-1 my-3">
    <div class="col card">
        <div class="card-body">
            <h5 class="card-title">{event.eventName}</h5>
            <p class="card-text">{event.eventType}</p>
            <p class="card-text">{event.startTime} - {event.endTime}</p>
            <p class="card-text">Location: {event.location}</p>
            <button class="btn btn-primary" on:click={register}>Tilmeld</button>
        </div>
    </div>
</div>


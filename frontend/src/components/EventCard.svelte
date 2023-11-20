<script>

    let testEvent = {
        eventName: "test event",
        eventType: "Placeholder event",
        startTime: "10:00",
        endTime: "14:00",
        location: "Your mum's house"
    }

    export let event = testEvent;

</script>

<div class="row justify-content-center mx-1 my-3">
    <div class="col card">
        <div class="card-body">
            <h5 class="card-title">{event.eventName}</h5>
            <p class="card-text">{event.eventType}</p>
            <p class="card-text">{event.startTime} - {event.endTime}</p>
            <p class="card-text">Location: {event.location}</p>
            <a class="btn btn-primary">Register</a>
        </div>
    </div>
</div>


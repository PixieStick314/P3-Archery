<script>
    export let event = {
        eventTitle: "test title",
        location:  "Ur mums house",
        startTime: "6:00",
        endTime: "9:00"
    };
</script>
<div class="card">
    <div class="card-body">
        <h5>{event.eventTitle}</h5>
        <div>
            <span>Location: {event.location}</span>
            <span>Start time: {event.startTime}</span>
            <span>End time: {event.endTime}</span>
        </div>
        <div>
            <button class="btn btn-primary">Register</button>
            <button class="btn btn-secondary">View</button>
        </div>
    </div>
</div>
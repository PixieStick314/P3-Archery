<script>
    /** @type {import('./$types').PageData} */
    export let data;

    /** @type {import('./$types').ActionData} */
    export let form;



</script>

<form method="POST" action="?/create" class="container-sm mt-5">
    <h1 class="mb-3">Event Creation</h1>
    <div class="mb-3">
        <label for="eventNameInput" class="form-label">Event name</label>
        <input name="eventName" type="text" class="form-control" id="eventNameInput">
    </div>
    <div class="mb-3">
        <label for="startDateInput" class="form-label">Start Date</label>
        <input name="startDate" type="date" id="startDateInput" class="form-control" />
    </div>
    <div class="mb-3">
        <label for="endDateInput" class="form-label">End Date</label>
        <input name="endDate" type="date" id="endDateInput" class="form-control" />
    </div>
    <div class="mb-3">
        <label for="location" class="form-label">Location</label>
        <input name="location" type="text" class="form-control" id="locationInput" />
    </div>
    <div class="mb-3">
        <label for="eventTypeInput" class="form-label">Select an event type</label>
        <select name="eventType" id="eventTypeInput" class="custom-select form-control">
            <option value="TRAINING">Training</option>
            <option value="COMPETITION">Competition</option>
            <option value="INTRO">Intro course</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>

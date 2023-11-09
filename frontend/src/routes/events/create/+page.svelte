<script>
    /** @type {import('../../../../.svelte-kit/types/src/routes').PageData} */
    export let data;

    /** @type {import('../../../../.svelte-kit/types/src/routes').ActionData} */
    export let form;



</script>

<form method="POST" action="?/create" class="container-sm mt-5">
    <h1 class="mb-3">Opret Begivenhed</h1>
    <div class="mb-3">
        <label for="eventNameInput" class="form-label">Titel</label>
        <input name="eventName" type="text" class="form-control" id="eventNameInput">
    </div>
    <div class="mb-3">
        <label for="startDateInput" class="form-label">Begivenheden begynder</label>
        <input name="startDate" type="date" id="startDateInput" class="form-control" />
    </div>
    <div class="mb-3">
        <label for="endDateInput" class="form-label">Begivenheden slutter</label>
        <input name="endDate" type="date" id="endDateInput" class="form-control" />
    </div>
    <div class="mb-3">
        <label for="location" class="form-label">Lokation</label>
        <input name="location" type="text" class="form-control" id="locationInput" />
    </div>
    <div class="mb-3">
        <label for="eventTypeInput" class="form-label">Vælg begivenhedstype</label>
        <select name="eventType" id="eventTypeInput" class="custom-select form-control">
            <option value="TRAINING">Træning</option>
            <option value="COMPETITION">Stævne</option>
            <option value="INTRO">Introkursus</option>
            <option value="EVENT">Andet event</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Opret</button>
</form>
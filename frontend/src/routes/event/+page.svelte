<script>
    import EventCard from "../../components/EventCard.svelte";

    /** @type {import('./$types').PageData} */
    export let data;


</script>

<div class="container pt-2 pb-2 position-relative">
    <button class="btn btn-primary text-white rounded-circle me-3 mt-3 position-absolute end-0 top-0" style='width: 3rem; height: 3rem'>
        <svg fill="none" stroke="currentColor" stroke-width="1.5" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round" d="M12 3c2.755 0 5.455.232 8.083.678.533.09.917.556.917 1.096v1.044a2.25 2.25 0 01-.659 1.591l-5.432 5.432a2.25 2.25 0 00-.659 1.591v2.927a2.25 2.25 0 01-1.244 2.013L9.75 21v-6.568a2.25 2.25 0 00-.659-1.591L3.659 7.409A2.25 2.25 0 013 5.818V4.774c0-.54.384-1.006.917-1.096A48.32 48.32 0 0112 3z"></path>
        </svg>
    </button>
</div>

<div class="container pt-5 text-center">
    {#if data?.events.length > 0}
        {#each data?.events as event}
            <EventCard event={event} />
        {/each}
    {:else}
        <h5>No events</h5>
    {/if}

    <button type="button" data-bs-toggle="modal" data-bs-target="#EventCreater" class="btn btn-primary position-fixed rounded-circle bottom-0 end-0 me-3 mb-3" style='width: 4rem; height: 4rem'>
        <svg fill="white" stroke="white" stroke-width="1.5" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
            <path stroke-linecap="round" stroke-linejoin="round" d="M12 4.5v15m7.5-7.5h-15"></path>
        </svg>
    </button>
</div>

<div class="modal" id="EventCreater">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Opret Begivenhed</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <form method="POST" action="?/create">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="eventNameInput" class="form-label">Titel</label>
                        <input name="eventName" type="text" class="form-control" id="eventNameInput">
                    </div>
                    <div class="mb-3">
                        <label for="startDateInput" class="form-label">Begivenheden begynder</label>
                        <input name="startDate" type="datetime-local" id="startDateInput" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="endDateInput" class="form-label">Begivenheden slutter</label>
                        <input name="endDate" type="datetime-local" id="endDateInput" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="location" class="form-label">Lokation</label>
                        <input name="location" type="text" class="form-control" id="locationInput" placeholder="Vissevej 151" />
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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Tilbage</button>
                    <button type="submit" class="btn btn-primary">Opret</button>
                </div>
            </form>

        </div>
    </div>
</div>
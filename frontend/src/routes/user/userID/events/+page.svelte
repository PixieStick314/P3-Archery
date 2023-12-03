<h1 class="container-sm mt-3">Hej medlem!</h1>

<div class="container sm mt-3">
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#EventViewer">Se event</button>
</div>

<div class="modal" id="EventViewer">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Event title</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                Event description
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Tilbage</button>
                <button type="button" class="btn btn-primary">Redigér</button>
                <button type="button" class="btn btn-primary">Tilmeld</button>
            </div>

        </div>
    </div>
</div>

<div class="container-sm mt-3">
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#EventCreater">Opret begivenhed</button>
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
<script>
    import { onMount } from 'svelte';

    let courses = [];
    let selectedCourse;
    let name = '';
    let email = '';

    onMount(async () => {
        const response = await fetch('event/introcourse');
        courses = await response.json();
    });

    async function addGuestToCourse() {
        if (!selectedCourse) {
            alert('Please select a course');
            return;
        }

        const guestUser = { name, email };
        const response = await fetch(`/event/${selectedCourse}/addGuest`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(guestUser)
        });

        if (response.ok) {
            alert('Guest registered successfully');
        } else {
            alert('Failed to register guest');
        }
    }
</script>

<h1>Vælg et intro kursus:</h1>
<form on:submit|preventDefault={addGuestToCourse} class="container-sm mt-5">
    <div class="mb-3">
        <label for="courseSelect" class="form-label">Kursus</label>
        <select id="courseSelect" bind:value={selectedCourse} class="form-control">
            <option value="" disabled selected>Vælg et kursus</option>
            {#each courses as course}
                <option value={course.id}>{course.eventName}</option>
            {/each}
        </select>
    </div>

    <h2>Gæstebruger information:</h2>
    <div class="mb-3">
        <label for="name" class="form-label">Navn:</label>
        <input type="text" id="name" bind:value={name} class="form-control" required>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">E-mail:</label>
        <input type="email" id="email" bind:value={email} class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary">Registrer</button>
</form>

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
<form on:submit|preventDefault={addGuestToCourse}>
    <select bind:value={selectedCourse}>
        {#each courses as course}
            <option value={course.id}>{course.eventName}</option>
        {/each}
    </select>
    <h2>Gæstebruger information:</h2>
    <label for="name">Navn:</label>
    <input type="text" id="name" bind:value={name} required>
    <br>
    <label for="email">E-mail:</label>
    <input type="email" id="email" bind:value={email} required>
    <br>
    <button type="submit">Registrer</button>
</form>

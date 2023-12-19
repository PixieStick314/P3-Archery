<script>


    import { page } from '$app/stores';

    let isLoggedIn = ($page.data.user != null);

</script>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Aalborg Bueskyttelaug</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                {#if isLoggedIn}
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/event">Begivenheder</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/userID/info">Medlemsskab</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/userID/competitions" class="nav-link">Stævner</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/userID/contact" class="nav-link">Kontakt</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/userID/info" class="nav-link">Min Profil</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/userID/logout" class="nav-link">Log ud</a>
                    </li>
                {:else}
                    <li class="nav-item">
                        <a href="/user/create" class="nav-link">Opret konto</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/login" class="nav-link">Log Ind</a>
                    </li>
                    <li class="nav-item">
                        <a href="http://bueskydningaalborg.dk/" class="nav-link">Bueskydning Aalborg</a>
                    </li>
                {/if}
            </ul>
        </div>
    </div>
</nav>
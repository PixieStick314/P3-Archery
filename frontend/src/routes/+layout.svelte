<script>
    import FBIcon from "$lib/assets/FBcircle.png"
</script>
<nav class="navbar navbar-dark bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Aalborg Bueskyttelaug</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/user/userID/events">Begivenheder</a>
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
                    <a href="/user/userID/myprofile" class="nav-link">Min Profil</a>
                </li>
                <li class="nav-item">
                    <a href="/logout" class="nav-link">Log ud</a>
                    <a href="/user/create" class="nav-link">Opret konto</a>
                </li>
                <li class="nav-item">
                    <a href="/user/userID/logout" class="nav-link">Log ud</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<slot></slot>
<footer>
    <hr>
    <div class="container-sm">
    <div>
        <p>Adresse: Vissevej 151, 9210 Aalborg</p>
        <p>e-mail: formand@bueskydningaalborg.dk</p>
    </div>

    <strong>Følg os:</strong>
    <a class="ms-5" href="https://www.facebook.com/aalborgbueskyttelaug/" target="_blank" rel="noopener noreferrer">
        <img alt="Facebook circle" src={FBIcon} width="60p" height="60p">
    </a>
    </div>
</footer>
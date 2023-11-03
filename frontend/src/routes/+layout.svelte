<nav class="navbar navbar-dark bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Aalborg Bueskyttelaug</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Begivenheder</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Medlemsskab</a>
                </li>
                <li class="nav-item">
                    <a href="/competitions" class="nav-link">Stævner</a>
                </li>
                <li class="nav-item">
                    <a href="/logout" class="nav-link">Log ud</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<slot></slot>
<footer>
    <hr>
    <div class="ms-5">
        <p>Adresse: Vissevej 151, 9210 Aalborg</p>
        <p>e-mail: formand@bueskydningaalborg.dk</p>
    </div>

    <strong class="ms-5">Følg os:</strong>
    <a class="ms-5" href="https://www.facebook.com/aalborgbueskyttelaug/" target="_blank" rel="noopener noreferrer">
        <img alt="Facebook circle" src="FBcircle.png" width="60p" height="60p">
    </a>
</footer>
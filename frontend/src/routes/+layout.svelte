<script>
    import FBIcon from "$lib/assets/FBcircle.png";
    import BueskytteIcon from "$lib/assets/aalborg-bueskyttelaug-logo.png"


</script>

<style>
    .site-header {
        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
    }
    .row {
        display: flex;
        flex-wrap: wrap;
        margin-right: 1%;
        align-items: center;
        -webkit-box-align: center;
        width: 100%;
    }
    .container-fluid {
        padding: 0 5%;
    }
    .navbar {
        height: 22%;
        padding: 2% 0;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 999;
    }
    .main-navigation{
    }
    .banner-image {
        background-image: url("$lib/assets/frontpage-aabueskyttelaug.png");
        background-position: center center;
        background-repeat: no-repeat;
        background-size: cover;
        transition: background 0.3s, border 0.3s, border-radius 0.3s, box-shadow 0.3s;
        position: relative;
        height: 700px !important;
    }

    .color-overlay {
        background-color: #04081d;
        opacity: 0.5;
        transition: background 0.3s, border-radius 0.3s, opacity 0.3s;
        height: 100%;
        width: 100%;
        top: 0;
        left: 0;
        position: absolute;
    }
    .nav-item{
        display: inline-block;
        position: relative;
        padding: 0 2%;
        padding-left: 6%;
        font-family: "Arial",serif;
    }
</style>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark site-header" data-bs-theme="dark">
    <div class="container-fluid">
        <div class="row">
            <div class="site-branding col-md-4 col-sm-6 col-9">
                <a class="custom-logo-link" href="/">
                    <img class="custom-logo" width="103" height="125" src={BueskytteIcon} alt="Aalborg bueskyttelaug">
                </a>
            </div>
            <div id="site-navigation" class="main-navigation col-md-8" style ="top: auto;">
                <button class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" style="padding-left: 1%" id="navbarSupportedContent">
                    <ul class="navbar-nav" style="text-align: right">
                        <li class="nav-item">
                            <a aria-current="page" class="nav-link text-white fs-6 fw-medium" href="/event">Begivenheder</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/userID/info" class="nav-link text-white fs-6">Medlemsskab</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/userID/competitions" class="nav-link text-white fs-6">Stævner</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/userID/contact" class="nav-link text-white fs-6">Kontakt</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/userID/info" class="nav-link text-white fs-6">Min Profil</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/create" class="nav-link text-white fs-6">Opret konto</a>
                        </li>
                        <li class="nav-item">
                            <a href="/user/userID/logout" class="nav-link text-white text fs-6">Log ud</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="banner-image w-100 vh-100 d-flex justify-content-center align-items-center">
<div class="color-overlay"></div>
</div>



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
<script>
    import FBIcon from "$lib/assets/FBcircle.png";
    import BueskytteIcon from "$lib/assets/aalborg-bueskyttelaug-logo.png"
    import { onMount } from "svelte";

    let isScrolled = false;

    onMount(() => {
        window.addEventListener("scroll", handleScroll);
        return () => {
            window.removeEventListener("scroll", handleScroll);
        };
    });

    function handleScroll() {
        isScrolled = window.scrollY > 1;
    }

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
        height: 20%;
        width: 100%;
        top: 0;
        left: 0;
        z-index: 999;
        transition: background-color 0.3s ease;
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
        padding: 0 5%;
        padding-left: 8%;
        font-family: "Arial",serif;
    }
    .imgScrolled {
        height: 15%;
        width: 15%;
    }
    .navbar-scrolled {
        background-color: #13151d; /* Change the background color when scrolled */
        height: 17.2%;
    }
    .navbar-collapse{
        padding-left: 1%;
    }
    .navbar-nav {
        text-align: left;
    }
    @media (max-width: 768px) {
        .navbar {
            height: 30%;
            background-color: #13151d;
            position: relative;
        }
        .main-navigation{
            width: 100%;
        }
        .navbar-collapse{
            position: relative;
        }
        .navbar-scrolled {
            position: relative !important;
        }
        .custom-logo {
            height: 40%;
            width: 40%;
        }
        .banner-image {
            height: 0 !important;
        }
        ul {
            padding-right: 100%;
        }
        .navbar-toggler{
            width: 20%;
        }
        .navbar-nav {
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            width: 100%;
            padding-left: 55%;
        }
        .navbar-nav .nav-item {
            display: inline-block;
        }

        .navbar-nav .nav-link {
            white-space: nowrap; /* Prevent text from wrapping */
        }
    }
</style>

<nav class:navbar-scrolled={isScrolled} class="navbar fixed-top navbar-expand-lg navbar-dark site-header" data-bs-theme="dark">
    <div class="container-fluid">
        <div class="row">
            <div class="site-branding col-md-4 col-sm-6 col-9">
                <a class="custom-logo-link" href="/">
                    <img class:imgScrolled={isScrolled} class="custom-logo" width="103rem" height="125rem" src={BueskytteIcon} alt="Aalborg bueskyttelaug">
                </a>
            </div>
            <button class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="site-navigation" class="main-navigation col-md-8" style ="top: auto;">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
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
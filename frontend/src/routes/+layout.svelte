<script>
    import Navbar from "../components/Navbar.svelte";
    import Footer from "../components/Footer.svelte";
    import {writable} from "svelte/store";
    import {setContext} from "svelte";

</script>

<Navbar></Navbar>
<slot></slot>
<Footer></Footer>
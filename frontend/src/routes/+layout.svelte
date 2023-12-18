<script>
    import Navbar from "../components/Navbar.svelte";
    import Footer from "../components/Footer.svelte";
    import {writable} from "svelte/store";
    import {setContext} from "svelte";


    /** @type {import('./$types').LayoutData} */
    export let data;

    const user = writable();
    $: user.set(data.user);

    setContext('user', user)

</script>

<Navbar></Navbar>
<slot></slot>
<Footer></Footer>
import {writable} from "svelte/store";

export const user = writable();

user.subscribe((value) => {
    console.log(value)
})


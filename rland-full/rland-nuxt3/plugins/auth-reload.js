export default defineNuxtPlugin(nuxtApp => {
    const userDetails = useUserDetails();

    if (import.meta.client) {
        userDetails.loadUserFormStorage();
    }
});
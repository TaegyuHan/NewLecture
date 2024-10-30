import { defineNuxtPlugin } from '#app'
import vue3GoogleLogin from 'vue3-google-login'

export default defineNuxtPlugin((nuxtApp) => {
    nuxtApp.vueApp.use(vue3GoogleLogin, {
        clientId: '832799148144-t33upcsv9co54pic50kidk2n6t6vdrhc.apps.googleusercontent.com'
    })
})
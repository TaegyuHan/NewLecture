import { createApp } from 'vue'
import { createMemoryHistory, createRouter, createWebHistory } from 'vue-router';

// 2.0 Option API
// const App = {
//     data() {
//         return {
//             x: 20
//         };
//     },
//     template: `<div>result: {{x}}</div>`
// };

import App from './App.vue'
import adminRouter from "@/pages/admin/router.js";
import anonymousRouter from "@/pages/menu/router.js";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        anonymousRouter,
        adminRouter
    ]
});

let app = createApp(App);
app.use(router);
app.mount('#app');
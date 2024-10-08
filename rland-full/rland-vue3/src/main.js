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

import Default from "@/layouts/Default.vue";
import MenuList from '@/pages/menu/list.vue'
import MenuDetail from '@/pages/menu/detail.vue'

import Admin from "@/layouts/Admin.vue";
import AdminMenuList from "@/pages/admin/menu/AdminMenuList.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            children: [
                { path: 'menu/list', component: MenuList },
                { path: 'menu/detail', component: MenuDetail }
            ],
            component: Default
        },
        {
            path: '/admin',
            children: [
                { path: 'menu/list', component: AdminMenuList }
            ],
            component: Admin
        }
    ]
});

let app = createApp(App);
app.use(router);
app.mount('#app');
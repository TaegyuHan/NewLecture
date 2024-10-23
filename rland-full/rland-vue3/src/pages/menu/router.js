import Index from "@/pages/Index.vue";
import MenuList from "@/pages/menu/List.vue";
import MenuDetail from "@/pages/menu/Detail.vue";
import Default from "@/layouts/Default.vue";

export default {
    path: '/',
    children: [
        { path: '', component: Index },
        { path: 'menu/list', component: MenuList },
        { path: 'menu/detail', component: MenuDetail }
    ],
    component: Default,
    // redirect: '/index'
}
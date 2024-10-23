import Index from "@/pages/admin/AdminIndex.vue";
import Admin from "@/layouts/Admin.vue";
import MenuIndex from "@/pages/admin/menu/List.vue";
import MenuNew from "@/pages/admin/menu/New.vue";
import MenuDetail from "@/pages/admin/menu/Detail.vue";
import MenuEdit from "@/pages/admin/menu/Edit.vue";

// 구글 봇이 주기적으로 나의 조회수를 올려준다.
export default {
    path: '/admin',
    children: [
        { path: 'index', component: Index },
        { path: 'menus',
            children: [
                // admin/menus
                { path: '', component: MenuIndex },
                // admin/menus/12
                { path: ':id', component: MenuDetail },
                // admin/menus/new
                { path: 'new', component: MenuNew },
                // admin/menus/12/edit
                { path: ':id/edit', component: MenuEdit }
            ]
        }
    ],
    component: Admin
}
import Timestamp from "./component/Timestamp.vue";
import * as VueRouter from 'vue-router'

const routes = [
    { path: '/timestamp', component: Timestamp }
]

export const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
})
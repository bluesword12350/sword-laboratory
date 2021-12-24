import Timestamp from "./page/Timestamp.vue";
import ModalTest from "./page/ModalTest.vue";
import * as VueRouter from 'vue-router'

const routes = [
    { path: '/timestamp', component: Timestamp },
    { path: '/modal-test', component: ModalTest }
]

export const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
})
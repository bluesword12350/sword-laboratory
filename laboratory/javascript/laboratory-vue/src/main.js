import { createApp } from 'vue'
import App from './App.vue'
import * as VueRouter from 'vue-router'
import Timestamp from "./components/Timestamp.vue";

const routes = [
    { path: '/timestamp', component: Timestamp }
]

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
})

createApp(App).use(router).mount('#app')

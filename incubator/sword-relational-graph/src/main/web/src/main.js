import { createApp } from 'vue'
import App from './App.vue'
import * as VueRouter from 'vue-router'

const routes = [
]

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes,
})

createApp(App).use(router).mount('#app')

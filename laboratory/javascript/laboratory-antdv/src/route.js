import Vue from 'vue';
import Timestamp from "@/component/Timestamp";
import VueRouter from "vue-router";

Vue.use(VueRouter)

const routes = [
    { path: '/timestamp', component: Timestamp }
]

export const router = new VueRouter({
    routes
})
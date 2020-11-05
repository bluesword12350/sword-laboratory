import Vue from 'vue';
import VueRouter from "vue-router";
import JsonEditor from "./editor/JsonEditor";
import UrlEditor from "./editor/UrlEditor";

Vue.use(VueRouter)

const routes = [
    { path: '/json-editor', component: JsonEditor },
    { path: '/url-editor', component: UrlEditor }
]

export const router = new VueRouter({
    routes
})
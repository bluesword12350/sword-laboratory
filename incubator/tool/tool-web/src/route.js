import Vue from 'vue';
import VueRouter from "vue-router";
import JsonEditor from "./editor/JsonEditor";
import UrlEditor from "./editor/UrlEditor";
import Timestamp from "./editor/Timestamp";

Vue.use(VueRouter)

const routes = [
    { path: '/json-editor', component: JsonEditor },
    { path: '/url-editor', component: UrlEditor },
    { path: '/timestamp', component: Timestamp },
]

export const router = new VueRouter({
    routes
})
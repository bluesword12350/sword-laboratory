import Vue from 'vue';
import VueRouter from "vue-router";
import JsonEditor from "./editor/JsonEditor";
import UrlEditor from "./editor/UrlEditor";
import Timestamp from "./editor/Timestamp";
import DislodgeEscape from "@/editor/DislodgeEscape";

Vue.use(VueRouter)

const routes = [
    { path: '/json-editor', component: JsonEditor },
    { path: '/url-editor', component: UrlEditor },
    { path: '/timestamp', component: Timestamp },
    { path: '/dislodge-escape', component: DislodgeEscape },
]

export const router = new VueRouter({
    routes
})
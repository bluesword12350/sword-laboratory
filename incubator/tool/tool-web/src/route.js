import Vue from 'vue';
import VueRouter from "vue-router";
import JsonEditor from "./editor/JsonEditor";
import UrlEditor from "./editor/UrlEditor";
import Timestamp from "./editor/Timestamp";
import JsonEditor2 from "@/editor/JsonEditor2";

Vue.use(VueRouter)

const routes = [
    { path: '/json-editor', component: JsonEditor },
    { path: '/url-editor', component: UrlEditor },
    { path: '/timestamp', component: Timestamp },
    { path: '/json-editor2', component: JsonEditor2 },
]

export const router = new VueRouter({
    routes
})
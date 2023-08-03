import { createApp } from 'vue'
import App from './App.vue'
import 'element-plus/dist/index.css'
import * as VueRouter from 'vue-router'
import JsonEditor from "./components/editor/JsonEditor.vue";
import UrlEditor from "./components/editor/UrlEditor.vue";
import Timestamp from "./components/editor/Timestamp.vue";
import DislodgeEscape from "./components/editor/DislodgeEscape.vue";

const routes = [
  { path: '/json-editor', component: JsonEditor },
  { path: '/url-editor', component: UrlEditor },
  { path: '/timestamp', component: Timestamp },
  { path: '/dislodge-escape', component: DislodgeEscape },
]

const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes,
})

createApp(App).use(router).mount('#app')

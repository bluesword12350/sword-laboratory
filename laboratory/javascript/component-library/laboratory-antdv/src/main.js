import {createApp} from 'vue'
import App from './App.vue';
import 'ant-design-vue/dist/antd.css';
import {router} from "./route"
import Antd from 'ant-design-vue';

const app = createApp(App);
app.use(router).use(Antd).mount('#app')

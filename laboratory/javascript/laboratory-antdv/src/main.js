import Vue from 'vue';
import App from './App';
import VueRouter from 'vue-router'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import Timestamp from "./component/Timestamp";

Vue.config.productionTip = false;
Vue.use(Antd);
Vue.use(VueRouter)

const routes = [
  { path: '/timestamp', component: Timestamp }
]

const router = new VueRouter({
  routes
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');

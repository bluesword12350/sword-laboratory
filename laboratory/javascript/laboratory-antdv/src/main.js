import Vue from 'vue';
import App from './App';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import {router} from "./route"

Vue.config.productionTip = false;
Vue.use(Antd);

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');

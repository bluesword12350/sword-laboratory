import Vue from 'vue';
import App from './App';
import 'ant-design-vue/dist/antd.css';

Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
}).$mount('#app')

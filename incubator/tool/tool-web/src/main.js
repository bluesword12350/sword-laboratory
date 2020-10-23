import Vue from 'vue';
import App from './App';
import "jsoneditor/dist/jsoneditor.min.css"

Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
}).$mount('#app');

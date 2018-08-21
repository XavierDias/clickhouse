import Vue from 'vue'

import '@babel/polyfill'
import './plugins/vuetify'

import App from './App.vue'
import router from './router'

import VueResource from 'vue-resource';

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');

Vue.use(VueResource);


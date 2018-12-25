import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/js/jquery.js'
import './assets/css/style.css'
import './assets/js/gwc.js'
import './assets/js/paging.js'
import './assets/js/qwest.min.js'
import './assets/js/main.js'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
Vue.config.productionTip = false
// import $ from 'jquery'

Vue.use(iView);
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

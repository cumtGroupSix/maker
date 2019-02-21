import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/js/jquery.js'
import './assets/css/style.css'
import './assets/js/paging.js'
import './assets/js/qwest.min.js'
import './assets/js/main.js'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import axios from 'axios'
import VueAxios from 'vue-axios'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
Vue.config.productionTip = false
// import $ from 'jquery'

router.beforeEach((to, from, next) => {
  // 验证是否存在 JWT Token
  var token=localStorage.getItem('token');
  var makertoken=localStorage.getItem('makertoken');
  var admintoken=localStorage.getItem('admintoken');
  if(token && token!="undefined"){ 
  		//如果存在token,验证是否过期(2小时过期)
		if(Date.now()-localStorage.getItem('tokenTime')>60*60*2*1000){
			localStorage.removeItem('token');
			localStorage.removeItem('tokenTime');
			next('/');
		} else{
		//如果没有过期
      next(); 
    	} 	
	}else if(makertoken && makertoken!="undefined"){
    //如果存在makertoken,验证是否过期(2小时过期)
    if(Date.now()-localStorage.getItem('makertokenTime')>60*60*2*1000){
      localStorage.removeItem('makertoken');
      localStorage.removeItem('makertokenTime');
      next('/');
    }else{
    //如果没有过期
      next();
      } 
  }else if(admintoken && admintoken!="undefined"){
    //如果存在admintoken,验证是否过期(2小时过期)
    if(Date.now()-localStorage.getItem('admintokenTime')>60*60*2*1000){
      localStorage.removeItem('admintoken');
      localStorage.removeItem('admintokenTime');
      next('/');
    }else{
    //如果没有过期
      next();
      } 
  }else{
    	//如果不存在token也不存在makertoken或admintoken
      //如果是不需要登录的路径
        var paths=['/','/changepassword','/admin','/register','/makerlogin','/makerregister']
        if(paths.indexOf(to.path)>=0){ 
        //直接next()
            next();
        } else { 
        //否则跳转到主页；
            next('/');
        }
    }
});

axios.interceptors.request.use(
  config => {
  	// 判断是否存在相应token，如果存在的话，则每个http header都加上token
    if (localStorage.getItem('token')&&localStorage.getItem('token')!="undefined") {  
      config.headers.Authorization = JSON.parse(localStorage.getItem('token'));
    }else if(localStorage.getItem('makertoken')&&localStorage.getItem('makertoken')!="undefined"){
      config.headers.Authorization = JSON.parse(localStorage.getItem('makertoken'));
    }
    else if(localStorage.getItem('admintoken')&&localStorage.getItem('admintoken')!="undefined"){
      config.headers.Authorization = JSON.parse(localStorage.getItem('admintoken'));
    }
    return config;
  },
  err => {
    return Promise.reject(err);
  });

Vue.use(VueAxios, axios)
Vue.use(iView);
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotStore:[],
    checkedProduct:'',
    active:"1",
    loginresponse:null,
    validateImg:"/api/code/image",
    userid:null,
    username:null,
    orderid:null,
    cartmain:{},
  	cartarr:[],
    cartid:null,
    cartchecked:[]
  },
  mutations: {
  },
  actions: {

  }
})

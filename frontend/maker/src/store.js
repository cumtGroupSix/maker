import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotStore:[],
    checkedProduct:'',
    active:"1",
    loginresponse:null,
    inforesponse:{},
    makerloginresponse:null,
    adminloginresponse:null,
    validateImg:"/api/code/image",
    userid:null,
    username:null,
    orderid:null,
    cartmain:{},
  	cartarr:[],
    cartid:null,
    cartchecked:[],
    currentStore:{},
    currentProductGroupId:null
  },
  mutations: {
  },
  actions: {

  }
})

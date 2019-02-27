import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotStore:[],
    checkedProduct:'',
    pricesum:0,
    productsum:0,
    active:"1",
    loginresponse:null,
    inforesponse:{},
    makerloginresponse:null,
    adminloginresponse:null,
    validateImg:"/api/code/image",
    userid:null,
    username:null,
    orderid:1,
    cartmain:{},
  	cartarr:[],
    cartid:null,
    cartchecked:[],
    currentStore:{},
    currentProductGroupId:null,
    currentCategoryId:null
  },
  mutations: {
  },
  actions: {

  }
})

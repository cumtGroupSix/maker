import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotStore:[],
    checkedProduct:'',
    active:"1",
    userid:1,
    cartmain:{},
  	cartarr:[],
    cartid:0,
    cartchecked:[]
  },
  mutations: {
  },
  actions: {

  }
})

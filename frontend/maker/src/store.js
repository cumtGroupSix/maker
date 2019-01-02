import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    hotStore:[],
    checkedProduct:'',
    active:"1",
    cartmain:{},
  	cartarr:[]
  },
  mutations: {
  	resetCartarr(state,msg){
  		state.cartarr=[];
  	}
  },
  actions: {

  }
})

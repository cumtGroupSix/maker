import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

let LS = window.sessionStorage
const LStorage = {
  getItem(key){
    try{
      return JSON.parse(LS.getItem(key))
    }catch(error){
      return null
    }
  },
  setItem:(key,val) =>{
    LS.setItem(key,JSON.stringify(val))
  },
  clear(){
    LS.clear()
  },
  removeItem(key){
    LS.removeItem(key)
  }
}

const myPlugins = (socket) =>{
  return store =>{
    socket.session.map(evl =>{
      if(LStorage.getItem(evl.key)){
        store.commit(evl.commitFun,LStorage.getItem(evl.key))
      }
    })
    store.subscribe((mutation,state)=>{
      socket.session.map(evl =>{
        LStorage.setItem(evl.key,state[evl.module][evl.key])
      })
    })
  }
}

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
    orderid:null,
    cartmain:{},
  	cartarr:[],
    cartid:null,
    cartchecked:[],
    currentStore:{},
    currentGroup:{},
    currentProductGroupId:null,
    currentCategoryId:null
  },
  mutations: {
    changeCurrentStore(state,val){
      state.currentStore = val
    }
  },
  actions: {

  },
  plugins: [myPlugins({
    session: [
      {
        key: '需要保存的字段',
        module: 'modules模块，可以根据自己的路径决定需不需要这个参数',
        commitFun: 'commit方法'
      }
    ]
  })]
})

import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/index/index'
import Stores from './views/stores/stores'
import Store from './views/store/store'
import Product from './views/product/product'
import Cart from './views/cart/cart'
import Receiver from './views/receiver/receiver'
import Register from './views/register/register'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/stores',
      name: 'stores',
      component: Stores
    },
    {
      path: '/store',
      name: 'store',
      component: Store
    },
    {
      path: '/product',
      name: 'product',
      component: Product
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart
    },
    {
      path: '/receiver',
      name: 'receiver',
      component: Receiver
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    }
  ]
})

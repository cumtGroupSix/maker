import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/index/index'
import Stores from './views/stores/stores'
import Store from './views/store/store'
import Product from './views/product/product'
import ProductList from './views/productList/productList'
import Cart from './views/cart/cart'
import Receiver from './views/receiver/receiver'
import Register from './views/register/register'
import OrderDetail from './views/orderDetail/orderDetail'
import Order from './views/order/order'
import User from './views/user/user'
import Browse from './views/browse/browse'
import Evaluate from './views/evaluate/evaluate'
import MyProduct from './views/myProduct/myProduct'
import MyStore from './views/myStore/myStore'
import GoodsList from './views/goodslist/goodslist'
import Payment from './views/payment/payment'
import Chuangke from './views/chuangkeAdministration/chuangkeAdministration'


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
      path: '/productList',
      name: 'productList',
      component: ProductList
     },
    {
      path: '/order',
      name: 'order',
      component: Order
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
    },
    {
      path: '/orderDetail',
      name: 'orderDetail',
      component: OrderDetail
    },
    {
      path: '/goodslist',
      name: 'goodslist',
      component: GoodsList
    },
    {
      path: '/payment',
      name: 'payment',
      component: Payment
    },
    {
      path: '/chuangkeAdministration',
      name: 'chuangkeAdministration',
      component: Chuangke
    },
    {
      path: '/user',
      name: 'user',
      component: User,
      children: [
        {
          path: '/user/browse',
          name: 'browse',
          component: Browse
        },
        {
          path: '/user/evaluate',
          name: 'evaluate',
          component: Evaluate
        },
        {
          path: '/user/myProduct',
          name: 'myProduct',
          component: MyProduct
        },
        {
          path: '/user/myStore',
          name: 'myStore',
          component: MyStore
        },
      ]
    }
  ]
})

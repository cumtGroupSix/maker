import Vue from 'vue'
import Router from 'vue-router'
import Index from './views/index/index'
import Stores from './views/stores/stores'
import Store from './views/store/store'
import Product from './views/product/product'
import ProductList from './views/productList/productList'
import Cart from './views/cart/cart'
import Comment from './views/comment/comment'
import Receiver from './views/receiver/receiver'
import Register from './views/register/register'
import OrderDetail from './views/orderDetail/orderDetail'
import OrderSubmit from './views/orderSubmit/orderSubmit'
import Order from './views/order/order'
import User from './views/user/user'
import ChangePassword from './views/changePassword/changePassword'
import Browse from './views/browse/browse'
import Evaluate from './views/evaluate/evaluate'
import MyProduct from './views/myProduct/myProduct'
import MyStore from './views/myStore/myStore'
import GoodsList from './views/goodslist/goodslist'
import Payment from './views/payment/payment'
import Chuangke from './views/chuangkeAdministration/chuangkeAdministration'
import ChuangkeLogin from './views/chuangkeLogin/chuangkeLogin'
import ChuangkeRegister from './views/chuangkeRegister/chuangkeRegister'
import AdminLogin from './views/adminLogin/adminLogin'
import AdminManager from './views/adminManager/adminManager'
import UserRegister from './views/adminUserRegister/userRegister'
import MakerRegister from './views/adminMakerRegister/makerRegister'
import DeleteUser from './views/adminDeleteUser/deleteUser'
import ResetPassword from './views/adminResetPassword/resetPassword'
import ChangeInfo from './views/adminChangeInfo/changeInfo'
import userChangeInfo from './views/userChangeInfo/userChangeInfo'
import FindPassword from './views/findPassword/findPassword'
import Supplier from './views/supplier/supplier.vue'
import AdminSoldSum from './views/adminSoldSum/adminSoldSum'
import AdminUserInfo from './views/adminUserInfo/adminUserInfo'
import SupplierProduct from './views/supplierProduct/supplierProduct.vue'
import SupplierAddProduct from './views/supplierAddProduct/supplierAddProduct.vue'
import SupplierUpdateProduct from './views/supplierUpdateProduct/supplierUpdateProduct.vue'





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
      path: '/makerlogin',
      name: 'makerlogin',
      component: ChuangkeLogin
    },
    {
      path: '/admin',
      name: 'adminlogin',
      component: AdminLogin
    },
    {
      path: '/adminmanager',
      name: 'adminmanager',
      component: AdminManager,
      children:[
      {
      path: '/adminmanager/deleteuser',
      name: 'deleteuser',
      component: DeleteUser
      },
      {
      path: '/adminmanager/userinfo',
      name: 'adminuserinfo',
      component: AdminUserInfo
      },
      {
      path: '/adminmanager/soldsum',
      name: 'adminsoldsum',
      component: AdminSoldSum
      },
      {
      path: '/adminmanager/userregister',
      name: 'userregister',
      component: UserRegister
      },
      {
      path: '/adminmanager/makerregister',
      name: 'adminmakerregister',
      component: MakerRegister
      },
      {
      path: '/adminmanager/resetpassword',
      name: 'resetpassword',
      component: ResetPassword
      },
      {
      path: '/adminmanager/changeinfo',
      name: 'changeinfo',
      component: ChangeInfo
      },
      ]
    },
    {
      path: '/makerregister',
      name: 'makerregister',
      component: ChuangkeRegister
    },
    {
      path: '/findpassword',
      name: 'findpassword',
      component: FindPassword
    },
    {
      path: '/changepassword',
      name: 'changepassword',
      component: ChangePassword
    },
    {
      path: '/product',
      name: 'product',
      component: Product
    },
    {
      path: '/comment',
      name: 'comment',
      component: Comment
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
      path: '/orderSubmit',
      name: 'orderSubmit',
      component: OrderSubmit
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
        {
            path: '/user/changeInfo',
            name: 'changeInfo',
            component: userChangeInfo
        },
      ]
    },
  {
      path: '/supplier',
      name: 'supplier',
      component: Supplier,
      children: [
        {
          path: '/supplier',
          name: 'supplierProduct',
          component: SupplierProduct
        },
        {
          path: '/supplier/addproduct',
          name: 'addproduct',
          component: SupplierAddProduct
        },
        {
          path: '/supplier/updateproduct',
          name: 'updateproduct',
          component: SupplierUpdateProduct
        }
      ]
    },
    {
      path: '/comment' ,
      name: 'comment',
      component: Comment
    }
  ]
})


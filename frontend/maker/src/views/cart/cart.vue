<template>
<div class="container" id='root'>
		<div class="row " id='gwc-row1'>
			<div class="col-6 text-left gwc-h3"><h3><b>购物车</b></h3></div>
			<div class="col-6 text-right gwc-h6"><router-link  to="/order" class='text-right' style='color: #ff9966;'>已完成订单</router-link></div>
		</div>
		<div class="row">
			<div class="col-12" id='gwc-row2'><hr class="gwc-hr"></div>	
		</div>
		<div class="container">
		<div class="row" style='font-size:12px;margin-bottom: 20px;margin-top: 10px;'>
			<div class="col-2 d-none d-lg-block" style='padding-left: 0px;'><input :disabled='cartisnull' type="checkbox" style='vertical-align: middle' id='gwc-checkall1' @click='checkall' :checked='ckall'><label for="gwc-checkall1" class='gwc-unselect'>全选</label></div>
			<div class="col-3 d-none d-lg-block">商品信息</div>
			<div class="col-2 d-none d-lg-block"></div>
			<div class="col-1 d-none d-lg-block text-center">单价</div>
			<div class="col-2 d-none d-lg-block text-center">数量</div>
			<div class="col-1 d-none d-lg-block">金额</div>
			<div class="col-1 d-none d-lg-block">操作</div>
		</div>
		</div>
		<div class="container">
		<div class="row" style='font-size:12px;padding-top: 10px;margin-bottom: -40px;margin-top: -30px;'>
			<div class="col-2 d-none d-md-block d-lg-none" style='padding-left: 0px;'><input :disabled='cartisnull' type="checkbox" style='vertical-align: middle' id='gwc-checkall1' @click='checkall' :checked='ckall'><label for="gwc-checkall1" class='gwc-unselect'>全选</label></div>
			<div class="col-3 d-none d-md-block d-lg-none" style='padding-left: 20px;'>商品信息</div>
			<div class="col-1 d-none d-md-block d-lg-none"></div>
			<div class="col-1 d-none d-md-block d-lg-none text-center">单价</div>
			<div class="col-2 d-none d-md-block d-lg-none text-center">数量</div>
			<div class="col-1 d-none d-md-block d-lg-none">金额</div>
			<div class="col-2 d-none d-md-block d-lg-none" style='padding-left: 40px;'>操作</div>
		</div>
		</div>
		<div class="container" v-if='this.cartisnull' style='margin-top:45px;margin-bottom:15px;'>
			<div class="row kmain">
				<div class="col-12 text-center align-self-center">
					<div class='kong'>购物车为空</div>
				</div>
			</div>
		</div>
		<gwc-component v-for='(item,index) in cartarr' :key='index' :item='item' @aallck='allck' ref="one" @ns='nums' @ps='prices' @updatequantity='axiosupdate' @deleteone='axiosdelete' @collectone='axioscollect'></gwc-component>
		<div class="container" style='margin-top:15px;'> 
			<div class="row">
			<div class="col-12 d-none d-lg-block">
			<div class="row gwc-bar" style='font-size:12px;'>
			<div class="col-1 d-none d-lg-block text-left" style='padding-left: 5px;padding-top: 9px;'><input :disabled='cartisnull' type="checkbox" style='vertical-align: middle' id='gwc-checkall2' @click='checkall'  :checked='ckall'><label for="gwc-checkall2" class='gwc-unselect'>全选</label></div>
			<div class="col-3">
			<div class="row">
			<div class="col-3 d-none d-lg-block text-left" style='padding-left: 0px;padding-top: 9px;'><div @click='deletea' id='delete-all' class='gwc-unselect' style='cursor:pointer'>删除</div></div>
			<div class="col-4 d-none d-lg-block text-left" style='padding-left: 0px;padding-top: 9px;cursor:pointer' @click='collecta'>移入收藏夹</div>
			<div class="col-3 d-none d-lg-block text-left" style='padding-left: 0px;padding-top: 9px;'>分享</div>
		    </div>
			</div>
			<div class="col-4 offset-3 d-none d-lg-block">
			<div class="row">
			<div class="col-5 d-none d-lg-block" style='padding-left: 0px;'>已选商品：<span class='gwc-number gwc-unselect'>{{spsum}}</span>&nbsp;件</div>
			<div class="col-7 d-none d-lg-block" style='padding-right: 0px;'>合计(不含运费)：<span class="gwc-number gwc-unselect">{{pricesum}}</span></div></div>
			</div>
			<div class="col-1 d-none d-lg-block text-right" style='padding-right: 0px;'>
			<a :href="spsum==0?'JavaScript:void(0)':'receiver.html'" class="btn btn-info btn-js text-center" style='background-color:#ff9966;color:white;width: 100%;height:40px;border:none;'>结算</button></a>
			</div>	
			</div>
			</div>
		</div>
		<div class="container" style='margin-top: 15px;'> 
			<div class="row">
			<div class="col-12 d-none d-md-block d-lg-none">
			<div class="row gwc-bar" style='font-size:12px;'>
			<div class="col-1 d-none d-md-block d-lg-none text-left" style='padding-left: 5px;padding-top: 9px;'><input :disabled='cartisnull' type="checkbox" style='vertical-align: middle' id='gwc-checkall2' @click='checkall'  :checked='ckall'><label for="gwc-checkall2" class='gwc-unselect'>全选</label></div>
			<div class="col-4">
			<div class="row">
			<div class="col-3 d-none d-md-block d-lg-none text-left" style='padding-left: 0px;padding-top: 9px;'><div @click='deletea' id='delete-all' class='gwc-unselect' style='cursor:pointer'>删除</div></div>
			<div class="col-4 d-none d-md-block d-lg-none text-left" style='padding-left: 0px;padding-top: 9px;cursor:pointer' @click='collecta'>移入收藏夹</div>
			<div class="col-3 d-none d-md-block d-lg-none text-left" style='padding-left: 0px;padding-top: 9px;'>分享</div>
		    </div>
			</div>
			<div class="col-5 d-none d-md-block d-lg-none">
			<div class="row">
			<div class="col-5 d-none d-md-block d-lg-none" style='padding-left: 0px;'>已选商品：<span class='gwc-number gwc-unselect'>{{spsum}}</span>&nbsp;件</div>
			<div class="col-7 d-none d-md-block d-lg-none" style='padding-right: 0px;'>合计(不含运费)：<span class="gwc-number gwc-unselect">{{pricesum}}</span></div></div>
			</div>
			<div class="col-2 d-none d-md-block d-lg-none text-right" style='padding-right: 0px;'>
			<a :href="spsum==0?'JavaScript:void(0)':'receiver.html'" class="btn btn-info btn-js text-center" style='background-color:#ff9966;color:white;width: 100%;height:40px;border:none;'>结算</a></div>
			</div>	
			</div>
			</div>
		</div>
		<div class="container" style='margin-top: 15px;'> 
			<div class="row">
			<div class="col-12 d-block d-md-none">
			<div class="row gwc-bar" style='font-size:12px;'>
			<div class="col-12">
			<div class="row">
			<div class="col-3 d-block d-md-none text-left" style='padding-left: 5px;padding-top: 9px;'><input :disabled='cartisnull' type="checkbox" style='vertical-align: middle' id='gwc-checkall2' @click='checkall'  :checked='ckall'><label for="gwc-checkall2" class='gwc-unselect'>全选</label></div>
			<div class="col-4 d-block d-md-none text-left" style='padding-left: 0px;padding-top: 9px;cursor:pointer' @click='collecta'>移入收藏夹</div>
			<div class="col-3 d-block d-md-none text-left" style='padding-left: 0px;padding-top: 9px;'>分享</div>
			<div class="col-2 d-block d-md-none text-left" style='padding-left: 0px;padding-top: 9px;'><div @click='deletea' id='delete-all' class='gwc-unselect' style='cursor:pointer'>删除</div></div>
		    </div>
			</div>
			<div class="col-12 d-block d-md-none" style='padding-left: 0px;'>已选商品：<span class='gwc-number gwc-unselect'>{{spsum}}</span>&nbsp;件</div>
			<div class="col-12 d-block d-md-none" style='padding-left: 0px;'>合计(不含运费)：<span class="gwc-number gwc-unselect">{{pricesum}}</span></div>
			<div class="col-6 offset-6 d-block d-md-none text-right" style='padding-right: 0px;'>
			<a :href="spsum==0?'JavaScript:void(0)':'receiver.html'" class="btn btn-info btn-js text-center" style='background-color:#ff9966;color:white;width: 100%;height:40px;border:none;'>结算</a></div>
			</div>	
			</div>
			</div>
		</div>
		<div class="row" >
			<div class="col-10 d-none d-xl-block">
			<div class="container">
			<div class="row" style='font-size: 15px;'>
			<div class="col-lg-1 d-none d-xl-block gwc-unselect gwc-ggwz" :class='gwcgg1' @mouseover='gwcggmo1'><b>正在热卖</b></div>
			<div class="col-lg-1 d-none d-xl-block gwc-unselect gwc-ggwz" :class='gwcgg2' @mouseover='gwcggmo2'><b>最近浏览</b></div>
			<div class="col-lg-1 d-none d-xl-block gwc-unselect gwc-ggwz" :class='gwcgg3' @mouseover='gwcggmo3'><b>猜你喜欢</b></div>
			</div>
			</div>
			</div>
			</div>
		<div class="row" >
			<div class="col-10 d-none d-lg-block d-xl-none">
			<div class="container">
			<div class="row" style='font-size: 13px;'>
			<div class="col-lg-1 d-none d-lg-block d-xl-none gwc-unselect gwc-ggwz" :class='gwcgg1' @mouseover='gwcggmo1'><b>正在热卖</b></div>
			<div class="col-lg-1 d-none d-lg-block d-xl-none gwc-unselect gwc-ggwz" :class='gwcgg2' @mouseover='gwcggmo2'><b>最近浏览</b></div>
			<div class="col-lg-1 d-none d-lg-block d-xl-none gwc-unselect gwc-ggwz" :class='gwcgg3' @mouseover='gwcggmo3'><b>猜你喜欢</b></div>
			</div>
			</div>
			</div>
			</div>
		<div class="row" >
			<div class="col-12 d-none d-md-block d-lg-none">
			<div class="container">
			<div class="row" style='font-size: 10px;'>
			<div class="col-md-1 d-block d-mx-block d-lg-none gwc-unselect gwc-ggwz" :class='gwcgg1' @mouseover='gwcggmo1'><b>正在热卖</b></div>
			<div class="col-md-1 d-none d-md-block d-lg-none gwc-unselect gwc-ggwz" :class='gwcgg2' @mouseover='gwcggmo2'><b>最近浏览</b></div>
			<div class="col-md-1 d-none d-md-block d-lg-none gwc-unselect gwc-ggwz" :class='gwcgg3' @mouseover='gwcggmo3'><b>猜你喜欢</b></div>
			</div>
			</div>
			</div>
			</div>
		<div class="row" >
			<div class="col-7 d-block d-md-none">
			<div class="container">
			<div class="row" style='font-size: 10px;'>
			<div class="col-3 d-block d-md-none gwc-unselect gwc-ggwz" :class='gwcgg1' @mouseover='gwcggmo1'><b>正在热卖</b></div>
			<div class="col-3 d-block d-md-none gwc-unselect gwc-ggwz" :class='gwcgg2' @mouseover='gwcggmo2'><b>最近浏览</b></div>
			<div class="col-3 d-blcok d-md-none gwc-unselect gwc-ggwz" :class='gwcgg3' @mouseover='gwcggmo3'><b>猜你喜欢</b></div>
			</div>
			</div>
			</div>
			</div>
		<div class="row">
			<div class="col-12 align-self-top"><hr class="gwc-hr" style='margin-top: 0px;'></div>	
		</div>
		<div class="row">
			<div class="d-none d-md-block col-md-4 col-lg-3">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsize' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsize' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsize' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx3</a></div>
				</div>
			</div>
			<div class="d-none d-md-block col-md-4 col-lg-3">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsize' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsize' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsize' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx3</a></div>
				</div>
			</div>
			<div class="d-none d-md-block col-md-4 col-lg-3">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsize' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsize' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsize' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx3</a></div>
				</div>
			</div>
			<div class="d-none d-md-block col-md-4 col-lg-3">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsize' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsize' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsize' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx3</a></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-6 d-block d-md-none">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsizesm' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsizesm' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsizesm' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:1xxx3</a></div>
				</div>
			</div>
			<div class="col-6 d-block d-md-none">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsizesm' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsizesm' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsizesm' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:2xxx3</a></div>
				</div>
			</div>
			<div class="col-6 d-block d-md-none">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsizesm' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsizesm' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsizesm' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:3xxx3</a></div>
				</div>
			</div>
			<div class="col-6 d-block d-md-none">
				<div class="row" v-show='ggxs1'>
				<div class="col-12"><img class='imgsizesm' :src="img1" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx1</a></div>
				</div>
				<div class="row" v-show='ggxs2'>
				<div class="col-12"><img class='imgsizesm' :src="img2" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx2</a></div>
				</div>
				<div class="row" v-show='ggxs3'>
				<div class="col-12"><img class='imgsizesm' :src="img3" ></div>
				<div class="col-12 ggwz"><a href="###">商品信息:4xxx3</a></div>
				</div>
			</div>
		</div>
		</div>
		</div>
</template>

<script>
	import GwcComponent from './components/gwccomponent'
    export default {
    		components:{
    		GwcComponent
    		},
    		data(){
    			return{
				namerepeat:false,
				objindex:0,
				cartobj:{
					storename:'',
					storeid:'',
					goods:[],
				},
				cartobj2:{
					groupid:0,
					productid:0,
					productname:'',
					img:'',
					price:0,
					quantity:0,
				},
				cartisnull:false,
				idslen:0,
				sum:0,
				ckall:false,
				isallcheck:false,
				gwcgg1:'gwc-mo',
				gwcgg2:'',
				gwcgg3:'',
				ggxs1:true,
				ggxs2:false,
				ggxs3:false,
				updatestatus:0,
				deletestatus:0,
				collectstatus:0,
				img1:'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547237586988&di=683aa0eaf8f668a384853c6841493c04&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F95%2F63%2F16q58PICdcu_1024.jpg',
				img2:'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547237586988&di=683aa0eaf8f668a384853c6841493c04&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F95%2F63%2F16q58PICdcu_1024.jpg',
				img3:'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547237586988&di=683aa0eaf8f668a384853c6841493c04&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F95%2F63%2F16q58PICdcu_1024.jpg',
				submithref:'',
				spsum:0,
				pricesum:(0).toFixed(2),
			}
			},
			mounted() {
			this.axiosgetcart()
			},
			methods:{
			// 根据用户ID获取购物车信息
			axiosgetcart(){
			this.axios.get('/api/cart/get')
			.then((response)=>{
				console.log(response);
				this.$store.state.cartmain=response.data;
				console.log(this.$store.state.cartmain);	

			})
			.catch((error)=>{console.log(error);});
			},
			// 更新商品数量
			axiosupdate(msg){
			this.axios.post('/api/cart/updateQuantity?cartId='+ this.$store.state.cartid + '&storeId='+ msg.storeid+'&productId='+msg.productid+'&productQuantity='+msg.quantity)
			.then((response)=>{this.updatestatus=response.data})
			.catch((error)=>{console.log(error);});
			},
			// 删除商品
			axiosdelete(msg){
			this.axios.delete('/api/cart/deleteCartProduct',{
				params:{
					cartId:this.$store.state.cartid,
					storeId:msg.storeid,
					productId:msg.productid
				}
			})
			.then((response)=>{this.deletestatus=response.data})
			.catch((error)=>{console.log(error);});
			},
			// 收藏商品
			axioscollect(msg){
			this.axios.put('/api/cart/collectCartProduct?userId='+this.$store.state.userid+'&storeId='+msg.storeid+'&groupId='+msg.groupid)
			.then((response)=>{this.collectstatus=response.data})
			.catch((error)=>{console.log(error);});
			},
			addobjdata(index){
				this.cartobj2.productid=this.$store.state.cartmain.cartproduct[index].productId,
				this.cartobj2.productname=this.$store.state.cartmain.cartproduct[index].product.productName,
				this.cartobj2.groupid=this.$store.state.cartmain.cartproduct[index].product.groupId,
				this.cartobj2.img=this.$store.state.cartmain.cartproduct[index].product.imgUrl,
				this.cartobj2.price=this.$store.state.cartmain.cartproduct[index].product.productPrice,
				this.cartobj2.quantity=this.$store.state.cartmain.cartproduct[index].productQuantity
			},
			resetcartobj1(){
				this.cartobj={
				storename:'',
				storeid:'',
				goods:[],
			}
			},
			resetcartobj2(){
				this.cartobj2={
				groupid:0,
				productid:0,
				productname:'',
				img:'',
				price:0,
				quantity:0,
				}
			},
			gwcggmo1(){
				this.gwcgg1='gwc-mo';
				this.gwcgg2='';
				this.gwcgg3='';
				this.ggxs1=true;
				this.ggxs2=false;
				this.ggxs3=false;
			},
			gwcggmo2(){
				this.gwcgg2='gwc-mo';
				this.gwcgg1='';
				this.gwcgg3='';
				this.ggxs2=true;
				this.ggxs1=false;
				this.ggxs3=false;

			},
			gwcggmo3(){
				this.gwcgg3='gwc-mo';
				this.gwcgg2='';
				this.gwcgg1='';
				this.ggxs3=true;
				this.ggxs2=false;
				this.ggxs1=false;
			},
			checkall(){
				this.ckall=!this.ckall;
				if(this.ckall==true){
				for(var b=0;b<this.cartarr.length;b++){
				this.$refs.one[b].checkall();
				this.$refs.one[b].spisallcheck=true;	
				}
				this.idslen=this.cartarr.length;
				}else{
				for(var c=0;c<this.cartarr.length;c++){
				this.$refs.one[c].uncheckall();
				this.$refs.one[c].spisallcheck=false;	
				}
				this.idslen=0;
				this.spsum=0;
				this.pricesum=(0).toFixed(2);
				}	
			},
			allck(ids){
				this.idslen=this.idslen+ids;
				if(this.idslen==this.cartarr.length){
					this.ckall=true;
					this.isallcheck=true;
				}else{
					this.ckall=false;
					this.isallcheck=false;
				}
			},
			nums(){
				this.spsum=0;
				for(var i=0;i<this.cartarr.length;i++){
				this.spsum=this.spsum+this.$refs.one[i].nsum;
				}
			},
			prices(){
				this.pricesum=parseFloat(0);
				for(var a=0;a<this.cartarr.length;a++){
				this.pricesum=parseFloat(this.pricesum)+parseFloat(this.$refs.one[a].psum);
				this.pricesum=parseFloat(this.pricesum).toFixed(2);
	
				}
			},
			deletea(){
				if(this.$store.state.cartchecked.length==0){
					this.$router.push({path: '/cart'});
				}else{
					this.$store.state.cartchecked.forEach(function(msg){
					this.axiosdelete(msg);	
					},this);
					this.$store.state.cartchecked=[];	
					this.$router.push({path: '/cart'});	
				}
			},
			collecta(){
				if(this.$store.state.cartchecked.length==0){
					this.$router.push({path: '/cart'});
				}else{
					this.$store.state.cartchecked.forEach(function(msg){
					this.axioscollect(msg);	
					},this);
					this.$store.state.cartchecked=[];		
				}
			}
		},
		computed: {
			cartmain(){
				return this.$store.state.cartmain;
			},
			cartarr(){
				return this.$store.state.cartarr;
			}
		},
		watch: {
			cartmain: function(newcartmain, old) {
				if(newcartmain!={}&&newcartmain&&newcartmain!="undefined"){
				this.$store.state.userid=newcartmain.userId;
				this.$store.state.cartarr=[];
				this.$store.state.cartid=newcartmain.cartId;
				if(newcartmain.cartproduct.length==0){
					this.cartisnull=true;
				}else{
				for(var a=0;a<newcartmain.cartproduct.length;a++){
					this.namerepeat=false;
					this.objindex=0;
					this.resetcartobj1();
					this.resetcartobj2();
					for(var b=0;b<this.cartarr.length;b++){
						if(this.cartarr[b].storename==newcartmain.cartproduct[a].store.storeName){
							this.namerepeat=true;
							this.objindex=b;
							break;
						}
					};
					if(this.namerepeat){						
						this.addobjdata(a);
						this.cartarr[this.objindex].goods.push(this.cartobj2);
					}else {
						this.addobjdata(a);	
						this.cartobj.storename=newcartmain.cartproduct[a].store.storeName;	
						this.cartobj.storeid=newcartmain.cartproduct[a].storeId;	
						this.cartobj.goods=[];	
						this.cartobj.goods.push(this.cartobj2);
						this.cartarr.push(this.cartobj);
						};
					};	
				}	
				}else{
					this.cartisnull=true;
				}
				
			},
			updatestatus:function(newstatus,old){
				this.axiosgetcart();
			},
			deletestatus:function(newstatus,old){
				this.axiosgetcart();
			},
			collectstatus:function(newstatus,old){
				this.axiosgetcart();
			}
		}
				    
    }
</script>

<style scoped>
.gwc-h3 {
  color: #ff9966;
  font-family: '黑体';
  margin-bottom: 0px;
  padding-bottom: 0px; }

.gwc-h6 {
  font-family: '黑体';
  padding-top: 20px;
  padding-bottom: 0px;
  font-size: 15px; }

.gwc-hr {
  margin-top: 5px;
  height: 2px;
  background-color: #ff9966;
  margin-bottom: 8px; }

#gwc-row1 {
  margin-top: 30px;
  margin-bottom: 0px; }

#gwc-6 {
  margin-top: 70px;
  background-color: rgba(255, 204, 153, 0.3);
  padding-top: 15px;
  padding-bottom: 15px; }

#gwc-row2 {
  margin-top: 0px; }

.gwc-bar {
  margin-top: 5px;
  margin-bottom: 150px;
  padding-top: 2px;
  padding-bottom: 2px;
  background-color: rgba(255, 204, 153, 0.3); }

.gwc-number {
  font-size: 20px;
  color: #ff9966;
  font-weight: bolder; }

.btn-js {
  font-weight: bolder;
  font-family: '幼圆';
  font-size: 20px; }

.btn-jsmd {
  font-weight: bolder;
  font-family: '幼圆';
  font-size: 15px; }

.gwc-main {
  border: 1px solid #cccccc;
  border-radius: 5px; }

.gw-num {
  width: 86px;
  line-height: 26px;
  overflow: hidden;
  border-radius: 3px; }

.gw-num div {
  background-color: #ff9966;
  display: block;
  height: 26px;
  width: 26px;
  float: left;
  color: white;
  border-right: 1px solid #dbdbdb;
  text-align: center;
  cursor: pointer;
  font-size: 30px;
  font-family: '黑体';
  border-radius: 3px; }

.gw-num input.num {
  display: block;
  float: left;
  text-align: center;
  width: 32px;
  font-style: normal;
  font-size: 15px;
  line-height: 26px;
  border: 0; }

.gw-num div.add {
  float: right;
  border-right: 0;
  border-left: 1px solid #dbdbdb; }

.gw-nummd {
  width: 56px;
  line-height: 26px;
  overflow: hidden;
  border-radius: 3px; }

.gw-nummd div {
  background-color: #ff9966;
  display: block;
  height: 22px;
  width: 18px;
  float: left;
  color: white;
  border-right: 1px solid #dbdbdb;
  text-align: center;
  cursor: pointer;
  font-size: 20px;
  font-family: '黑体';
  border-radius: 3px; }

.gw-nummd input.nummd {
  display: block;
  float: left;
  text-align: center;
  width: 20px;
  font-style: normal;
  font-size: 12px;
  line-height: 18px;
  border: 0; }

.gw-nummd div.addmd {
  float: right;
  border-right: 0;
  border-left: 1px solid #dbdbdb; }

.map-lg1 {
  margin-top: 10px;
  margin-bottom: 10px; }

.map-md1 {
  margin-top: 10px;
  margin-bottom: 10px; }

.map-lg2 {
  padding-top: 12px;
  padding-bottom: 12px; }

.map-md2 {
  padding-top: 7px;
  padding-bottom: 7px; }

#gwc-lg-img {
  width: 75px;
  height: 75px; }

#gwc-md-img {
  width: 68px;
  height: 68px; }

#gwc-xs-img {
  width: 55px;
  height: 55px; }

.gwc-unselect {
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  -webkit-user-select: none; }

.gwc-mo {
  color: red;
  background-color: rgba(255, 153, 102, 0.8);
  border-radius: 3px 3px 0px 0px; }

.gwc-ggwz {
  width: 50px;
  padding-bottom: 0px;
  padding-top: 5px;
  padding-left: 6px;
  padding-right: 6px; }

.ggwz {
  padding-top: 5px;
  padding-right: 30px;
  font-size: 13px;
  margin-bottom: 20px; }

.imgsize {
  width: 167px;
  height: 185px; }
.imgsizesm {
  width: 100px;
  height: 110px; }
.kong{
  opacity: 0.8;
  font-size: 30px;
  font-family: '隶书';
  font-weight: bolder;
}
.kmain{
  height:200px;
  border-radius: 10px;
  border:1px solid rgba(160,160,160,0.3);
  background-color: rgba(160,160,160,0.1);
}
</style>
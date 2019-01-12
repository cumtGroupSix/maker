<template>
						<div id='root'>
						<div style='margin-bottom:20px;margin-top:40px;'>
						<div class='row map-lg1' style='font-size:14px;'>
						<div class='col-12 d-none d-lg-block text-left'>
						<input type='checkbox' @click='spcheckall' :checked='spckall' style='vertical-align: middle' :class='item.storename'>
						{{item.storename}}
						</div>
						</div>
						<div class='container' style='font-size:14px;' v-for='(items,index) in item.goods' :key='index' :items='items' :index='index'>
						<div class='row'>
						<div class='col-12 d-none d-lg-block'>
						<div class='row gwc-main map-lg2'>
						<div class='col-2 d-none d-lg-block'>
						<input type='checkbox' :checked='spids.indexOf(items.productid) > -1' @click='checkone(items.productid)' style='vertical-align: top'>
						<img :src='items.img' id='gwc-lg-img'>
						</div>
						<div class='col-2 d-none d-lg-block text-left align-self-center'>
						<a href='###'>{{items.productname}}</a>
						</div>
						<div class='col-1 d-none d-lg-block offset-3 text-center align-self-center'>
						￥{{items.price}}
						</div>
						<gwc-component2 :items='items' @incg='inchange' :spids='spids' ref='two'></gwc-component2>
						<div class='col-1 d-none d-lg-block align-self-center'>
						￥{{(items.quantity*items.price)}}
						</div>
						<div class='col-1  d-none d-lg-block align-self-center'>
						<div class='row'>
						<div class='col-12 text-left'>
						<collect-one :items='items' @collectone='collectproduct'></collect-one></div>
						<div class='col-12 text-left'>
						<delete-one :items='items' @deleteone='deleteproduct'></delete-one>
						</div>
						</div></div></div></div></div>
						</div></div>
						
						<div style='margin-bottom:10px;margin-top:-20px;'>
						<div class='row map-md1' style='font-size:13px;'>
						<div class='col-12 d-none d-md-block d-lg-none text-left'>
						<input type='checkbox' @click='spcheckall' :checked='spckall' style='vertical-align: middle' :class='item.storename'>
						{{item.storename}}
						</div>
						</div>
						<div class='container' style='font-size:12px;' v-for='(items,index) in item.goods' :key='index' :items='items' :index='index'>
						<div class='row'>
						<div class='col-12 d-none d-md-block d-lg-none'>
						<div class='row gwc-main map-md2'>
						<div class='col-2 d-none d-md-block d-lg-none'>
						<input type='checkbox' :checked='spids.indexOf(items.productid) > -1' @click='checkone(items.productid)' style='vertical-align: top'>
						<img :src='items.img' id='gwc-md-img'>
						</div>
						<div class='col-3 d-none d-md-block d-lg-none text-left align-self-center'>
						<a href='###'>{{items.productname}}</a>
						</div>
						<div class='col-1 d-none d-md-block d-lg-none offset-1 text-center align-self-center'>
						￥{{items.price}}
						</div>
						<gwc-component2 :items='items' @incg='inchange' :spids='spids' ref='two'></gwc-component2>
						<div class='col-1 d-none d-md-block d-lg-none align-self-center' style='padding-left: 15px;'>
						￥{{(items.quantity*items.price)}}
						</div>
						<div class='col-2 d-none d-md-block d-lg-none align-self-center' style='padding-left: 40px;'>
						<div class='row'>
						<div class='col-12 text-left'>
						<collect-one :items='items' @collectone='collectproduct'></collect-one></div>
						<div class='col-12 text-left'>
						<delete-one :items='items' @deleteone='deleteproduct'></delete-one>
						</div>
						</div></div></div></div></div>
						</div></div>
						
						<div style='margin-bottom:10px;margin-top:-20px;'>
						<div class='row map-md1' style='font-size:13px;'>
						<div class='col-12 d-block d-md-none text-left'>
						<input type='checkbox' @click='spcheckall' :checked='spckall' style='vertical-align: middle' :class='item.storename'>
						{{item.storename}}
						</div>
						</div>
						<div class='container' style='font-size:12px;' v-for='(items,index) in item.goods' :key='index' :items='items' :index='index'>
						<div class='row'>
						<div class='col-12 d-block d-md-none'>
						<div class='row gwc-main map-md2'>
						<div class='col-12 d-block d-md-none'>
						<div class='row'>
						<div class='col-5 d-block d-md-none' style='margin-top: 3px;'>
						<input type='checkbox' :checked='spids.indexOf(items.productid) > -1' @click='checkone(items.productid)' style='vertical-align: top'>
						<img :src='items.img' id='gwc-xs-img'>
						</div>
						<div class='col-7 d-block d-md-none text-left' style='margin-left: -25px;'>
						<a href='###'>{{items.productname}}</a>
						</div>
						</div>
						</div>
						<div class='col-5 d-block d-md-none text-left' style='font-size:13px;'>
						单价:&nbsp;￥{{items.price}}
						</div>
						<div class='col-5 d-block d-md-none' style='font-size:13px;'>
						金额:&nbsp;￥{{(items.quantity*items.price)}}
						</div>
						<gwc-component2 :items='items' @incg='inchange' :spids='spids' ref='two'></gwc-component2>
						<div class='col-12 d-block d-md-none'>
						<div class='row'>
						<div class='col-4 text-left d-block d-md-none'>
						<collect-one :items='items' @collectone='collectproduct'></collect-one></div>
						<div class='col-4 d-block d-md-none text-center'>
						</div>
						<div class='col-4 text-right d-block d-md-none'>
						<delete-one :items='items' @deleteone='deleteproduct'></delete-one>
						</div>
						</div></div></div></div></div>
						</div></div>
						</div>
</template>

<script>
	import DeleteOne from './deleteone'
	import CollectOne from './collectone'
	import GwcComponent2 from './gwccomponent2'
    export default {
    	components:{
    		DeleteOne,
    		CollectOne,
    		GwcComponent2
    },
    props:['item'],
    data(){
			return {
				spckall:false,
				spisallcheck: false,
				spids:[],
				checkedids:{
				storeid:0,
				productid:0,
				groupid:0
				},
				ids:[],
				nsum:0,
				psum:0,
				deleteall:true,
				}
			},
			methods:{
				collectproduct(id){
					this.$emit('collectone',{storeid:this.item.storeid,groupid:id});
				},
				deleteproduct(id){
					this.$emit('deleteone',{storeid:this.item.storeid,productid:id});
					this.item.goods.forEach(function (items) {
						if(items.productid==id){
						this.item.goods.splice(items,1);
						}
					},this);
					if(this.spids.indexOf(id)>=0){
					this.spids.splice(this.spids.indexOf(id),1);
					}else{
						if((this.item.goods.length)==this.spids.length){
						this.checkall();				
						};
					};
				},
				full(count){
					if(!this.spckall){
						if(this.spids.length==(this.item.goods.length-count)){
							this.$options.methods.spcheckall.bind(this)();
						}
					}
				},
				deleteaone(){
					for(var e=0;e<=this.item.goods.length;e++){
					this.$refs.two[e].onevf();
					}
				},
				sum(){
					this.nsum=0;
					this.item.goods.forEach(function (items) {
					if(this.spids.indexOf(items.productid)>=0){
					this.nsum=this.nsum+parseInt(items.quantity);}
					},this);
					this.$emit('ns',this.nsum);
				},
				pricesum(){
					this.psum=parseFloat(0);
					this.item.goods.forEach(function (items) {
					if(this.spids.indexOf(items.productid)>=0){
					this.psum=parseFloat(this.psum)+parseFloat(items.quantity*parseFloat(items.price));}
					},this);
					this.$emit('ps',this.psum);
				},
				checkall(){
					this.spckall=true;
					this.spids = [];
					this.item.goods.forEach(function (items) {
					this.spids.push(items.productid)
					},this);
					this.sum();
					this.pricesum();
				},
				uncheckall(){
					this.spids = [];
					this.spckall=false;
				},
				inchange(msg){
					let idindex=this.spids.indexOf(msg.id);
					if(idindex<0){
					this.spids.push(msg.id);
					if(this.item.goods.length==this.spids.length){
						this.ids.push(this.item.storename);
						this.spckall=true;
						this.$emit('aallck',1);
						this.spisallcheck=true;					
					}
					}
					this.sum();
					this.pricesum();
					this.$emit('updatequantity',{storeid:this.item.storeid,productid:msg.id,quantity:msg.quantity})
				},
				checkone(id){
					let idindex=this.spids.indexOf(id);
					if(idindex>=0){
					this.spids.splice(idindex, 1);
					}else{
					this.spids.push(id);
					}
					if(this.spckall==false){
					var i=0;
					this.item.goods.forEach(function (items) {
					i++;
					},this);
						if(i==this.spids.length){
						this.ids.push(this.item.storename);
						this.spckall=true;
						this.$emit('aallck',1);
						this.spisallcheck=true;
					}else{
						this.ids.splice(this.ids.indexOf(this.item.storename),1);
						this.spckall=false;
						this.$emit('aallck',0);
						this.spisallcheck=false;
					}
					}else{
						this.ids.splice(this.ids.indexOf(this.item.storename),1);
						this.spckall=false;
						this.$emit('aallck',-1);
						this.spisallcheck=false;
					}
					this.sum();
					this.pricesum();
					},
				spcheckall(){
					this.spisallcheck=!this.spisallcheck;
					if (this.spisallcheck) {
					this.spids = [];
					this.item.goods.forEach(function (items) {
					this.spids.push(items.productid)
					},this);
					this.ids.push(this.item.storename);
					this.spckall=true;
					this.$emit('aallck',1);
					} else {
					this.spids = [];
					this.ids.splice(this.ids.indexOf(this.item.storename),1);
					this.spckall=false;
					this.$emit('aallck',-1);
					}
					this.sum();
					this.pricesum();
				},
				setcheckedids(storeid,productid,groupid){
					this.checkedids.storeid=storeid;
					this.checkedids.productid=productid;
					this.checkedids.groupid=groupid;
				},
				resetcheckedids(){
					this.checkedids={
					storeid:0,
					productid:0,
					groupid:0
					}
				}
			},
			watch:{
				spids: function(news, old){
					this.$store.state.cartchecked.forEach(function (ids){
						if(ids.storeid==this.item.storeid){
						this.$store.state.cartchecked.splice(this.$store.state.cartchecked.indexOf(ids),1);
						}
					},this);
					this.item.goods.forEach(function (items) {
						if(this.spids.indexOf(items.productid)>=0){
							this.resetcheckedids();
							this.setcheckedids(this.item.storeid,items.productid,items.groupid);
							this.$store.state.cartchecked.push(this.checkedids);						
						}
					},this);
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
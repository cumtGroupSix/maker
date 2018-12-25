<template>
    <div id="root">
	<div class="container" >
		<div class="row" id='ywc-row1'>
			<h3 class="ywc-h3 d-none d-sm-block">已完成订单</h3>
			<h4 class="ywc-h4 d-block d-sm-none"><b>已完成订单</b></h4>
		</div>
		<div class="row" id='ywc-row2'>
			<div class="col-12">
				<div class="row" id='ywc-row3'>
					<div class="col-3 text-center ywc-md d-lg-block d-none ywc-font-1" >已购商品</div>
					<div class="col-4 text-center ywc-md d-lg-block d-none ywc-font-1" >创客店名称</div>
					<div class="col-3 text-center ywc-md d-lg-block d-none ywc-font-1" >收货地址</div>
					<div class="col-2 text-center ywc-md d-lg-block d-none ywc-font-1" >操作</div>
					<div class="col-3 text-center ywc-md d-lg-none d-md-block d-none ywc-font-2" style='padding-left: 50px;' >已购商品</div>
					<div class="col-4 text-center ywc-md d-lg-none d-md-block d-none ywc-font-2" style='padding-left: 50px;' >创客店名称</div>
					<div class="col-3 text-center ywc-md d-lg-none d-md-block d-none ywc-font-2" >收货地址</div>
					<div class="col-2 text-center ywc-md d-lg-none d-md-block d-none ywc-font-2" >操作</div>
				</div>
				<completed-order v-for="(item,index) in list" :item='item' :index='index'></completed-order>
		</div>
	</div>
</div>
</div>
</template>

<script>
	import CompletedOrder from './components/completedOrder.vue'
    export default {
    	components:{
    		CompletedOrder
    	},
        data(){
			return{
			list:[
					{
					tp:'../img/u34.png',
					xx:'猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子',
					dm:'*******创客店',
					dz:'中国矿业大学南湖校区松竹杏桃0001'
					},
					{
					tp:'../img/u65.png',
					xx:'小马可爱树脂摆件设客厅居家装饰品北欧风格创意工艺品桌面礼物品',
					dm:'*******创客店',
					dz:'中国矿业大学南湖校区松竹杏桃0001'
					},
					{
					tp:'../../assets/img/dianputupian.jpg',
					xx:'情侣网红花生鼠公仔生日送小礼物男女生创意儿童毛绒玩具六一礼物',
					dm:'*******创客店',
					dz:'中国矿业大学南湖校区松竹杏桃0001'
					},]	
			}
			
		},
    }
</script>

<style scoped>
.ywc-xs {
  font-size: x-small; }

.ywc-md {
  font-size: 30px; }

#ywc-row1 {
  margin-bottom: 20px; }

.ywc-h3, .ywc-font-1 {
  font-family: "隶书";
  color: #ff9966; }

.ywc-font-2 {
  font-family: "隶书";
  color: #ff9966;
  font-size: 20px; }

.ywc-font-md {
  font-size: 25px;
  font-family: "隶书";
  color: #ff9966; }

.ywc-h3 {
  font-size: 40px; }

.ywc-h4 {
  font-size: 35px;
  color: #ff9966;
  font-family: "隶书"; }

.ywc-font2 {
  font-family: "黑体";
  color: #ff9966; }

#ywc-row2 {
  border-radius: 15px;
  border: 3px solid #ff9966; }

#ywc-root {
  margin-left: auto;
  margin-right: auto; }

#ywc-row4 {
  border-width: 2px;
  margin-top: 10px; }

#index {
  font-size: 30px; }

.ywc-btn {
  margin-top: 3px;
  margin-bottom: 3px; }

.sy {
  vertical-align: middle; }

.ywc-va {
  vertical-align: middle; }

.mubanbgc {
  background-color: rgba(153, 153, 153, 0.1); }

.tempm {
  border-radius: 8px;
  margin-right: auto;
  margin-left: auto;
  margin-bottom: 10px;
  padding-top: 10px;
  padding-bottom: 5px; }
</style>
<template>
    <div id="root">
    <div class='row tempm ' :class='{mubanbgc:me1()}' style='margin-top:10px;padding-bottom:10px'>
	<div class='col-4 d-none d-lg-block' style='margin-left:0px;margin-right:0px;'>
	<div class='row' style='height:80%'>
	<div id='index' class='col-1 ygsp d-none d-lg-block'>
	{{index+1}}
	</div>
	<div class='col-5 ygsp d-none d-lg-block'>
	<img class='ywc-img' :src='item.tp' style='height:90px;width:90px'>
	</div>
	<div class='col-6 ygsp' style='margin-left:-5px'>
	<div class='text-left d-none d-lg-block' style='width:140px;padding-left:5px;'>
	<a href='###'>{{item.xx}}</a>
	</div></div></div></div>
	<div class='col-3 text-center ywc-va d-none d-lg-block'>
	<div style='position:absolute;top:10%;left:15%;' class='text-left'>{{item.dm}}
	</div>
	</div>
	<div class='col-3 text-center ywc-va d-none d-lg-block'>
	<div style='position:absolute;top:10%;left:5%;' class='text-left'>{{item.dz}}</div></div><div class='col-2 d-none d-lg-block'>
	<div class='row ywc-btn'>
	<a href='order_details.html' class='col-6 offset-4 btn' style='background-color:#ff9966;color:white;padding-left:8px;'>
	<b>订单详情</b></a></div>
	<div class='row ywc-btn'>
	<button class='col-6 offset-4 btn' style='background-color:#ff9966;color:white;padding-left:8px;'>
	<b>物流跟踪</b></button>
	</div>
	<div class='row ywc-btn'>
	<button class='col-6 offset-4 btn' style='background-color:#ff9966;color:white;padding-left:8px;'>
	<b>确认收货</b>
	</button>
	</div>
	</div>
	<div class='col-4 d-none d-md-block d-lg-none' style='margin-left:0px;'>
	<div class='row' style='height:80%'>
	<div id='index' class='col-1 ygsp d-none d-md-block d-lg-none' style='font-size:20px;padding-top:5px;'>
	{{index+1}}</div>
	<div class='col-5 ygsp d-none d-md-block d-lg-none' style='padding-top:5px;margin-left:-5px;margin-right:5px'>
	<img class='ywc-img' :src='item.tp' style='height:75px;width:75px'></div>
	<div class='col-6 ygsp' style='margin-left:-5px'>
	<div class='text-left d-none d-md-block d-lg-none' style='width:100px;padding-left:5px;;'>
	<a href='###' style='font-size:12px;'>{{item.xx}}</a>
	</div></div></div></div>
	<div class='col-3 text-center ywc-va d-none d-md-block d-lg-none'>
	<div style='position:absolute;top:10%;left:15%;' class='text-left'>{{item.dm}}</div>
	</div>
	<div class='col-3 text-center ywc-va d-none d-md-block d-lg-none'>
	<div style='position:absolute;top:10%;left:5%;' class='text-left'>{{item.dz}}</div>
	</div>
	<div class='col-2 d-none d-md-block d-lg-none'>
	<div class='row ywc-btn'>
	<a href='order_details.html' class='col-6 offset-4 text-center btn' style='background-color:#ff9966;color:white;fontSize:10px;padding-left:6px;'>
	<b>订单详情</b>
	</a>
	</div>
	<div class='row ywc-btn'>
	<button class='col-6 offset-4 btn' style='background-color:#ff9966;color:white;fontSize:10px;padding-left:6px;'><b>物流跟踪</b>
	</button></div><div class='row ywc-btn'>
	<button class='col-6 offset-4 btn' style='background-color:#ff9966;color:white;margin-right:0px;fontSize:10px;padding-left:6px;'>
	<b>确认收货</b>
	</button></div></div>
	<div class ='col-12 d-block d-md-none' style='margin-left:auto;margin-right:auto;margin-top: 10px;'>
	<div class ='row'>
	<div class='col-12 d-block d-md-none'>
	<span style='font-size:20px'>{{index+1}}.</span>&nbsp;<span style='font-size: 15px'>已购商品：</span>
	</div></div>
	<div class ='row' style='padding-left: 5px;padding-right: 5px'>
	<div class ='col-3 ygsp' style='margin-top: 5px;margin-left:1px;margin-right:15px;'>
	<img class='ywc-img' :src='item.tp' style='height:70px;width:70px'></div>
	<div class ='col-8 text-left' >
	<div class='text-left'>
	<a class='text-left' href='###' style='font-size: 12px'>{{item.xx}}</a>
	</div></div></div>
	<div class='row'>
	<div class ='col-12  text-left ywc-va' style='clear: left;'>
	<div style='font-size: 12px;margin-left: 5px' class='text-left'><span>创客店名称：</span>&nbsp;{{item.dm}}</div></div></div>
	<div class='row'>
	<div class ='col-12 text-left ywc-va '>
	<div style='font-size: 12px;margin-left: 5px' class='text-left'><span>收货地址：</span>&nbsp;{{item.dz}}</div></div></div>
	<div class='row'>
	<div class ='col-4 ywc-btn'>
	<a href='order_details.html' class='btn btn-sm' style='background-color:#ff9966;color:white;'>
	<b>订单详情</b></a>
	</div>
	<div class ='col-4 ywc-btn'>
	<button class='btn btn-sm' style='background-color:#ff9966;color:white;'>
	<b>物流跟踪</b></button>
	</div>
	<div class ='col-4 ywc-btn'>
	<button class='btn btn-sm' style='background-color:#ff9966;color:white;'><b>确认收货</b></button>
	</div></div></div></div>
</div>
</template>

<script>
    export default {
    props:['item','index'],
    data(){
			return{
				bgc:{
				backgroungColor:'#ff9966',
				color:'white',
				},
			}
		},
		methods:{
			me1(){
				if ((this.index)%2){
					return false;
				}
				else{
					return true;
				}
			}
		}
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
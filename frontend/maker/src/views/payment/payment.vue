<template>
    <div class="bg">
		<div class="container" id='root'>
			<div class="row headermain">
				<div class="col-12 zfzx d-none d-sm-block">支付中心</div>
				<div class="col-12 zfzx-xs d-block d-sm-none">支付中心</div>
			</div>
			<div class="row main">
				<div class="col-12">
					<div class="row">
						<div class="col-12 dd1"><span class="ddwb">订单提交成功，您的订单号为：</span><span class='ddh'>2569452177971</span></div>
					</div>
					<div class="row">
						<div class="col-12"><hr></div>
					</div>
					<div class="row">
						<div class="col-12 d-none d-md-block"><h2>支付方式 :</h2></div>
						<div class="col-12 d-block d-md-none"><h4>支付方式 :</h4></div>
					</div>
					<div class="row zftp0">
						<div class="col-12 col-sm-6 text-center"  style="margin-bottom: 10px;"><img id="zfb" src="../../assets/img/zfb.png" height="91" width="240" alt="支付宝支付" class="zftp" :class='img1' @click='imgz'></div>
						<div class="col-12 col-sm-6  text-center" style="margin-bottom: 10px;"><img id="wx" src="../../assets/img/wx.png" alt="微信支付" class="zftp" :class='img2' @click='imgw'></div>
					</div>
					<div class="row">
						<div class="col-12"><hr></div>
					</div>
					<div class="row">
						<div class="col-7" style='color: #ff6600;margin-top: 10px;'><span>！请在</span><span id='time'>23小时59分钟59秒</span><span>以内支付完成，如未完成此订单将自动关闭。</span></div>
						<div class="col-5 text-right" style="margin-top: 30px;"><span>应付金额：</span><span class="je">￥</span><span class="je">20</span></div>
					</div>
					<div class="row">
						<div class="col-12 text-right" style="margin-top: 10px;">
						<button class="btn btn-danger btn-md d-none d-sm-block" style='float: right' @click='zf'><b>立即支付</b></button>
						<button class="btn btn-danger btn-sm d-block d-sm-none" style='float: right' @click='zf'><b>立即支付</b></button>
						</div>
					</div>
					<div class="row">
						<div class="col-12 text-right" style="margin-top: 13px;margin-bottom: 50px;"><a href="">我有疑问？</a></div>
					</div>
				</div>
			</div>
			<div class="finish" v-if='zfcg'>
			<div class="finish-box" >
			<img src="../../assets/img/sure.png" height="71" width="72" style='float: left;'>
			<div class='zfcgwb'><b>支付成功，请耐心等待卖家发货。</b></div>
			<div><router-link style='margin-right: 50px;margin-left: 10px;' to="/">返回首页</router-link><router-link to="/cart">继续购物</router-link></div>
			</div>
			</div>
		</div>
	</div>
</template>

<script>
    export default {
        data(){
        	return{
        	zfcg:false,
			img1:'imgsolid',
			img2:'imgnone',	
        	}	
		},
		methods:{
		zf(){
		this.zfcg=true;
		},
		imgz(){
		this.img1='imgsolid';
		this.img2='imgnone';
		},
		imgw(){
		this.img2='imgsolid';
		this.img1='imgnone';
		}
		}
    }
</script>

<style scoped>
.bg {
  background-color: rgba(255, 204, 153, 0.3);
  height: 100%； }

.headermain {
  width: 95%;
  margin-left: auto;
  margin-right: auto; }

.zfzx {
  font-size: 60px;
  font-family: '隶书';
  color: #FF9966;
  margin-bottom: 10px; }

.zfzx-xs {
  font-size: 45px;
  font-family: '隶书';
  color: #FF9966;
  margin-bottom: 10px; }
.main {
  margin-left: auto;
  margin-right: auto;
  width: 95%;
  background-color: white;
  border-radius: 15px;
  box-shadow: 10px 10px 5px rgba(188, 188, 188, 0.35);
  border: none; }

.ddh {
  font-weight: bolder;
  font-size: 17px; }

.ddwb {
  font-size: 15px; }

hr {
  color: #e4e4e4;
  margin-top: 3px;
  margin-bottom: 3px;
  border-width: 2px; }

.zftp0 {
  margin-top: 20px;
  margin-bottom: 40px; }

.zftp {
  cursor: pointer;
  width: 90%;
  height: 100%;
  margin-top: 10px;
  border-radius: 10px; }

.dd1 {
  margin-top: 12px;
  margin-bottom: 12px; }

.je {
  color: #ff0000;
  font-size: 28px; }
.finish{
  vertical-align: middle;
  background-color:rgba(176,176,176,0.4);
  position: fixed;
  top:0;
  left:0;
  bottom:0;
  right: 0;
}
.finish-box{
  width: 320px;
  height: 75px;
  background-color: #FFFFFF;
  position: fixed;
  margin:auto;
  top:0;
  left:0;
  bottom:0;
  right: 0;
  border-radius: 3px;
  padding-top: 0px;
}
.zfcgwb{
	margin-bottom: 15px;
	padding-top: 3px;
}
.imgsolid{
  border: 4px solid rgba(255,0,0,0.6); 
}
.imgnone{
  border: 4px none rgba(255,0,0,0.6); 
}
</style>
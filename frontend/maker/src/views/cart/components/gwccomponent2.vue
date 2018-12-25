<template>
<div class='col-12 col-md-2 d-flex align-self-center' id='root'>
			<div class='row' >
			<div class='col-7 offset-3 d-none d-lg-block' style='padding-left: 7px;'>
			<div class='gw-num'>
			<div class='jian gwc-unselect' @click='jian'><b>-</b></div>
			<input @input='submitg' @change='inchange' @blur='blur1' v-model.number:value='items.num' class='num'/>
			<div class='add gwc-unselect' @click='add'><b>+</b></div></div></div>
			
			<div class='col-7 offset-3 d-none d-md-block d-lg-none' style='padding-left: 12px;'>
			<div class='gw-nummd'>
			<div class='jianmd gwc-unselect' @click='jian'><b>-</b></div>
			<input @input='submitg' @change='inchange' @blur='blur1' v-model.number:value='items.num' class='nummd'/>
			<div class='addmd gwc-unselect' @click='add'><b>+</b></div></div></div>
			<div class='col-12 d-block d-md-none'>
			<div class='gw-num'>
			<div class='jian gwc-unselect' @click='jian'><b>-</b></div>
			<input style='font-size:20px;' @input='submitg' @change='inchange' @blur='blur1' v-model.number:value='items.num' class='num'/>
			<div class='add gwc-unselect' @click='add'><b>+</b></div></div></div>
			</div></div>
</template>

<script>
    export default {
	props:['items','spids'],
			data(){
			return{
				}
			},
			methods:{
					kongg(){
					if(this.items.vf){
					this.$emit('cgkk',this.items.info);
					}
					},
					onevf(){
					if(this.spids.indexOf(this.items.info)>=0){
					this.items.vf=false;
					this.$emit('co',this.items.info);
					this.$emit('kong',this.items.info);
					}
					},
					add(){
					this.items.num=parseInt(this.items.num)+1;
					this.$emit('incg',this.items.info);
					},
					jian(){
					if (this.items.num>1){
					this.items.num=this.items.num-1;
					this.$emit('incg',this.items.info);	
					}
					},
					blur1(){
					if(this.items.num==''){
						this.items.num=1;
					}
					this.$emit('incg',this.items.info);
					},
					submitg(){
					this.items.num=this.items.num.replace(/^[0]+[0-9]*$/gi,"");
					this.items.num=this.items.num.replace(/[^d]/g,'');
					},
					inchange(){
					this.$emit('incg',this.items.info);
					}
				},
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
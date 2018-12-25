<template>
    <!-- 提交订单 -->
        <section>
        <div class="container-fluid" style="">
        	<section id="yetou">
        	<div class="querendingdan">
        		<span>确认订单信息</span>
        	</div>        	
        </section>
        
        <section id="dingdanxiangqing">
        <div class="biankuang">      
	        <div class="daohangtiao">
		        	<div class="row">
			            <div class="col-12 col-md-4 col-sm-12" >
			            	<div class="dianpubaobei" ><strong>店铺宝贝</strong></div>
			            	<div class="d-flex align-items-center" style="font-family: 微软雅黑"><img src="../img/beizi1.jpg" style="width:70px">猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日…</div>
			            </div>
			            <div class="col-12 col-md-3 col-sm-12">
			            	<div class="shangpinxiangqing" ><strong>商品详情</strong></div>
			            	<div style="text-align: center; font-family: 微软雅黑">4号柴犬400ml</div>
			            </div>
			            <div class="col-12 col-md-1 col-sm-12">
			            	<div class="danjia"><strong>单价</strong></div>
			            	<div style="text-align: center">¥20</div>
			            </div>
			            <div class="col-12 col-md 2 col-sm-12">
			            	<div class="shuliang"><strong>数量</strong></div>
			            	<div style="text-align: center">1</div>
			            </div>
			            <div class="col-12 col-md-2 col-sm-12">
			            	<div class="xiaoji"><strong>小计</strong></div>
			            	<div style="color:#ff3333;text-align: center"><strong>¥20</strong></div>
			            </div>
			        </div>
		        </div>

	        <div class="beizhu">
	        	<div class="row">
	                <div class="col-md-4">
		                <br><br><br><div class="input-group mb-3">
							<div class="input-group-prepend">
							    <span class="input-group-text">给卖家留言：</span>
							</div>
							<input type="text" class="form-control" placeholder="选填">
  						</div>
  						<div>店铺名：诺拉家</div>
	                </div>
	                <div class="col-md-4"></div>
	                <div class="col-md-4">
	                    <br><br><span>运送方式：普通配送 快递 免邮</span><br><br>
	                    <span>发货时间：卖家承诺订单在买家付款后, 24小时内发货</span><br><br>
	                    <span>店铺合计(含运费):¥20</span><br><br>
	                </div>
	            </div>
	        </div>
        </div>

        </section>
        
        <section id="tijiaokuang">
	    <div class="row">
	        <div class="col-md-4"></div>
	        <div class="col-md-4">
	            <div class="xinfeng" style="border-radius: 5px">	
		        	<div class="zongjia" style="margin-right: 10px"><strong>¥20</strong></div><br><br><br><br>
		        	<div class="dizhi"><center>寄送至：江苏省&nbsp;&nbsp;&nbsp;徐州市&nbsp;&nbsp;&nbsp;泉山区&nbsp;&nbsp;&nbsp;中国矿业大学南湖校区XXXX</center></div><br><br>
		        	<div class="shouhuoren"><center>收货人：XXX&nbsp;&nbsp;&nbsp;151XXXXXXXX</center></div><br>
	            </div>
	        </div>
	        <div class="col-md-4"></div>
	    </div>
	
	    <div class="anniu">
	    	 <div class="row">
	        <div class="col-md-4"></div>
	        <div class="col-md-4">
	    	<center><a href="payment.html" type="button" class="btn btn-danger btn-lg">提交订单</a></center>    
	    	</div>
	       </div>
	        <div class="col-md-4"></div>
	    </div>
        </section>
        </div>
</template>

<script>
    export default {
        import $ from 'jquery'
    }
</script>

<style scoped>
.querendingdan{
	font-family: '隶书';
	color:#ff9966;
	font-size: 50px;
}

.daohangtiao{
	font-family: '黑体';
	line-height: 40px;
}

.biankuang{
	border: 2px solid #dddddd;
	border-radius: 5px;
}

.xinfeng{
	border:3px solid #ff3333;
	margin-top: 30px;
	height: 250px;
	box-shadow: 0px 0px 1px 1px #ff3333;
}

.zongjia{
	float: right;
	font-size: 50px;
	color:#ff3333;
	font-family: '宋体';
}

.dianpubaobei{
	border: 2px solid #dddddd; 
	border-radius: 5px; 
	background-color: #fff0e1; 
	text-align: center; 
	color:#ff9966;
}

.shangpinxiangqing{
	border: 2px solid #dddddd; 
	border-radius: 5px; 
	background-color: #fff0e1; 
	text-align: center; 
	color:#ff9966;
}

.danjia{
	border: 2px solid #dddddd; 
	border-radius: 5px; 
	background-color: #fff0e1; 
	text-align: center; 
	color:#ff9966;
}

.shuliang{
	border: 2px solid #dddddd; 
	border-radius: 5px; 
	background-color: #fff0e1; 
	text-align: center; 
	color:#ff9966;
}

.xiaoji{
	border: 2px solid #dddddd; 
	border-radius: 5px; 
	background-color: #fff0e1; 
	text-align: center; 
	color:#ff9966;
}

</style>
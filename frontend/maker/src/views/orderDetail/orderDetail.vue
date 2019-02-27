<template>
    <div class="container" style="max-width: 1300px">

		<div class="logistics-information">
			<div class="querendingdan">物流信息</div>
			<div class="logistics-information-content">
				<div class="my-2">配送方式：平台配送</div>
				<div class="my-2">运单号码：20851593478516</div>
				<div class="my-2">订单状态：配送中</div>
				<div class="my-2">收货地址：******</div>
			</div>
		</div>

		<div class="querendingdan">订单详情</div>

		<div class="biankuang">
		<div class="daohangtiao">
			<div class="row">
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>订单详情ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{Message1.id1}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>订单ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{Message1.id2}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>商品ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{Message1.id3}}</div>
				</div>
				<div class="col-12 col-md-4 col-sm-12" >
					<div class="dianpubaobei" ><strong>商品名称</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{Message1.name}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="danjia"><strong>单价</strong></div>
					<div style="text-align: center">{{Message1.price}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="shuliang"><strong>数量</strong></div>
					<div style="text-align: center">{{Message1.count}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="xiaoji"><strong>小计</strong></div>
					<div style="color:#ff3333;text-align: center"><strong>{{Message1.sum}}</strong></div>
				</div>
				<div class="col-12 col-md-2 col-sm-12">
					<div class="shuliang"><strong>支付状态</strong></div>
					<div style="text-align: center">{{Message1.pay}}</div>
				</div>
			</div>
	</div>
		</div>
		</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				Message1:
					{
						id1:"",
						id2:"",
						id3:"",
						name:"",
						price:"",
						count:"",
						sum:"",
						pay:"",
						res:null,
						store:"诺拉家",
						detail1:"运送方式：普通配送 快递 免邮",
						detail2:"发货时间：卖家承诺订单在买家付款后, 24小时内发货",
					}
			}
		},

		methods:{
			getMessageInfo(){
				axios.get('/api/orderDetail/getOrderDetail?detailId=6')
						.then((res)=> {
							if (res.status == 200 && res.data) {
								this.$store.state.message1 = res.data;
							}
						})
						.catch((error)=> {console.log(error)})

			},
		},
		computed:{
			message(){
				return this.$store.state.message1;
			}
		},
		watch:{
			message:function(data,olds){
				this.Message1.id1=data.detailId;
				this.Message1.id2=data.orderId;
				this.Message1.id3=data.productId;
				this.Message1.price=data.productPrice;
				this.Message1.count=data.productQuantity;
				this.Message1.pay=data.orderStatus=="1"?"已支付":"未支付";
				this.Message1.sum=data.orderAmount;
				this.Message1.name=data.productName;
			}
		},
		mounted(){
			this.getMessageInfo()
		}
	}
</script>

<style scoped>
	.daohangtiao{
		font-family: '黑体';
		line-height: 40px;
	}

	.biankuang{
		border: 2px solid #dddddd;
		border-radius: 5px;
		margin-bottom: 20px;
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

	.querendingdan{
		font-family: '隶书';
		color:#ff9966;
		font-size: 50px;
	}
</style>

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
			<div class="row" v-for="(item, index) of message1" :key="index">
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>订单ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{item.orderId}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>订单详情ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{item.detailId}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12" >
					<div class="dianpubaobei" ><strong>商品ID</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{item.productId}}</div>
				</div>
				<div class="col-12 col-md-4 col-sm-12" >
					<div class="dianpubaobei" ><strong>商品名称</strong></div>
					<div style="text-align: center; font-family: 微软雅黑">{{item.productName}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="danjia"><strong>单价</strong></div>
					<div style="text-align: center">{{item.productPrice}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="shuliang"><strong>数量</strong></div>
					<div style="text-align: center">{{item.productQuantity}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="xiaoji"><strong>小计</strong></div>
					<div style="color:#ff3333;text-align: center"><strong>{{item.orderAmount}}</strong></div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="shuliang"><strong>订单状态</strong></div>
					<div style="text-align: center">{{item.orderStatus}}</div>
				</div>
				<div class="col-12 col-md-1 col-sm-12">
					<div class="danjia"><strong>操作</strong></div>
					<div style="text-align: center"><div style="text-align: center" class="button"><router-link to="/comment" class="btn btn-danger btn-small">评价</router-link></div></div>
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
				message1:[],
			}
		},

		methods:{
			getMessageInfo(){
				axios.get('api/orderDetail/getByOrderId/1')
						.then((res)=> {
							if (res.status == 200 && res.data) {
								this.message1 = res.data;
							}
							console.log(this.message1)
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
				this.message1.detailId=data.detailId;
				this.message1.orderId=data.orderId;
				this.message1.productId=data.productId;
				this.message1.productPrice=data.productPrice;
				this.message1.productQuantity=data.productQuantity;
				this.message1.orderStatus=data.orderStatus=="1"?"已发货":"未发货";
				this.message1.orderAmount=data.orderAmount;
				this.message1.productName=data.productName;
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

	.button{
		margin-bottom: 5px;
		margin-top: 5px;
	}
</style>

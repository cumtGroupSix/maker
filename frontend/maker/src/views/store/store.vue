<template>
<div>
	<!-- 店铺名 -->
	<section id="dianpuming"  v-for="(item,index) in dianpuming" :key="index">
		<div class="dianpumingcheng"><strong>{{item.name}}</strong><img src="@/assets/img/erweima.png" style="margin-left:30px;width:50px"></div>
	</section>

	<!-- 商品展示 -->
	<div class="card">
		<section id="shangpinzhanshi">
			<div class="container" style="max-width: 1050px">
				<div class="row">
					<div class="col-12 col-md-4 col-sm-12 mb-3 flex mx-0 px-1" v-for="(item,index) in shangpinzhanshi1" :key="index">
						<div class="card" style="width:320px">
							<img class="card-img-top m-auto py-2" :src="item.imageUrl" style="width:95%">
							<div class="card-body">
								<div class="name my-1"><router-link to="product" class="a1">{{item.name}}</router-link></div>
								<div class="price my-2">{{item.price}}</div>
								<div class="browse">销量：{{item.browseNum}}</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
</div>
</template>

<script>
	export default {
		data() {
			return {
				shangpinzhanshi1:[
					{
						name:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						price:"¥20",
						browseNum:"100",
						imageUrl:require('@/assets/img/list-1.jpg'),

					},
					{
						name:"韩国卡通可爱猫咪蓝光苹果7plus手机iphonex/7/8/6s/6全包软壳",
						price:"¥15",
						browseNum:"80",
						imageUrl:require('@/assets/img/shoujike.jpg'),

					},
					{
						name:"四川蒲江红心猕猴桃新鲜水果5斤包邮30个奇异果红阳泥猴桃",
						price:"¥35",
						browseNum:"60",
						imageUrl:require('@/assets/img/shuiguo.jpg'),

					},
					{
						name:"有零有食脆脆每日坚果集混合160g营养代餐能量棒燕麦片零食",
						price:"¥15",
						browseNum:"50",
						imageUrl:require('@/assets/img/lingshi.jpg'),

					},
					{
						name:"牛津布装棉被子的收纳袋超大搬家神器打包袋衣服物行李箱整理袋子",
						price:"¥10",
						browseNum:"35",
						imageUrl:require('@/assets/img/shounadai.jpg'),

					},
				],
				dianpuming:[
						{
					name: "阳光小铺",
				}
		]
		}
		},
	}
</script>

<style scoped>
	*{
		margin: 0;
		padding: 0;
		list-style-type: none;
		text-decoration: none;
	}
	a{
		color: black;
	}
	.dianpumingcheng{
		font-family: '华文彩云';
		font-size:50px;
		color:#ffcc66;
		background-color:#ffffde;
	}

	.store-name {
		font-family: '微软雅黑';
		font-size: 15px;
	}

	.price{
		font-size:30px;
		color:red;
	}
	.browse{
		color:red;
	}

	.card{
		margin-top: 30px;
	}

</style>
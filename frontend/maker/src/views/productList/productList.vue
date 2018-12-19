<template>
   <div class="contain mx-auto" style="max-width:1400px" id="root">
		<!--  商品列表-->
		<div class="row">
			<div class="col-12 col-md-9 " >
				<div class="row justify-content-center">
					<div class="card rounded float-left col-12 col-sm-4 col-lg-3" v-for="item of products">
						<img class="card-img-top" :src="item.images">
						<div class="margin">
							<div class="float-left text-danger text-center font-weight-bold">{{item.price}}
							</div>
							<div class="float-right text-center text-dark">{{item.over}}
							</div>
						</div>
						<div class="small text-dark margin">
						<a class="productIntroduction" href="product.html">{{item.introduction}}</a>
						</div>
						<div class="margin">
							<div class="float-left text-muted small"><u>{{item.name}}</u></div>
							<div class="float-right"><pre class="text-muted small">{{item.destination}}</pre></div>
						</div>
					</div>
				</div>
			</div>
			<!--热卖商品-->
			<div class="col-sm-3 d-none d-md-block">
				<div>
					<div class="mx-auto text-danger float-left font-weight-bold">热卖！</div>
					<div class="mx-auto float-right small text-muted">广告</div>
				</div>				
				<div class="card rounded hot-product" v-for="site of hot" :id="site.hotID">
					<img class="card-img-top" :src="site.hotImages" >
					<div class="margin">
						<div class="text-danger font-weight-bold float-left">{{site.hotPrice}}</div>
						<div class="float-right text-dark">{{site.hotSales}}</div>
						</div>
					<div class="card-footer font-weight-bold text-dark" :id="site.hotStoreID">
						<a class="hot" href="store.html">{{site.hotIntroduction}}</a>
					</div>
				</div>				
			</div>
		</div>
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="#">上一页</a></li>
			<li class="page-item active"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">...</a></li>
			<li class="page-item"><a class="page-link" href="#">下一页</a></li>
		</ul>
	</div>
</template>

<script>
    export default {
        new Vue({
			el:"#root",
			data:{
				products:[
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-5.jpg",
						price:"¥27.30",
						over:"710人付款",
						introduction:"小马可爱树脂摆件设客厅居家装饰品北欧风格创意工艺品桌面礼物品",
						name:"微博大仙网店",
						destination:"浙江   温州"
					},
					{
						images:"../img/list-2.jpg",
						price:"¥25.4",
						over:"710人付款",
						introduction:"情侣网红花生鼠公仔生日送小礼物男女生创意儿童毛绒玩具六一礼物",
						name:"微博大仙网店",
						destination:"浙江   杭州"
					},
					{
						images:"../img/list-3.jpg",
						price:"¥14.8",
						over:"710人付款",
						introduction:"车饰车载摆件车内用品汽车子饰品摆件小物件个性创意可爱小工艺品",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
					{
						images:"../img/list-1.jpg",
						price:"¥20.00",
						over:"710人付款",
						introduction:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
						name:"微博大仙网店",
						destination:"江苏   徐州"
					},
				],

				hot:[
					{
						hotID:"hot-product1",
						hotStoreID:"store1",
						hotImages:"../img/5.jpg",
						hotPrice:"¥42.00",
						hotSales:"销量：777",
						hotIntroduction:"啦啦啦旗舰店襄阳特产卧龙手工锅巴",
					},
					{
						hotID:"hot-product2",
						hotStoreID:"store2",
						hotImages:"../img/5.jpg",
						hotPrice:"¥42.00",
						hotSales:"销量：777",
						hotIntroduction:"啦啦啦旗舰店襄阳特产卧龙手工锅巴",
					},
					{
						hotID:"hot-product3",
						hotStoreID:"store3",
						hotImages:"../img/5.jpg",
						hotPrice:"¥42.00",
						hotSales:"销量：777",
						hotIntroduction:"啦啦啦旗舰店襄阳特产卧龙手工锅巴",
					},
					{
						hotID:"hot-product4",
						hotStoreID:"store4",
						hotImages:"../img/5.jpg",
						hotPrice:"¥42.00",
						hotSales:"销量：777",
						hotIntroduction:"啦啦啦旗舰店襄阳特产卧龙手工锅巴",
					},
				],
			},
		})
    }
</script>

<style scoped>
.text-danger{ 
	font-size:1.5rem; 
}

.card{ 
	border:1px solid pray; 
	width:265px;
	height:400px;
	margin:15px; 
	box-shadow:2px 2px 10px #909090
	padding:0px;
}

.text-muted{ 
	margin-top:35px; 
}

.contain{
 margin-top:40px; 
}

.hot-product{ 
	height:260px;
	margin:10px;
	position:relative;
	box-shadow:none;
}

.card-img-top{ 
	height:220px;
	width:100%; 
	margin:0px;
}

.card-footer{ 
	height:110px;
	width:100%;
	border:none;
	background-color:rgba(255,255,255,0.7);
	position:absolute;
	top:150px;
	padding:0px;
	line-height:110px;
	visibility:hidden; 
}

.margin{
	margin-left: 10px;
	margin-right:10px;
}

.bg-light{ 
	border:4px solid orange;
}

.productIntroduction:link,.productIntroduction:visited,.hot:link,.hot:visited{
	color:#000000;
	text-decoration:none;
} 

#hot-product1:hover #store1{ 
	visibility:visible;}

#hot-product2:hover #store2{ 
	visibility:visible;}

#hot-product3:hover #store3{ 
	visibility:visible;}

#hot-product4:hover #store4{ 
	visibility:visible;}
	
</style>
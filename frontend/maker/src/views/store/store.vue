<template>
<div>
	<!-- 店铺名 -->
	<section id="dianpuming">
		<div class="dianpumingcheng"><strong>{{store.storeName}}</strong><img src="@/assets/img/erweima.png" style="margin-left:30px;width:50px"></div>
		<button class="btn btn-default" @click="collectStore()">收藏</button>
		<button class="btn btn-default" @click="cancelCollectStore()">取消收藏</button>
	</section>

	<!-- 商品展示 -->
	<div class="card">
		<section id="shangpinzhanshi">
			<div class="container" style="max-width: 1050px">
				<div class="row">
					<div class="col-12 col-md-4 col-sm-12 mb-3 flex mx-0 px-1" v-for="(item,index) in store.productGroupVOS" :key="index">
						<div class="card" style="width:320px">
							<img class="card-img-top m-auto py-2" :src="item.productVO.imgUrl" style="width:95%">
							<div class="card-body">
								<div class="name my-1"><router-link to="product" class="a1" @click.native="changeGroupId(item.groupId)">{{item.productName}}</router-link></div>
								<div class="price my-2">￥{{item.productVO.productPrice}}</div>
								<div class="browse">销量：{{item.productVO.sales}}</div>
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
		created(){
			if(sessionStorage.getItem("store")){
				// this.$store.commit('changeCurrentStore',window.sessionStorage.getItem('currentStore'))
				this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
			}
			window.addEventListener("beforeunload",()=>{
				sessionStorage.setItem("store",JSON.stringify(this.$store.state))
			})
		},
		computed: {
			store() {
				return this.$store.state.currentStore
			}
		},
		methods: {
			changeGroupId(groupId) {
				this.$store.state.currentProductGroupId = groupId
			},
            collectStore() {
			    //window.currentStore = this.$store.state.currentStore;
                this.axios.post("/api/collect/store" + "?collectStoreId=" + this.$store.state.currentStore.storeId);
			},
            cancelCollectStore() {
                this.axios.delete("/api/collect/store" + "?collectStoreId=" + this.$store.state.currentStore.storeId);
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
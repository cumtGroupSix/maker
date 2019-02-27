<template>
    <div>
        <div class="row">
            <div class="col-12 col-md-4 col-sm-6 mb-3 flex mx-0 px-1 mt-3" v-for="(store,index) in store" :key="index">
                <div class="card mx-auto" style="width:220px">
                    <img class="card-img-top" :src="store.imgUrl" alt="Card image cap" style="width:100%;height: 150px">
                    <div class="img-list my-2" style="display: flex">
                    <div v-for="(product,index) in store.productGroupVOS" :key="index" class="position-relative" style="width: 20%;cursor: pointer">
                        <img :src="product.productVO.imgUrl" alt="" style="width: 100%;cursor: pointer">
                        <div class="position-absolute" style="top: 0;z-index: 10;visibility: hidden;background-color:dimgrey;color: white">
                        <img :src="product.productVO.imgUrl" style="width: 200px">
                        <div style="color: red;font-size: 22px">￥{{product.productVO.productPrice}}</div>
                        <div style="font-size: 15px" class="p-2">{{product.productVO.productName}}</div>
                        </div>
                    </div>
                    </div>
                    <div class="card-body mt-0 pt-1 px-3">
                    <div class="store-name my-1">{{store.storeName}}</div>
                    <div class="store-introduce my-2 ellipsis">{{store.storeIntroduce}}</div>
                    <div>
                    <div class="browse float-left">{{store.browseTimes}}次浏览</div>
                    <div class="store-link float-right"><router-link to="/store"  @click.native="changeCurrentStore(index)">进入店铺</router-link></div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                store: []
            }
        },
        mounted(){
            this.axios.get("/api/collect/store")
                .then(res => {
                    //console.log(res)
                    this.store = res.data
                })
        },
        methods: {
            changeCurrentStore(index){
                this.$store.state.currentStore = this.store[index]
            }
        }
    }
</script>

<style scoped>

</style>
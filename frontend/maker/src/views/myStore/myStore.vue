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
                store: [
                        {
                            "storeId": 1,
                            "storeName": "优品阁",
                            "storeIntroduce": "优品阁创立于yyyy年mm月dd日，绝对正品，童叟无欺",
                            "browseTimes": 666,
                            "imgUrl": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544608736759&di=2b4dd592145830f2c1bd58b19b37cf95&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4a36acaf2edda3ccc3e322bd0be93901213f922c.jpg",
                            "productGroupVOS": [
                            {
                                "groupId": 1,
                                "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                                "productVO": {
                                "productId": 1,
                                "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                                "productDescription": "好",
                                "productPrice": 2,
                                "imgUrl": "https://gd1.alicdn.com/imgextra/i1/3200146288/TB2I47ri8fH8KJjy1XbXXbLdXXa_!!3200146288.jpg_400x400.jpg",
                                "sales": 0
                                }
                            },
                            {
                                "groupId": 2,
                                "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                                "productVO": {
                                "productId": 4,
                                "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                                "productDescription": "nice",
                                "productPrice": 122,
                                "imgUrl": "//gw.alicdn.com/bao/uploaded/i3/276591537/O1CN011io6mn1NDzE5exQow_!!276591537.jpg_440x440q70.jpg",
                                "sales": 0
                                }
                            }
                            ]
                        },
                        {
                            "storeId": 9,
                            "storeName": "凡奈诗韩版女鞋店",
                            "storeIntroduce": "该品牌创立于yyyy年",
                            "browseTimes": 222,
                            "imgUrl": "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2456054635,3769338752&fm=26&gp=0.jpg",
                            "productGroupVOS": []
                        },
                        {
                            "storeId": 11,
                            "storeName": "矿大一号店",
                            "storeIntroduce": "百年老店",
                            "browseTimes": 78,
                            "imgUrl": "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2135299834,1746253257&fm=26&gp=0.jpg",
                            "productGroupVOS": []
                        },{
                            "storeId": 9,
                            "storeName": "凡奈诗韩版女鞋店",
                            "storeIntroduce": "该品牌创立于yyyy年",
                            "browseTimes": 222,
                            "imgUrl": "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2456054635,3769338752&fm=26&gp=0.jpg",
                            "productGroupVOS": []
                        },
                        ]
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
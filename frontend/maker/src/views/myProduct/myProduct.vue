<template>
    <div>
        <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16" v-for="(groupCollectionVO,index) in groupCollectionVOS">
            <Col>
                <Avatar icon="ios-person" size="large" />
                <span class="mx-1">{{groupCollectionVO.storeVO.storeName}}</span>
            </Col>
            <Col>
                <img :src=groupCollectionVO.storeVO.productGroupVOS[groupCollectionVO.collectedGroupIndex].productVO.imgUrl alt="" class="productImg">
            </Col>
            <Col>
                <div class="name my-1"><router-link to="/product" class="a1" @click.native="changeGroupId(groupCollectionVO)">{{groupCollectionVO.storeVO.productGroupVOS[groupCollectionVO.collectedGroupIndex].productName}}</router-link></div>
                <div class="price">￥{{groupCollectionVO.storeVO.productGroupVOS[groupCollectionVO.collectedGroupIndex].productVO.productPrice}}</div>
            </Col>
            <Col>
                <button  class="btn btn-default" @click="cancelCollect(groupCollectionVO)">取消收藏</button>
            </Col>
            <Divider />
        </Row>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                groupCollectionVOS: [
                    {
                        storeVO: {
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
                        collectedGroupIndex: 0
                    },
                    {
                        storeVO: {
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
                        collectedGroupIndex: 1
                    }
                ]
            }
        },
        mounted(){
            this.axios.get("/api/collect/group")
                .then(res=>{
                    this.groupCollectionVOS = res.data
                })
        },
        methods: {
            cancelCollect(groupCollectionVO) {
                this.axios.delete("/api/collect/group" + "?storeId=" + groupCollectionVO.storeVO.storeId
                    + "&collectGroupId=" + groupCollectionVO.storeVO.productGroupVOS[groupCollectionVO.collectedGroupIndex].groupId)
                    .then(this.axios.get("/api/collect/group/" + "?userId=" + this.$store.state.userid)
                        .then(res=>{
                            this.groupCollectionVOS = res.data
                        }))
            },
            changeGroupId(groupCollectionVO) {
                this.$store.state.currentStore = groupCollectionVO.storeVO;
                this.$store.state.currentProductGroupId = groupCollectionVO.storeVO.productGroupVOS[groupCollectionVO.collectedGroupIndex].groupId;
            }
        }
    }
</script>

<style scoped>
.productImg{
    width: 100px;
    height: 100px;
}
.price{
    color: red;
    margin-top: 20px;
}
</style>
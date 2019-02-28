<template>
    <div>
        <button class="btn btn-default" @click="refresh()">刷新</button>
        <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16" v-for="(groupEvaluationVO,index) in groupEvaluationVOS">
            <Col>
                <Avatar icon="ios-person" size="large" />
                <span class="mx-1">{{groupEvaluationVO.storeVO.storeName}}</span>
            </Col>
            <Col>
                <img :src=groupEvaluationVO.storeVO.productGroupVOS[groupEvaluationVO.groupIndex].productVO.imgUrl alt="" class="productImg">
            </Col>
            <Col>
                <div class="name my-1"><router-link to="/product" class="a1" @click.native="changeGroupId(groupEvaluationVO)">{{groupEvaluationVO.storeVO.productGroupVOS[groupEvaluationVO.groupIndex].productName}}</router-link></div>
                <div class="price">￥{{groupEvaluationVO.storeVO.productGroupVOS[groupEvaluationVO.groupIndex].productVO.productPrice}}</div>
            </Col>
            <Col>
                <Rate disabled allow-half v-model="groupEvaluationVO.valueDisabled" />
            </Col>
            <Divider />
        </Row>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                groupEvaluationVOS: [
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
                        groupIndex: 0,
                        valueDisabled: 1.5
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
                        groupIndex: 1,
                        valueDisabled: 3.5
                    }
                ]
            }
        },
        mounted(){
            this.axios.get("/api/evaluate")
                .then(res=>{
                console.log(res);
                    this.groupEvaluationVOS = res.data
                })
        },
        methods: {
            refresh() {
                this.axios.get("/api/evaluate")
                    .then(res=>{
                        this.groupEvaluationVOS = res.data
                    })
            },
            changeGroupId(groupEvaluationVO) {
                this.$store.state.currentStore = groupEvaluationVO.storeVO;
                this.$store.state.currentProductGroupId = groupEvaluationVO.storeVO.productGroupVOS[groupEvaluationVO.groupIndex].groupId;
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
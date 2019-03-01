<template>
    <div>
        <button class="btn btn-default" @click="refresh()">刷新</button>
<!--         <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16" v-for="(groupEvaluationVO,index) in groupEvaluationVOS">
            123
        </Row> -->
        <div class="wrapper">
               <div class="username">{{comments.user.username}}</div>
               <div class="storeName">{{comments.product.productName}}</div>
               <div class="content">{{comments.commentContent}}</div>
               <div class="date">{{comments.commentTime}}</div>
               <div class="img">
                   <img :src='comments.imgUrl1' alt="">
               </div>
               <div class="img" v-if="comments.imgUrl2">
                   <img :src='comments.imgUrl2' alt="">
               </div>
               <div class="img" v-if="comments.imgUrl3">
                   <img :src='comments.imgUrl3' alt="">
               </div>
               <div class="img" v-if="comments.imgUrl4">
                   <img :src='comments.imgUrl4' alt="">
               </div>
           </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                hello: 1,
                comments:{},
                // groupEvaluationVOS: [
                //     { 
                //         storeVO: {
                //             "storeId": 1,
                //             "storeName": "优品阁",
                //             "storeIntroduce": "优品阁创立于yyyy年mm月dd日，绝对正品，童叟无欺",
                //             "browseTimes": 666,
                //             "imgUrl": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544608736759&di=2b4dd592145830f2c1bd58b19b37cf95&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4a36acaf2edda3ccc3e322bd0be93901213f922c.jpg",
                //             "productGroupVOS": [
                //                 {
                //                     "groupId": 1,
                //                     "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                //                     "productVO": {
                //                         "productId": 1,
                //                         "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                //                         "productDescription": "好",
                //                         "productPrice": 2,
                //                         "imgUrl": "https://gd1.alicdn.com/imgextra/i1/3200146288/TB2I47ri8fH8KJjy1XbXXbLdXXa_!!3200146288.jpg_400x400.jpg",
                //                         "sales": 0
                //                     }
                //                 },
                //                 {
                //                     "groupId": 2,
                //                     "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                //                     "productVO": {
                //                         "productId": 4,
                //                         "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                //                         "productDescription": "nice",
                //                         "productPrice": 122,
                //                         "imgUrl": "//gw.alicdn.com/bao/uploaded/i3/276591537/O1CN011io6mn1NDzE5exQow_!!276591537.jpg_440x440q70.jpg",
                //                         "sales": 0
                //                     }
                //                 }
                //             ]
                //         },
                //         groupIndex: 0,
                //         valueDisabled: 1.5
                //     },
                //     {
                //         storeVO: {
                //             "storeId": 1,
                //             "storeName": "优品阁",
                //             "storeIntroduce": "优品阁创立于yyyy年mm月dd日，绝对正品，童叟无欺",
                //             "browseTimes": 666,
                //             "imgUrl": "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544608736759&di=2b4dd592145830f2c1bd58b19b37cf95&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4a36acaf2edda3ccc3e322bd0be93901213f922c.jpg",
                //             "productGroupVOS": [
                //                 {
                //                     "groupId": 1,
                //                     "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                //                     "productVO": {
                //                         "productId": 1,
                //                         "productName": "港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套 ",
                //                         "productDescription": "好",
                //                         "productPrice": 2,
                //                         "imgUrl": "https://gd1.alicdn.com/imgextra/i1/3200146288/TB2I47ri8fH8KJjy1XbXXbLdXXa_!!3200146288.jpg_400x400.jpg",
                //                         "sales": 0
                //                     }
                //                 },
                //                 {
                //                     "groupId": 2,
                //                     "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                //                     "productVO": {
                //                         "productId": 4,
                //                         "productName": "旋律风车chic羊羔毛外套男翻领冬季棉袄加厚新款格子短款棉衣潮流 ",
                //                         "productDescription": "nice",
                //                         "productPrice": 122,
                //                         "imgUrl": "//gw.alicdn.com/bao/uploaded/i3/276591537/O1CN011io6mn1NDzE5exQow_!!276591537.jpg_440x440q70.jpg",
                //                         "sales": 0
                //                     }
                //                 }
                //             ]
                //         },
                //         groupIndex: 1,
                //         valueDisabled: 3.5
                //     }
                // ]
            }
        },
        mounted(){
            // console.log(this.comments)
            this.axios.get("/api/evaluate")
                .then(res=>{
                // console.log(res)
                    this.groupEvaluationVOS = res.data
                })
            this.axios.get("/api/comment/getComments/1")
            .then(res=>{
                
                this.comments = res.data
                console.log(this.comments)
            })
            console.log(this.hello)
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
.wrapper {
    display: flex;
    line-height: 80px;
}
.username{
    margin: 0 20px;
}
.storeName {
     margin: 0 20px;
}
.content{
     margin: 0 20px;
}
.img {
    width: 50px;
    height: 80px;
    overflow: hidden;
    margin: 0 20px;
}
.img img {
    width: 100%;
}
</style>
<template>
    <div>
        
        <!--购买界面-->
        <div class="container" style="max-width: 1050px">
            <button class="btn btn-default" @click="collectProduct()">收藏</button>
            <button class="btn btn-default" @click="cancelCollectProduct()">取消收藏</button>
            <section id="goumaijiemian">
                <div class="row">
                <div class="col-12 col-md-6 col-sm-12">
                    <div class="shangpintupian">
                        <img :src="this.product.imgUrl" width="450px" class="img-responsive center-block img-thumbnail img-fluid">
                    </div>
                </div>
                
                <div class="col-12 col-md-6 col-sm-12">
                    <div class="shangpinmingcheng">
                        <span>{{product.productName}}</span>
                    </div>
                    <div class="danjia" style="margin-top: 30px">
                        <strong>单价：{{product.price}}</strong>
                    </div>
                    
                    <div class="yansefenlei" style="margin-top: 40px">
                    <span>颜色分类：</span>
                    <img id="beizi1" class="beizi1" @click="changeIndex(index)" v-for="(item, index) in productGroup" :key="index" :src="item.imgUrl" width="20%">
                    </div>
                    
                    <div class="shuliang" style="margin-top: 10px">
                        <br>
                        <span>数量：</span>
                        <list v-for="(List,idx) in List" :key="idx">
                        <button class="btn btn-default" @click="cuts(idx)">-</button>
                        <span>{{List.num}}</span>
                        <button class="btn btn-default" @click="add(idx)">+</button>
                        </list>
                    </div>
                    
                    <div class="goumaixuanxiang">
                        <router-link to="/receiver" class="btn btn-danger btn-lg">立即购买</router-link>
                        <router-link to="/cart" class="btn btn-warning btn-lg text-white" @click.native="addGroupToCart">加入购物车</router-link>
                    </div>
                </div>
                </div>
            </section>
        </div>


        <!-- 商品详情 -->
         <div class="container" style="max-width: 1050px">
             <div>
                 <div class="rounded select text-center row">
                     <div class="xiangqing float-left rounded col-6" style="background-color: #dadada">
                         <strong>商品详情</strong>
                     </div>
                     <div class="pingjia float-left rounded col-6" style="background-color: #dadada">
                         <strong>评价</strong>
                     </div>
                 </div>
             </div>
             <div class="row">
                <section id="shangpinxiangqing" class="col-6">
                    <div class="wenzishuoming mb-3">
                        <div class="row">
                            <div class="col-12 col-md-4 col-sm-12" v-for="(item,index) in product.specifications" :key="index">
                                <span>{{item.specification}}:{{item.specificationValue}}</span>
                            </div>
                        </div>
                    </div>
                </section>
                 <section id="evaluation" class="col-6">
                     <div class="row summary mb-3">
                         <div class="col-4 level font-weight-bold">
                             <span v-for="(item,index) in level">{{item}}</span>
                         </div>
                         <div class="col-8 keyword">
                             <div class="float-left key_content rounded" v-for="(item,index) in keyword">
                                 <span>{{item.content}}</span>
                                 <span>{{item.number}}</span>
                             </div>
                         </div>
                         <hr width="100%" color="#FFAD86" size="50" />
                         <div class="row comment" v-for="(item,index) in evaluation">
                             <div class="col-3 nickname">
                                 <div style="color: red">{{item.user.username}}</div>
                                 <div>店铺风格：{{item.starLevel1}}</div>
                                 <div>商品质量：{{item.starLevel2}}</div>
                                 <div>服务态度：{{item.starLevel3}}</div>
                             </div>
                             <div class="col-9">
                                 <div class="param_content" style="font-size: 15px">
                                     {{item.commentContent}}
                                 </div>
                                 <div class="eva_param rounded">
                                     <div>{{item.commentTime}}</div>
                                     <div>{{item.product.productName}}</div>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </section>
             </div>
        </div>
    </div>
</template>

<script>
    import $ from 'jquery'
       
    $(function(){
        $('#beizi1').click(function() {
        $(this).css('borderStyle','solid')
        $('#beizi2').css('borderStyle','none')
        $('#beizi3').css('borderStyle','none')
        $('#beizi4').css('borderStyle','none')
    });

        $('#beizi2').click(function() {
        $(this).css('borderStyle','solid')
        $('#beizi1').css('borderStyle','none')
        $('#beizi3').css('borderStyle','none')
        $('#beizi4').css('borderStyle','none')
    });

        $('#beizi3').click(function() {
        $(this).css('borderStyle','solid')
        $('#beizi1').css('borderStyle','none')
        $('#beizi2').css('borderStyle','none')
        $('#beizi4').css('borderStyle','none')
    });

        $('#beizi4').click(function() {
        $(this).css('borderStyle','solid')
        $('#beizi1').css('borderStyle','none')
        $('#beizi2').css('borderStyle','none')
        $('#beizi3').css('borderStyle','none')
    });
    })
    export default {
        data() {
            return {
                currentIndex:0,
                productGroup:[],
                List:[{
                    num:1
                }],
                level:[4.9],
                evaluation:[],
            }
        },
        methods: {
            cuts:function(idx){
                if(this.List[idx].num<2) return
                this.List[idx].num--;
            },
            add:function(idx){
                this.List[idx].num++;    
            },
            changeIndex(index){
                this.currentIndex = index
            },
            collectProduct() {
                this.axios.post("/api/collect/group" + "?storeId=" + this.$store.state.currentStore.storeId + "&collectGroupId=" + this.$store.state.currentProductGroupId)
            },
            cancelCollectProduct() {
                this.axios.delete("/api/collect/group" + "?storeId=" + this.$store.state.currentStore.storeId + "&collectGroupId=" + this.$store.state.currentProductGroupId)
            },
            addGroupToCart() {
                this.axios.put("api/cart/addProduct" + "?storeId=" + this.$store.state.currentStore.storeId
                    + "&productId=" + this.product.productId
                    + "&productQuantity=" + this.List[0].num);
                    // this.$router.go(0);            
            }
        },
        mounted(){
            this.axios.get("/api/product/group/"+this.$store.state.currentProductGroupId)
                .then(res=>{
                    this.productGroup = res.data
                    this.axios.get("/api/product/getProductComments/"+this.productGroup[this.currentIndex].productId)
                        .then(res=>{
                            this.evaluation = res.data
                            console.log(res.data)
                        })
                })
        },
        computed: {
            product() {
                return this.productGroup[this.currentIndex] 
            },
            groupId() {
                return this.$store.state.currentProductGroupId
            }
        },
        watch: {
            groupId(newValue, oldValue) {
                this.axios.get("/api/product/group/"+this.$store.state.currentProductGroupId)
                .then(res=>{
                    this.productGroup = res.data
                })
            },
            currentIndex(newValue, oldValue){
                this.axios.get("/api/product/getProductComments/"+this.productGroup[newValue].productId)
                    .then(res=>{
                        this.evaluation = res.data
                    })
            }
        },
    }
</script>

<style scoped>
.shangpintupian{
    margin-top: 30px;
}
.dianpudaohang{
    background-color: #fbe6be;
    line-height: 40px;
}

.shangpinmingcheng{
    font-size: 20px;
    margin-top: 30px;
}

.danjia{
    background-color: #ffe5e5;
    font-size: 40px;
    color:#eb8e8e;
}

.goumaixuanxiang{
    line-height: 150px;
    color:white;
}

.select{
    background-color: #dadada;
    margin-bottom: 10px;
}

.xiangqing,.pingjia{
    padding: 3px 10px;
    font-size: 30px;
    margin-top: 1px;
}

.xiangqing{
    background-color:white;
}

.xiangqingtupian{
    background-color: #eeeeee;
    margin:0 auto;
}

.yansefenlei{
    margin-top: 25px;
}

.level{
    font-size: 40px;
    color: orange;
}
.key_content{
    font-size: 15px;
    background-color: #FFA042;
    color: white;
    margin: 10px;
    padding: 5px;
}
.nickname{
    vertical-align: middle;
    margin:auto;
}
.eva_param{
    padding-top: 5px;
}
.comment{
    width: 100%;
    display:flex;
    padding: 10px;
}

#beizi1 {
  border: 4px solid rgba(255,0,0,0.6); }

#beizi2 {
  border: 4px none rgba(255,0,0,0.6); }

#beizi3 {
  border: 4px none rgba(255,0,0,0.6); }

#beizi4 {
  border: 4px none rgba(255,0,0,0.6); }

</style>
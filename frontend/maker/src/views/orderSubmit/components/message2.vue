<template>
    <div id="tijiaokuang">
        <div class="row" v-for="(item,orderSubmit) in Message2" :key="orderSubmit">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="xinfeng" style="border-radius: 5px">
                    <div class="zongjia" style="margin-right: 10px"><strong>{{item.sum}}</strong></div><br><br><br><br>
                    <div class="dizhi"><center>寄送至：{{item.location}}</center></div><br><br>
                    <div class="shouhuoren"><center>收货人：{{item.owner}}</center></div><br>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>

        <div class="anniu">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <center><router-link to="payment" @click.native="postOrderMasterInfo" type="button" class="btn btn-danger btn-lg">提交订单</router-link></center>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</template>

<script>
    export default {

        data() {
            return {
                Message2:[
                    {
                        sum:"¥20",
                        location:"江苏省 徐州市 泉山区 中国矿业大学南湖校区XXXX",
                        owner:"XXX 151XXXXXXXX",
                    }
                ],
                orderid:null,
            }
        },
        methods:{
            //向订单管理中添加记录
            postOrderMasterInfo(){
                this.axios.post('/api/orderMaster/insertOrderMaster', {
                    orderId:null,
                    userId:this.$store.state.userid,
                    payStatus:0,
                    orderAmount:this.$store.state.pricesum,
                    orderTime:((new Date()).valueOf()/1000).toFixed(0)*1000
                })
                    .then((response)=>{
                        this.$store.state.orderid=response.data;
                        this.postdetail();
                    })
                    .catch((error)=>{
                        console.log(error);
                    });

            },
            //向订单详情中添加记录
            postOrderDetailInfo(productId,productQuantity){
                this.axios.post('/api/orderDetail/insertOrderDetail', {
                    detailId:null,
                    orderId:this.$store.state.orderid,
                    productId:productId,
                    productQuantity:productQuantity,
                    productPrice:1,
                    orderStatus:0,
                    orderAmount:this.$store.state.pricesum,
                    productName:'null'
                })
                    .then((response)=>{
                    })
                    .catch((error)=>{
                        console.log(error);
                    });
            },
            // 删除商品
            axiosdelete(storeid,productid){
            this.axios.delete('/api/cart/deleteCartProduct',{
                params:{
                    cartId:this.$store.state.cartid,
                    storeId:storeid,
                    productId:productid
                }
            })
            .then((response)=>{this.deletestatus=response.data})
            .catch((error)=>{console.log(error);});
            },
            postdetail(){
                this.$store.state.cartchecked.forEach(
                    (item)=>{
                    this.postOrderDetailInfo(item.productid,item.quantity);
                    this.axiosdelete(item.storeid,item.productid);
                    },this);  
            }

        }
    }
</script>

<style scoped>
    .xinfeng{
        border:3px solid #ff3333;
        margin-top: 30px;
        height: 200px;
        box-shadow: 0px 0px 1px 1px #ff3333;
    }

    .zongjia{
        float: right;
        font-size: 50px;
        color:#ff3333;
        font-family: '宋体';
    }
</style>
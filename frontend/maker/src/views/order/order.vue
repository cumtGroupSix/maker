<template>
    <div class="container" style="max-width: 1100px">
        <div class="wodedingdan">我的订单</div>

        <div class="biankuang">
            <div class="daohangtiao">
                <div class="row" v-for="(item, index) of message2" :key="index">
                    <div class="col-12 col-md-3 col-sm-12" >
                        <div class="dingdanid" ><strong>订单ID</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.orderId}}</div>
                    </div>
                    <div class="col-12 col-md-3 col-sm-12" >
                        <div class="zhifuzhuangtai" ><strong>支付状态</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.payStatus}}</div>
                    </div>
                    <div class="col-12 col-md-3 col-sm-12" >
                        <div class="dingdanzongjia" ><strong>订单总价</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.orderAmount}}</div>
                    </div>
                    <div class="col-12 col-md-3 col-sm-12">
                        <div class="caozuo"><strong>操作</strong></div>
                        <div style="text-align: center" class="button"><router-link to="/orderDetail" class="btn btn-danger btn-small">查看详情</router-link></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        data() {
            return {
                message2:[],
            }
        },

        methods:{
            getMessageInfo(){
                axios.get('/api/orderMaster/getByUserId')
                    .then((res)=> {
                        if (res.status == 200 && res.data) {
                            this.message2 = res.data;
                        }
                        console.log(this.message2)
                    })
                    .catch((error)=> {console.log(error)})

            },
        },
        computed:{
            message(){
                return this.$store.state.message2;
            }
        },
        watch:{
            message:function(data,olds){
                this.message2.userId=this.$store.state.userid;
                this.message2.orderId=data.orderId;
                this.message2.payStatus=data.payStatus=="1"?"已发货":"未发货";
                this.message2.orderAmount=data.orderAmount;
                this.message2.productName=data.productName;
            }
        },
        mounted(){
            this.getMessageInfo()
        }
    }
</script>

<style scoped>
    .daohangtiao{
        font-family: '黑体';
        line-height: 40px;
    }

    .biankuang{
        border: 2px solid #dddddd;
        border-radius: 5px;
        margin-bottom: 20px;
    }

    .dingdanid{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .zhifuzhuangtai{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .dingdanzongjia{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .caozuo{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .wodedingdan{
        font-family: '隶书';
        color:#ff9966;
        font-size: 50px;
    }

    .button{
        margin-bottom: 5px;
        margin-top: 5px;
    }
</style>

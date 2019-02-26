<template>
    <div class="container" style="max-width: 1500px">
        <div class="row">
            <!--页头-->
            <div class="col-12"><my-title></my-title></div>
            <!--提交信息1-->
            <div class="col-12"><my-message1></my-message1></div>
            <!--提交信息2-->
            <div class="col-12"><my-message2></my-message2></div>
        </div>
    </div>
</template>

<script>
    import MyTitle from  './components/title'
    import MyMessage1 from './components/message1'
    import MyMessage2 from './components/message2'
    import axios from 'axios'

    export default {
        components:{
            MyTitle,
            MyMessage1,
            MyMessage2
        },
        data(){
            return{
            }
        },

        methods:{
            //向订单详情中添加记录
            postOrderDetailInfo(){
                axios.post('/api/orderDetail/insertOrderDetail', {
                    detsilId:'1',
                    orderId:'1',
                    productId:'1',
                    productPrice:'2',
                    productQuantity:'2',
                    orderStatus:'1',
                    orderAmount:'4',
                    productName:'港风棉衣男潮流ins情侣棉服青年学生宽松连帽加厚面包服工装外套'
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },

            //向订单管理中添加记录
            postOrderMasterInfo(){
                axios.post('/api/orderMaster/insertOrderMaster', {
                    orderId:'1',
                    userId:'1',
                    payStatus:'1',
                    orderAmount:'4',
                    orderTime:new Date()
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        mounted(){
            this.postOrderDetailInfo()
            this.postOrderMasterInfo()
        }

    }
</script>

<style scoped>

</style>
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
                    <center><a href="payment.html" type="button" class="btn btn-danger btn-lg">提交订单</a></center>
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
                ]
            }
        },
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
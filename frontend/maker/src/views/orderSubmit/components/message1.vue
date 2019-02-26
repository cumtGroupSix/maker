<template>

    <div id="dingdanxiangqing">
        <div class="biankuang">
            <div class="daohangtiao">
                <div class="row" v-for="(item,orderSubmit) in Message1" :key="orderSubmit">
                    <div class="col-12 col-md-1 col-sm-12" >
                        <div class="dianpubaobei" ><strong>订单详情ID</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.id1}}</div>
                    </div>
                    <div class="col-12 col-md-1 col-sm-12" >
                        <div class="dianpubaobei" ><strong>订单ID</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.id2}}</div>
                    </div>
                    <div class="col-12 col-md-1 col-sm-12" >
                        <div class="dianpubaobei" ><strong>商品ID</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.id3}}</div>
                    </div>
                    <div class="col-12 col-md-4 col-sm-12" >
                        <div class="dianpubaobei" ><strong>商品名称</strong></div>
                        <div style="text-align: center; font-family: 微软雅黑">{{item.name}}</div>
                    </div>
                    <div class="col-12 col-md-1 col-sm-12">
                        <div class="danjia"><strong>单价</strong></div>
                        <div style="text-align: center">{{item.price}}</div>
                    </div>
                    <div class="col-12 col-md-2 col-sm-12">
                        <div class="shuliang"><strong>数量</strong></div>
                        <div style="text-align: center">{{item.count}}</div>
                    </div>
                    <div class="col-12 col-md-2 col-sm-12">
                        <div class="xiaoji"><strong>小计</strong></div>
                        <div style="color:#ff3333;text-align: center"><strong>{{item.sum}}</strong></div>
                    </div>
                </div>
            </div>

            <div class="beizhu">
                <div class="row" v-for="(item,orderSubmit) in Message1" :key="orderSubmit">
                    <div class="col-md-4">
                        <br><br><br><div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">给卖家留言：</span>
                        </div>
                        <input type="text" class="form-control" placeholder="选填">
                    </div>
                        <div>店铺名：{{item.store}}</div>
                    </div>
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <br><br><span>{{item.detail1}}</span><br><br>
                        <span>{{item.detail2}}</span><br><br>
                        <span>店铺合计(含运费):{{item.sum}}</span><br><br>
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
                Message1:[
                    {
                        id1:"1",
                        id2:"1",
                        id3:"1",
                        name:"杯子",
                        price:"20",
                        count:"2",
                        sum:"40",
                        store:"诺拉家",
                        detail1:"运送方式：普通配送 快递 免邮",
                        detail2:"发货时间：卖家承诺订单在买家付款后, 24小时内发货",
                    }
                ]
            }
        },
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
    }

    .dianpubaobei{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .shangpinxiangqing{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .danjia{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .shuliang{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }

    .xiaoji{
        border: 2px solid #dddddd;
        border-radius: 5px;
        background-color: #fff0e1;
        text-align: center;
        color:#ff9966;
    }
</style>
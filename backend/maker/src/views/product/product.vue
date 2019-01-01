<template>
    <div>
        <!-- 店铺导航 -->
        <section id="dianpudaohang">
        	<div class="dianputupian">
        		<img src="@/assets/img/dianputupian.jpg" width="100%">
        	</div>
        </section>
        
        <!--购买界面-->
        <div class="container" style="max-width: 1050px">
            <section id="goumaijiemian">
                <div class="row">
                <div class="col-12 col-md-6 col-sm-12">
                    <div class="shangpintupian">
                        <img src="@/assets/img/list-1.jpg" width="450px" class="img-responsive center-block img-thumbnail img-fluid">
                    </div>
                </div>
                
                <div class="col-12 col-md-6 col-sm-12">
                    <div class="shangpinmingcheng"> 
                        <span>猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子</span>
                    </div>
                    
                    <div class="danjia" style="margin-top: 30px">
                    <strong>单价：¥20</strong>
                    </div>
                    
                    <div class="yansefenlei" style="margin-top: 40px">
                    <span>颜色分类：</span>
                    <img id="beizi1" class="beizi1" src="@/assets/img/beizi1.jpg" width="20%">
                    <img id="beizi2" class="beizi2" src="@/assets/img/beizi2.jpg" width="20%">
                    <img id="beizi3" class="beizi3" src="@/assets/img/beizi3.jpg" width="20%">
                    <img id="beizi4" class="beizi4" src="@/assets/img/beizi4.jpg" width="20%">
                    </div>
                    
                    <div class="shuliang" style="margin-top: 10px">
                        <br>
                        <span>数量：</span>
                        <list v-for="(List,idx) in List" :key="idx">
                        <button class="btn btn-default" @click="cuts(idx)"><</button>
                        <span>{{List.num}}</span>
                        <button class="btn btn-default" @click="add(idx)">></button>
                        </list>
                    </div>
                    
                    <div class="goumaixuanxiang">
                        <router-link to="/receiver" class="btn btn-danger btn-lg">立即购买</router-link>
                        <router-link to="/cart" class="btn btn-warning btn-lg text-white">加入购物车</router-link>
                    </div>
                </div>
                </div>
            </section>
        </div>


        <!-- 商品详情 -->
         <div class="container" style="max-width: 1050px">
            <section id="shangpinxiangqing">
                <div class="xiangqing  text-center">
                    <p><strong>商品详情</strong></p>
                </div>
                <div class="wenzishuoming">
                    <div class="row">
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>产地：中国大陆<br>流行元素：卡通<br>材质：陶瓷<br>颜色分类：1号哈士奇400ml…</span>
                        </div>
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>容量：301ml~400ml<br>适用人群：大众<br>价格区间：15元~30元<br>风格：卡通</span>
                        </div>
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>是否手工：是<br>适用对象：成人<br>品牌：诺拉和皮埃诺<br>主图来源：自主实拍图</span>
                        </div>
                    </div>
                </div>
                <div class="xiangqingtupian">
                    <img src="@/assets/img/xiangqing1.jpg" width="100%" class="img-responsive center-block" alt="">
                    <img src="@/assets/img/xiangqing2.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing3.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing4.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing5.jpg" width="100%" class="img-responsive center-block">
                </div>
            </section>
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
                List:[{
                    num:1
                }]
            }
        },
        methods: {
            cuts:function(idx){
                if(this.List[idx].num<2) return
                this.List[idx].num--;
            },
            add:function(idx){
                this.List[idx].num++;    
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

.xiangqing{
	font-size: 30px;
	background-color: #dadada;
}

.xiangqingtupian{
	background-color: #eeeeee;
	margin:0 auto;
}

.yansefenlei{
	margin-top: 25px;
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
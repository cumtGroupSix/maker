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
                    <div class="shangpinmingcheng" v-for="(Name,index) in Name" :key="index">
                        <span>{{Name.name}}</span>
                    </div>
                    <div class="danjia" style="margin-top: 30px" v-for="(Price,index) in Price" :key="index">
                    <strong>单价：{{Price.price}}</strong>
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
                        <button class="btn btn-default" @click="cuts(idx)">-</button>
                        <span>{{List.num}}</span>
                        <button class="btn btn-default" @click="add(idx)">+</button>
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
            <div class="row">
                <div class="col-12 rounded select text-center">
                    <div class="xiangqing float-left rounded" >
                        <strong>商品详情</strong>
                    </div>
                    <div class="pingjia float-left rounded" >
                        <strong>评价</strong>
                    </div>
                </div>
            </div>
            <section id="shangpinxiangqing">
                <div class="wenzishuoming" v-for="(Detail,index) in Detail" :key="index">
                    <div class="row">
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>{{Detail.a}}<br>{{Detail.b}}<br>{{Detail.c}}<br>{{Detail.d}}</span>
                        </div>
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>{{Detail.e}}<br>{{Detail.f}}<br>{{Detail.g}}<br>{{Detail.h}}</span>
                        </div>
                        <div class="col-12 col-md-4 col-sm-12">
                            <span>{{Detail.i}}<br>{{Detail.j}}<br>{{Detail.k}}<br>{{Detail.l}}</span>
                        </div>
                    </div>
                </div>
                <div class="xiangqingtupian">
                    <img src="@/assets/img/xiangqing1.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing2.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing3.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing4.jpg" width="100%" class="img-responsive center-block">
                    <img src="@/assets/img/xiangqing5.jpg" width="100%" class="img-responsive center-block">
                </div>
            </section>
            <section id="evaluation">
                <div class="row summary">
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
                            {{item.nickname}}
                        </div>
                        <div class="col-9">
                            <div class="param_content">
                                {{item.content}}
                            </div>
                            <div class="eva_param rounded">
                                {{item.eva_date}}
                                {{item.color}}
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</template>

<script>
    import $ from 'jquery'
        $('.xiangqing').click(function(){
            $(this).css("background-color","white")
            $(this).css("border-top","1px solid red")
            $('.pingjia').css("background-color","#dadada")
            $('.pingjia').css("border-top","none")
            $('#shangpinxiangqing').css("display","block")
            $('#evaluation').css("display","none")
        });

        $('.pingjia').click(function(){
            $(this).css("background-color","white")
            $(this).css("border-top","1px solid red")
            $('.xiangqing').css("background-color","#dadada")
            $('.xiangqing').css("border-top","none")
            $('#evaluation').css("display","block")
            $('#shangpinxiangqing').css("display","none")
        });
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
                }],
                Name:[
                    {
                        name:"猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子",
                    }
                ],
                Price:[
                    {
                        price:"¥20",
                    }
                ],
                Detail:[
                    {
                        a:"产地：中国大陆",
                        b:"流行元素：卡通",
                        c:"材质：陶瓷",
                        d:"颜色分类：1号哈士奇400ml…",
                        e:"容量：301ml~400ml",
                        f:"适用人群：大众",
                        g:"价格区间：15元~30元",
                        h:"风格：卡通",
                        i:"是否手工：是",
                        j:"适用对象：成人",
                        k:"品牌：诺拉和皮埃诺",
                        l:"主图来源：自主实拍图",
                    }
                ],
                level:[4.9],
                keyword:[
                    {
                        content:"包装好",
                        number:"(3)"
                    },
                    {
                        content:"物流快",
                        number:"(2)"
                    },
                    {
                        content:"适合送人",
                        number:"(4)"
                    },
                ],
                evaluation:[
                    {
                        nickname:"随心所欲烛",
                        eva_date:"2018/1/18",
                        content:"排在最上面的那个才是哦！！很差物流很快，卖家包装很严实，没有破损，杯子很喜欢，以后还会继续光顾的，赞一分钱一分货，用起来还行吧，不过绝对不是多么好的，想追求性价比的可以考虑下杯子和想象中的一样好看，东西一点破损也没有，很喜欢不错，包装厚实，一点没有破损，礼盒装也特别好看，喜欢，特别是杯子上的猫咪",
                        color:"黑色猫咪"
                    },
                    {
                        nickname:"薛之谦的小宝贝",
                        eva_date:"2018/7/17",
                        content:"做工没得说，买给我女朋友的，整体感觉不错，物流速度很快，包装也很到位，但是觉得作用不大，排除送人。",
                        color:"橘色猫咪"
                    },
                    {
                        nickname:"Dorio",
                        eva_date:"2018/1/3",
                        content:"挺好的杯子 就是感觉杯盖有点突兀...",
                        color:"黑色猫咪"
                    },
                    {
                        nickname:"随心所欲烛",
                        eva_date:"2018/2/3",
                        content:"杯子挺好看 包装也很完美 超级喜欢 物流很快 卖家服务态度很好 好评好评～",
                        color:"黑色猫咪"
                    },
                    {
                        nickname:"随心所欲烛",
                        eva_date:"2018/3/3",
                        content:"质量非常好 我收到了 洗了杯子 倒水的时候盖子重1米多高掉下去竟然没有碎 可以 可以",
                        color:"橘色猫咪"
                    },
                ],
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
}1

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
    border-top:1px solid red
}

#evaluation{
    display: none;
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
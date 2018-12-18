<template>
   <div class="container" style="max-width:800px" id="root">
		<div class="row">
			<div class="col-lg-2 col-sm-12">
				<div class="d-none d-sm-block">
					<button class="btn btn-primary" @click="primary">我的店铺</button>
					<button class="btn btn-info" @click="info">商品管理</button>
					<button class="btn btn-success" @click="success">订单处理</button>
				</div>
				<div class="d-block d-sm-none">
					<button class="btn btn-primary btn-sm" @click="primary">我的店铺</button>
					<button class="btn btn-info btn-sm" @click="info">商品管理</button>
					<button class="btn btn-success btn-sm" @click="success">订单处理</button>
				</div>
			</div>
			<div class="col-lg-10 col-sm-12">
				<div v-if="dp">
					<div class="text-left font-weight-bold">店铺信息</div>
					<form>
						<div class="form-group" stype="width:100%">
							<label for="name">店铺名</label>
							<input type="text" class="form-control" id="name" v-model="storeName">
						</div>
						<div class="form-group">
							<label for="time">开店时间</label>
							<input type="text" class="form-control" id="time" v-model="startTime">
						</div>
						<div class="form-group">
							<label for="introduction">店铺介绍</label>
							<textarea class="form-control" rows="9" placeholder="这里是店铺介绍" v-model="storeIntroduction"></textarea>
						</div>					
					</form>
					<button class="btn btn-warning float-right" @click="change">修改</button>
					<div class="changed" v-if="changed">
						<img class="img-fluid" src="../img/对勾.jpg">
						<button class="btn btn-default btn-block font-weight-bold" @click="successful">修改成功</button>
					</div>
				</div>
				<div v-if="yc">
					<div id="bigScreen">
	                    <table class="table table-hover" >
	                        <br />
	                        <thead>
	                            <tr>
	                                <th>序号</th>
	                                <th>商品名</th>
	                                <th>价格</th>
	                                <th>介绍</th>
	                                <th>操作</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr v-for = 'makerManage in filterMakerManages' style="background-color:#f6f5ec;border-radius:5px;margin:10px">
	                                <td>{{makerManage.manageNumber}}</td>
	                                <td>{{makerManage.productName}}</td>
	                                <td>{{makerManage.makerPrice}}</td>
	                                <td>{{makerManage.makerIntroduction}}</td>
	                                
	                            <!--模板标签 v-if    v-else-->
	                                
	                            <template v-if = 'makerManage.manageNumber %2 == 0'>
	                                <td  class="text-center">
	                                    <button type="button"  class="btn btn-success"  class="del" @click = "delProduct(makerManage)">删除</button>
	                                    <button type="button"  class="btn btn-success" @click = "updateProduct(makerManage)" >修改</button>
	                                </td>
	                            </template>    
	                            <template v-else>
	                                <td  class="text-center">　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　 <!-- 创建点击事件-->
	                                    <button type="button"  class="btn"  class="del" @click = "delProduct(makerManage)">删除</button>
	                                    <button type="button"  class="btn"  @click = "updateProduct(makerManage)">修改</button>
	                                </td>
	                            </template>        
	                            </tr>
	                        </tbody>
	                    </table>
					</div>

					<div id="smallScreen">
						<div v-for = 'makerManage in filterMakerManages' class="yc-small">
							<div class="row">
								<div class="col-12 col-sm-6">
									<div class="col-12">
										<span>{{makerManage.manageNumber}}</span>
										<span>{{makerManage.productName}}</span>
									</div>
									<div class="col-12">
										<span>价格</span>
										<span>{{makerManage.makerPrice}}</span>
									</div>
								</div>
								<div class="col-sm-6">
									<span>介绍:</span>
									<div>{{makerManage.makerIntroduction}}</div>
								</div>
							</div>
							<template v-if = 'makerManage.manageNumber %2 == 0'>                               
                                <button type="button"  class="btn btn-sm btn-success"  class="del" @click = "delProduct(makerManage)">删除</button>
                                <button type="button"  class="btn btn-sm btn-success" @click = "updateProduct(makerManage)" >修改</button>
	                                
	                        </template>    
	                        <template v-else>
                             <!-- 创建点击事件-->
                            	<button type="button"  class="btn btn-sm"  class="del" @click = "delProduct(makerManage)">删除</button>
                                <button type="button"  class="btn btn-sm"  @click = "updateProduct(makerManage)">修改</button>     
	                        </template>
						</div>
					</div>
	                 	<!--  添加商品信息  -->
                    <div id="add-product" >
                        <h3>添加商品</h3>
                        <hr />
                        <div class="form-group">
                            <label for="group">商品名</label>
                            <input type="text" class="form-control" id="group" v-model = "makerManage.productName">
                        </div>
                        <div class="form-group">
                            <label for="author">价格</label>
                            <input type="text" class="form-control" id="author" v-model = "makerManage.makerPrice">
                        </div>
                        <div class="form-group">
                            <label for="price">介绍</label>
                            <input type="text" class="form-control" id="price" v-model = "makerManage.makerIntroduction">
                        </div>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="imgFile">
							<label class="custom-file-label" for="imgFile">上传图片</label>
				  		</div>
                        <button class="btn btn-info float-right" @click="addClose">关闭</button>
                        <button class="btn btn-primary float-right" v-on:click = "addedProduct()">添加</button>
                    </div>
                    
            		<!--  修改商品信息  -->     
                    <div id="update-product" v-model="makerManages">
                        <h3>修改商品</h3>
                        <hr />
                        <div class="form-group">
                            <label for="group1">商品名</label>
                            <input type="text" class="form-control" id="group1"  v-model = "makerManage.productName">
                        </div>
                        <div class="form-group">
                            <label for="author1">价格</label>
                            <input type="text" class="form-control" id="author1" v-model = "makerManage.makerPrice">
                        </div>
                        <div class="form-group">
                            <label for="price1">介绍</label>
                            <input type="text" class="form-control" id="price1" v-model = "makerManage.makerIntroduction">
                        </div> 
                        <div class="custom-file">
							<input type="file" class="custom-file-input" id="imgFile">
							<label class="custom-file-label" for="imgFile">上传图片</label>
				  		</div>
                        <button class="btn btn-primary btn-block" style="margin-top:20px" v-on:click = "updatedProduct()">完成</button>
                    </div>                 	
					<button type="button" class="btn btn-info float-right" @click="addProduct">添加商品</button>
				</div>
				<div v-if="ddcl">
					<div id="bigScreen">
						<table class="table">
							<thead>
								<tr>
									<th>序号</th>
									<th>所购商品</th>
									<th>客户</th>
									<th>地址</th>
									<th>物流状态</th>
									<th>物流详情</th>
								</tr>
							</thead>
							<tbody >
								<tr class="" v-for="item of makerOrder">
									<td class="">{{item.orderNumber}}</td>
									<td class="form-group">
										<input type="text" class="form-control text-center product" :value="item.overProduct">
									</td>
									<td class="form-group">
										<input type="text" class="form-control text-center input-sm product" :value="item.customer">
									</td>
									<td class="form-group">
										<textarea  class="form-control text-center product" rows="2" cols="30"> {{item.cusDestination}}</textarea>
									</td>
									<td class="">{{item.makerLogistics}}</td>
									<td class="">
										<button class="btn btn-info" @click="look">{{item.logisticsDetail}}</button>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="smallScreen">
						<div class="row ddcl-small" v-for="item of makerOrder">
							<div class="col-12 col-sm-6">
								<div>
									<span>{{item.orderNumber}}</span>
									<span>客户：</span>
									<span>{{item.customer}}</span>
								</div>
								<div>
									<span>所购商品：</span>
									<span>{{item.overProduct}}</span>
								</div>
								<div>
									<span>物流状态：</span>
									<span>{{item.makerLogistics}}</span>
								</div>
							</div>
							<div class="col-12 col-sm-6">
								<span>地址：</span>
								<div>{{item.cusDestination}}</div>
							</div>
							<button class="btn btn-sm btn-info" @click="look">物流详情</button>
						</div>	
					</div>
					<div class="logisticsDetail" style="border:1px solid orange;border-radius: 5px" v-if="logisticsDetail">
						<div class="text-center rounded" style="border-bottom:2px solid gray;background-color:#cde6c7">
							<span class="font-weight-bold">黄梨汁</span>
							<span class="text-danger">物流信息</span>
						</div>
						<table class="table" style="margin-top:10px">
							<tr v-for="item of detailList" :class="item.color">
								<td>
									<div class="row ">
										<div class="col-4" style="height:100%;line-height:100%">
											{{item.date}}
										</div>
										<div class="col-8 float-right">
											<ul>
												<li :id="item.dateID">{{item.infomation}}</li>
											</ul>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-info btn-sm float-right" @click="cancel">确定</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
    export default {
        var manageNumber = 0;
		var vm = new Vue({

			el:"#root",
			data:{
				storeName:"",
				startTime:"",
				storeIntroduction:"",
				dp: true,
				yc: false,
				ddcl: false,
				changed: false,
				logisticsDetail:false,
				makerManage : [{                        
                        manageNumber : 0,
                        productName : '',
                        makerPrice : '',
                        makerIntroduction : ''                        
                    }],
                    
                    makerManages : [{                        
                        manageNumber : 1,
                        productName : '黄梨汁',
                        makerPrice : '￥20',
                        makerIntroduction : '这是我家乡的特产'                        
                    },{                        
                        manageNumber : 2,
                        productName : '黄梨汁',
                        makerPrice : '￥20',
                        makerIntroduction : '这是我家乡的特产'       
                    },{                        
                        manageNumber : 3,
                        productName : '黄梨汁',
                        makerPrice : '￥20',
                        makerIntroduction : '这是我家乡的特产'              
                    },{                    
                        manageNumber : 4,
                        productName : '黄梨汁',
                        makerPrice : '￥20',
                        makerIntroduction : '这是我家乡的特产'
                   
                    }],      
                    
                    search : "",      // 查询功能，""中不能加空格，否则默认查询空格
				makerOrder:[
					{
						orderNumber:"1",
						overProduct:"黄梨汁",
						customer:"UZI",
						cusDestination:"中国矿业大学南湖校区松1A4031",
						makerLogistics:"派送中",
						logisticsDetail:"查看"
					},
					{
						orderNumber:"2",
						overProduct:"黄梨汁",
						customer:"UZI",
						cusDestination:"中国矿业大学南湖校区松1A4031",
						makerLogistics:"派送中",
						logisticsDetail:"查看"
					},
					{
						orderNumber:"3",
						overProduct:"黄梨汁",
						customer:"UZI",
						cusDestination:"中国矿业大学南湖校区松1A4031",
						makerLogistics:"派送中",
						logisticsDetail:"查看"
					},
				], 
				detailList:[
					{
						color:"table-primary",
						dateID:"date1",
						date:"8月4日(周六)",
						infomation:"卖家发货;在中国矿业大学大学生创客联盟进行揽件扫描"
					},
					{
						color:"table-success",
						dateID:"date2",
						date:"8月5日(周日)",
						infomation:"在中国矿业大学大学生创客联盟分拨中心进行分拨；发往松一分拨中心"
					},
					{
						color:"table-danger",
						dateID:"date3",
						date:"8月6日(周一)",
						infomation:"到达松一分拨中心，快件很快进行派送；快件正在派送中，松一分部派件员 xxx：12345678901"
					},
				],

			},
			methods:{
				primary:function(){
					this.dp=true;
					this.yc=false;
					this.ddcl=false;
				},
				info:function(){
					this.dp=false;
					this.yc=true;
					this.ddcl=false;
				},
				success:function(){
					this.dp=false;
					this.yc=false;
					this.ddcl=true;
				},
				change:function(){
					this.changed=true;
				},
				successful:function(){
					this.changed=false;
				},
				look:function(){
					this.logisticsDetail=true;
				}, 
				cancel:function(){
					this.logisticsDetail=false;
				},

                addProduct : function(){
                    $("#add-product").css("display","block");
                },
                
                addedProduct : function(){
                    
                    this.makerManage.manageNumber = this.makerManages.length + 1;
                    this.makerManages.push(this.makerManage);
                    this.makerManage = {};
                    $("#add-product").css("display","none");
                },

                addClose : function(){
                    $("#add-product").css("display","none");
                },
                
                delProduct : function(makerManage){
                    var blength = this.makerManages.length;
                    this.makerManages.splice(makerManage.manageNumber-1,1 );
                    
                    for(var i = 0;i < blength;i++){
                        if(makerManage.manageNumber < this.makerManages[i].manageNumber){
                            this.makerManages[i].manageNumber -= 1;                                
                        }                            
                    }    
                },
                
  // 修改按钮                
                updateProduct : function(makerManage){
                    
                    $("#add-product").css("display","none");
                    $("#update-product").css("display","block");
                    manageNumber = makerManage.manageNumber;
                    
                },
        
        // 修改完成后的 确认按钮点击事件
                updatedProduct : function(){
                    
                    this.makerManage.manageNumber = manageNumber;
                    this.makerManages.splice(manageNumber-1,1,this.makerManage);
                    $("#update-product").css("display","none");
                    this.makerManage = {};
                    
                }
			},
			computed : {
                    
                filterMakerManages : function(){
                    var makerManages = this.makerManages;
                    var search = this.search;
                    return makerManages.filter(function(makerManage){
                        return makerManage.productName.toLowerCase().indexOf(search.toLocaleLowerCase()) != -1                        
                    });        
                }
                    
            },
                          
		})
    }
</script>

<style scoped>
.btn{
	margin:10px;
}

.container{
	margin-top:20px;
}

.text-left{
	margin:10px auto;
	padding:5px;
	border-bottom:2px solid gray;
}

.col-lg-10{
	border:1px solid black;
	position:relative;
	height:700px;
}

.product{
	border:none;
}

.table th, .table td { 
	text-align: center;
	vertical-align: middle
}

.changed{
	position:absolute;
	left:30%;
	top:20%;
	width:30%;
	height:30%;
	padding: 0px
}

#update-product,#add-product{
	display: none;
	position:absolute;
	background-color: #feeeed;
	left:50%;
	top:50%;
	transform:translate(-50%,-50%);
	z-index:1000;
	padding:10px;
	border-radius:10px;
	min-width: 300px;
}

.logisticsDetail{
	position:absolute;
	top:5%;
	left:5%;
	width:90%;
	height:90%;
	background-color: white;
	padding:10px;
}

 .btn-block{
 	margin:0px;
 }

 .foot {
 	margin-top: 50px;
 	height:100px;
 	line-height:100px;
 	background-color:rgba(255, 204, 153, 0.298039215686275)
 }

 .btn-sm{
 	margin:10px 2px;
 }

 .yc-small,.ddcl-small{
 	margin:10px;
 	padding:10px;
 	background-color:#f6f5ec;
 	border-radius:5px;
 	font-family:'隶书';
 	font-size:20px
 }

 #smallScreen{
 	display: none;
 }

.color{
	background-color: rgba(255, 204, 153, 0.298039215686275);
	padding-right: 20px
}

 #bigScreen{
 	display: block;
 }

 @media only screen and (max-width: 780px) {
    #smallScreen {
    	display: block;
    }
    #bigScreen{
    	display: none;
    }
}

@media only screen and (max-width:560px){
	.yc-small,.ddcl-small{
		font-size:15px;
	}
	.col-lg-10{
		height:1000px;
	}
}

@media only screen and (max-width:320px){
	.col-lg-10{
		border:none;
	}
}
</style>
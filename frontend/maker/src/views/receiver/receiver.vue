<template>
    <div id="root">
        <div class="container mx-auto" style="max-width:600px">
			<div class="row">
				<div class="col-sm-3 col-12 float-left font-weight-bold text-dark">
					收货人信息
				</div>
				<div class="col-sm-9 col-12 rounded" id="shr-infomation" >
					<form>
						<div class="form-group">
							<label for="shrName">收货人姓名：</label>
							<input type="text" class="form-control" required="required" id="shrName" placeholder="收货人姓名" v-model="receiverName">
						</div>
						<div class="form-group">
							<label for="number">手机号码：</label>
							<input type="tel" class="form-control" required="required" id="number" placeholder="手机号码" v-model="receiverNumber">
						</div>
						<div class="form-group">
							<label for="school">所在学校：</label>
							<select class="form-control" id="school">
								<option v-for="(item,index) of cusSchool" :key="index">{{item.name}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="detail">校园某一角：</label>
							<input type="text" class="form-control" id="detail" placeholder="详细地址" v-model="receiverDetail">
						</div>
						<div class="form-group">
							<label for="remark">备注：</label>
							<textarea class="form-control" rows="6" id="remark" v-model="receiverNote"></textarea>
						</div>
						<button class="btn btn-danger btn-lg float-right"><a href="orderSubmit" class="text-white">提交信息</a></button>
					</form>
				</div>
			</div>	
		</div>
    </div>
</template>

<script>
    export default {
		data() {
			return{
				receiverName:"",
				receiverNumber:"",
				receiverDetail:"",
				receiverNote:"",
				cusSchool:[
					{name:"请选择学校"},
					{name:"中国矿业大学"},
					{name:"江苏师范大学"},
					{name:"徐州医科大学"},
					{name:"南京大学"},
					{name:"南京理工大学"},
					{name:"南京林业大学"},
				]
			}
		}
    }
</script>

<style scoped>
#shr-infomation{
	background-color: rgba(255, 204, 153, 0.4);
	padding:10px 40px;
	margin-left: 0px
}

.container{
	margin:20px;
	
}

.bg-light{ 
	border:4px solid orange; }
</style>
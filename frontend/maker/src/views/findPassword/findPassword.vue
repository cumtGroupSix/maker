<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="9" :md="6" :lg="6" class="container">
    <Row justify="center" type="flex" style="margin-bottom:15px;margin-top:15px">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>找回密码</b></span>
	</Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" :readonly="disabled1" placeholder="用户名" :maxlength="15"><Icon type="md-person" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="password" name="newpassword" v-model="newpassword" placeholder="设置新密码" :maxlength="20"><Icon type="md-lock" slot="prefix"/></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="password" name="newpassword2" v-model="newpassword2" placeholder="确认新密码" :maxlength="20"><Icon type="md-lock" slot="prefix"/></Input>
    	</FormItem>	
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="11">
    	<FormItem>
	    	<Input name="validateCode" v-model="validatecode" placeholder="请输入验证码" :maxlength="4" clearable ><Icon type="ios-keypad" slot="prefix" /></Input>
	    </FormItem>
    	</Col>
    	<Col span="11" offset="2">
    	<FormItem align="right">
    	<Button type="primary" long @click="sendEmail" :disabled="disabled1">{{context}}</Button>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" style="margin-bottom:10px">	
    	<Col span="24">
		<FormItem>
    	<Button type="success" long @click="submitChange">确认修改</Button>
		</FormItem>	
    	</Col>
    	</Row> 	
    </Form>
    </Col>
    </Row> 
    </div>
</template>

<script>
    export default {
        data(){
        	return{
        	context:"获取验证码",
        	disabled1:false,
    		username:"",
    		oldpassword:"",
    		newpassword:"",
    		newpassword2:"",
    		validatecode:"",
    		res:null
        	}
        },
        methods:{
        axiosFindPassword(){
        	this.axios.post("/api/user/findPassword?username="+this.username+"&newPassword="+this.newpassword+"&imageCode="+this.validatecode)
        	.then((response)=>{
        		console.log(response);
        		if(response.data==1){
        		this.$Modal.success({
                            title:"重设密码成功",
                            content:"已成功重设密码",
                            onOk: () => {
                            this.$router.push({path: '/'});
                            this.$router.go(0); 
                            },
                        }); 
	        	}else{
					this.$Message.error('重设密码失败');
	        	}
        })
			.catch((error)=>{
				console.log(error);
				this.$Message.error('重设密码失败,请检查验证码');});
        },
        axiosSendEmail(){
        	this.axios.get("/api/code/email?username="+this.username)
        	.then((response)=>{
        		if(response.data==1){
        		this.$Message.success("已向此用户所绑定邮箱发送验证码，请注意查收"); 
        		}else{
        		this.$Message.error('用户名不存在或不可用'); 
        	}
        })
		.catch((error)=>{
			console.log(error);
			this.$Message.error('用户名不存在或不可用,错误代码:'+error.response.status); 
		});
        },
        sendEmail(){
        	if(this.username=='')
			{this.$Message.error('用户名不能为空');}
			else{
				this.disabled1=true;
				this.context="已发送验证码"
				this.axiosSendEmail();
			}
        },
        submitChange(){
			if(this.username=='')
			{this.$Message.error('用户名不能为空');}
			else if(this.newpassword=='')
			{this.$Message.error('新密码不能为空');}
			else if(this.validatecode=='' || this.validatecode==null)
			{this.$Message.error('验证码不能为空');}
			else if(this.newpassword2!=this.newpassword)
			{this.$Message.error('两次输入密码不一致');}
			else if(this.newpassword.length<6 || this.newpassword.length>20)
            {this.$Message.error('密码长度应为6-20位');}
			else{
				this.axiosFindPassword();
			}
        },
        }
    }
</script>

<style scoped>
.container{
    margin:20px 0px;
    border: 1px solid rgba(0, 0, 0,0.2);
    border-radius:6px;
    padding:5px 25px 0px 25px;
}
</style>
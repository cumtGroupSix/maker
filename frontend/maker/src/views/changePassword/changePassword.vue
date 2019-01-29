<template>
    <div>
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px">
    <Col span="6" align="left">
    	<span style="font-size:25px"><b>修改密码</b></span>
	</Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="6">
		<FormItem>
    		<Input type="text" name="username" v-model="username" placeholder="用户名" clearable style="width: 300px" ><Icon type="ios-person" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="6">
		<FormItem>
    		<Input type="password" name="oldpassword" v-model="oldpassword" placeholder="原密码" clearable style="width: 300px" ><Icon type="ios-lock" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="6">
		<FormItem>
    		<Input :type="newpass" name="newpassword" v-model="newpassword" placeholder="新密码" style="width: 300px"><Icon type="ios-lock-outline" slot="prefix"/><Icon v-if="isEyeOff" @click="changeEye" style="cursor:pointer" type="md-eye" slot="suffix" /><Icon v-if="!isEyeOff" type="md-eye-off" slot="suffix" @click="changeEye" style="cursor:pointer" /></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="6">
		<FormItem>
    		<Input :type="newpass" name="newpassword2" v-model="newpassword2" placeholder="确认新密码" style="width: 300px" ><Icon type="ios-lock" slot="prefix"/><Icon v-if="isEyeOff" @click="changeEye" style="cursor:pointer" type="md-eye" slot="suffix" /><Icon v-if="!isEyeOff" type="md-eye-off" slot="suffix" @click="changeEye" style="cursor:pointer" /></Input>
    	</FormItem>	
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="4">
    	<FormItem>
	    	<Input name="validateCode" v-model="validatecode" placeholder="请输入验证码" clearable style="width: 165px" ><Icon type="ios-keypad" slot="prefix" /></Input>
	    </FormItem>
    	</Col>
    	<Col span="2">
    	<FormItem align="right">
    	<img :src="this.$store.state.validateImg" @click="changeimg" style="cursor: pointer;"/>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >	
    	<Col span="6">
		<FormItem>
    	<Button type="primary" long @click="submitChange">确认修改</Button>
		</FormItem>	
    	</Col>
    	</Row> 	
    </Form> 
    </div>
</template>

<script>
    export default {
        data(){
        	return{
        	isEyeOff:true,
        	newpass:"password",
    		username:"",
    		oldpassword:"",
    		newpassword:"",
    		newpassword2:"",
    		validatecode:null,
    		res:null
        	}
        },
        mounted(){
        },
        methods:{
        axiosResetPassword(){
        	this.axios.post("/api/user/resetPassword?username="+this.username+"&oldPassword="+this.oldpassword+"&newPassword="+this.newpassword+"&imageCode="+this.validatecode)
        	.then((response)=>{if(response.data==1){
        		this.$Message.success('修改密码成功');
        		this.$router.push({path: '/'});
        	}else{
        		if(response.data=="坏的凭证"){
				this.$Message.error('用户名或原密码错误');	
				}else{
				this.$Message.error(response.data);	
				}
        	}
        })
			.catch((error)=>{console.log(error);});
        },
        submitChange(){
			if(this.username=='')
			{this.$Message.error('用户名不能为空');}
			else if(this.oldpassword=='')
			{this.$Message.error('原密码不能为空');}
			else if(this.newpassword=='')
			{this.$Message.error('新密码不能为空');}
			else if(this.newpassword2=='')
			{this.$Message.error('确认新密码不能为空');}
			else if(this.validatecode=='' || this.validatecode==null)
			{this.$Message.error('验证码不能为空');}
			else if(this.oldpassword==this.newpassword)
			{this.$Message.error('新密码与旧密码不可以相同');}
			else if(this.newpassword2!=this.newpassword)
			{this.$Message.error('两次输入密码不一致');}
			else{
				this.axiosResetPassword();
			}
        },
        // 刷新验证码
      	changeimg(){
      		this.$store.state.validateImg="/api/code/image?d="+Math.random();
      	},
      	changeEye(){
      		this.isEyeOff=!this.isEyeOff;
      		if(this.newpass=="password"){
      			this.newpass="text"
      		}else{
      			this.newpass="password"
      		}
      	}
        }
    }
</script>

<style scoped>

</style>
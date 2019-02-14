<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="10" :md="9" :lg="9" class="container">
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>创客注册</b></span>
	</Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" style="margin-bottom:5px;font-size:15px">
    	<Col span="24" align="left">
    	<div><b>设置用户名及密码</b></div>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" :maxlength="15" placeholder="请输入用户名" clearable  ><Icon type="md-person" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input :type="pass" name="password" v-model="password" placeholder="请输入密码" :maxlength="20"  ><Icon type="md-lock" slot="prefix"/><Icon v-if="isEyeOff" @click="changeEye" style="cursor:pointer" type="md-eye" slot="suffix" /><Icon v-if="!isEyeOff" type="md-eye-off" slot="suffix" @click="changeEye" style="cursor:pointer" /></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input :type="pass" name="password2" v-model="password2" placeholder="确认密码"  :maxlength="20"><Icon type="md-lock" slot="prefix"/><Icon v-if="isEyeOff" @click="changeEye" style="cursor:pointer" type="md-eye" slot="suffix" /><Icon v-if="!isEyeOff" type="md-eye-off" slot="suffix" @click="changeEye" style="cursor:pointer" /></Input>
    	</FormItem>	
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" style="margin-bottom:5px;font-size:15px">
    	<Col span="24" align="left">
    	<div><b>设置注册信息</b></div>
    	</Col>
    	</Row>
		<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="neckname" v-model="storename" placeholder="请输入店铺名" clearable :maxlength="20" ><Icon type="md-pricetag" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="mobilenumber" v-model="mobilenumber" placeholder="请输入手机号码" clearable  @input="inputnumber" :maxlength="20"><Icon type="ios-call" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="email" v-model="email" placeholder="请输入电子邮箱" clearable :maxlength="30"  ><Icon type="md-mail" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="school" v-model="school" placeholder="请输入学校名称" clearable :maxlength="20"  ><Icon type="md-school" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="11">
		<FormItem>
    		<Input type="text" name="address" v-model="realname" placeholder="请输入真实姓名" clearable :maxlength="10" ><Icon type="md-people" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	<Col span="11" offset="2">
		<FormItem>
    		<Input type="text" name="address" v-model="studentid" placeholder="请输入学号" @input="inputnumber" clearable :maxlength="15" ><Icon type="md-send" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
        <Row justify="center" type="flex" > 
        <Col span="24">
        <FormItem>
        <Button type="primary" long @click="submit">确认注册</Button>
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
	        	isEyeOff:true,
	        	pass:"password",
	        	role:"MAKER",
	    		username:"",
	        	password:"",
	    		password2:"",
	    		storename:"",
	    		mobilenumber:"",
	    		email:"",
	    		school:"",
	    		realname:"",
	    		studentid:"",
	    		res:null
        	}
        },
        methods:{
        //用户名密码注册
        axiosMakerRegister(){
        	this.axios.post("/api/admin/userSignUp?role="+this.role+"&username="+this.username+"&password="+this.password)
        	.then((response)=>{if(response.status==200&&response.data==1){
        		this.axiosMakerRegisterInfo();
        	}else if(response.status==200&&response.data&&response.data!="undefined"){
				this.$Message.error(response.data);	
        	}else{
                this.$Message.error("注册失败，用户名已经被使用");   
            }
        	})
			.catch((error)=>{console.log(error);});
        },
        //基本信息注册
        axiosMakerRegisterInfo(){
        	this.axios.post("/api/admin/makerSignUpInfo?username="+this.username+"&storeName="+this.storename+"&mobileNumber="+this.mobilenumber+"&email="+this.email+"&school="+this.school+"&realName="+this.realname+"&studentId="+this.studentid)
        	.then((response)=>{if(response.status==200&&response.data==1){
                localStorage.setItem('makerusername',this.username);
                localStorage.setItem('makerpassword',this.password);
                this.$Modal.success({
                            title:"Maker注册成功",
                            content:"已成功注册Maker账号",
                            onOk: () => {
                            this.$router.go(0); 
                            },
                        });             
        	}else{
				this.$Message.error("注册成功，但店铺信息添加失败");	
        	}
        	})
			.catch((error)=>{console.log(error);});
        },
        changeEye(){
      		this.isEyeOff=!this.isEyeOff;
      		if(this.pass=="password"){
      			this.pass="text"
      		}else{
      			this.pass="password"
      		}
      	},
      	submit(){
      		if(this.username=='')
			{this.$Message.error('用户名不能为空');}
			else if(this.password=='')
			{this.$Message.error('密码不能为空');}
			else if(this.password2=='')
			{this.$Message.error('确认密码不能为空');}
			else if(this.storename=='')
			{this.$Message.error('店铺名不能为空');}
			else if(this.mobilenumber=='')
			{this.$Message.error('手机号码不能为空');}
			else if(this.email=='')
			{this.$Message.error('用户邮箱不能为空');}
            else if(this.school=='')
            {this.$Message.error('学校名称不能为空');}
			else if(this.realname=='')
			{this.$Message.error('真实姓名不能为空');}
			else if(this.studentid=='')
			{this.$Message.error('学生学号不能为空');}
            else if(this.username.length<4 || this.username.length>15)
            {this.$Message.error('用户名长度应为4-15位');}
            else if(this.password.length<6 || this.password.length>20)
            {this.$Message.error('密码长度应为6-20位');}
			else if(this.password2!=this.password)
			{this.$Message.error('两次输入密码不一致');}
			else{
			this.axiosMakerRegister();
			}
      	},
        inputnumber(){
            this.mobilenumber=this.mobilenumber.replace(/\D/g,'');
            this.studentid=this.studentid.replace(/\D/g,'');
        }
       },
        
    }
</script>

<style scoped>
.container{
    margin:20px 0px;
    border: 1px solid rgba(0, 0, 0,0.2);
    border-radius:6px;
    padding:15px 30px 0px 30px;
}
</style>
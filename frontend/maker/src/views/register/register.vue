<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="22" :sm="9" :md="6" :lg="7" class="container">
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>用户注册</b></span>
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
    		<Input type="text" name="neckname" v-model="nickname" placeholder="请输入会员名" clearable :maxlength="20" ><Icon type="md-people" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="telephone" v-model="telephone" placeholder="请输入手机号码" clearable  @input="inputnumber" :maxlength="20"><Icon type="ios-call" slot="prefix"></Icon></Input>
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
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="address" v-model="address" placeholder="请输入收货地址" clearable :maxlength="50" ><Icon type="md-compass" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="12" align="left">
    	<FormItem>
	    	<Input name="validateCode" v-model="validatecode" placeholder="请输入验证码" clearable :maxlength="4"><Icon type="ios-keypad" slot="prefix"  /></Input>
	    </FormItem>
    	</Col>
    	<Col span="12" align="right">
    	<FormItem>
    	<img :src="this.$store.state.validateImg" @click="changeimg" style="cursor: pointer;"/>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >	
    	<Col span="24">
		<FormItem>
    	<Button type="primary" long @click="submit">同意以下协议并注册</Button>
		</FormItem>	
    	</Col>
    	</Row> 
    	<Row justify="center" type="flex" style="margin-bottom:-10px">
    	<Col span="24" align="center">
		<FormItem>
    	<Checkbox v-model:checked.sync="isAccept"><a href="#" data-toggle="tooltip" title="协议内容">《创客交易网服务协议》</a></Checkbox>
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
	        	role:"USER",
	    		username:"",
	        	password:"",
	    		password2:"",
	    		nickname:"",
	    		telephone:"",
	    		email:"",
	    		address:"",
	    		school:"",
	    		isAccept:false,
	    		validatecode:null,
	    		res:null
        	}
        },
        methods:{
        //用户名密码注册
        axiosUserRegister(){
        	this.axios.post("/api/user/userSignUp?role="+this.role+"&username="+this.username+"&password="+this.password+"&imageCode="+this.validatecode)
        	.then((response)=>{if(response.status==200&&response.data==1){
        		this.axiosUserRegisterInfo();
        	}else if(response.status==200&&response.data&&response.data!="undefined"){
				this.$Message.error(response.data);	
        	}else{
                this.$Message.error("注册失败，用户名已经被使用");   
            }
        	})
			.catch((error)=>{console.log(error);});
        },
        //基本信息注册
        axiosUserRegisterInfo(){
        	this.axios.post("/api/user/userSignUpInfo?username="+this.username+"&nickname="+this.nickname+"&enable=1&telephone="+this.telephone+"&email="+this.email+"&address="+this.address+"&school="+this.school)
        	.then((response)=>{if(response.status==200&&response.data==1){
                localStorage.setItem('username',this.username);
                localStorage.setItem('password',this.password);
                this.$Message.success('注册成功，请登录');
                this.$router.push({path: '/'});                
        	}else{
				this.$Message.error("注册成功，但用户信息添加失败");	
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
        // 刷新验证码
      	changeimg(){
      		this.$store.state.validateImg="/api/code/image?d="+Math.random();
      	},
      	submit(){
      		if(this.username=='')
			{this.$Message.error('用户名不能为空');}
			else if(this.password=='')
			{this.$Message.error('密码不能为空');}
			else if(this.password2=='')
			{this.$Message.error('确认密码不能为空');}
			else if(this.neckname=='')
			{this.$Message.error('会员名不能为空');}
			else if(this.telephone=='')
			{this.$Message.error('手机号码不能为空');}
			else if(this.email=='')
			{this.$Message.error('用户邮箱不能为空');}
            else if(this.school=='')
            {this.$Message.error('学校名称不能为空');}
            else if(this.address=='')
            {this.$Message.error('收货地址不能为空');}
			else if(this.isAccept==false)
			{this.$Message.error('请确认同意服务协议');}
            else if(this.username.length<4 || this.username.length>15)
            {this.$Message.error('用户名长度应为4-15位');}
            else if(this.password.length<6 || this.password.length>20)
            {this.$Message.error('密码长度应为6-20位');}
			else if(this.validatecode=='' || this.validatecode==null)
			{this.$Message.error('验证码不能为空');}
			else if(this.password2!=this.password)
			{this.$Message.error('两次输入密码不一致');}
			else{
			this.axiosUserRegister();
			}
      	},
        inputnumber(){
            this.telephone=this.telephone.replace(/\D/g,'');
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
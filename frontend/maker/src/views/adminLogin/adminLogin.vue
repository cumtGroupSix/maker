<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="9" :md="6" :lg="6" class="container">
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px" v-if="!access">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>管理员登录</b></span>
	</Col>
    </Row>
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px" v-if="access">
    <Col span="24" align="left">
        <span style="font-size:25px"><b>管理员中心</b></span>
    </Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" :maxlength="15" placeholder="请输入管理员账号" clearable  ><Icon type="md-person" slot="prefix"></Icon></Input>
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
    	<Col span="12" align="left">
    	<FormItem>
	    	<Input name="validateCode" v-model="validatecode" placeholder="请输入验证码" clearable :maxlength="4"><Icon type="ios-keypad" slot="prefix" /></Input>
	    </FormItem>
    	</Col>
    	<Col span="12" align="right">
    	<FormItem>
    	<img :src="this.$store.state.validateImg" @click="changeimg" style="cursor: pointer;"/>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" style="margin-top:-10px" v-if="!access">	
    	<Col span="24">
		<FormItem>
    	<Button type="primary" long @click="submit">确认登录</Button>
		</FormItem>	
    	</Col>
    	</Row>
        <Row justify="center" type="flex" style="margin-top:-10px" v-if="access"> 
        <Col span="24">
        <FormItem>
        <Button type="primary" long @click="submit">切换登录</Button>
        </FormItem> 
        </Col>
        </Row> 
        <Row justify="center" type="flex" style="margin-top:-15px" v-if="access"> 
        <Col span="24">
        <FormItem>
        <Button type="success" long @click="enter">进入管理员界面</Button>
        </FormItem> 
        </Col>
        </Row>
        <Row justify="center" type="flex" style="margin-top:-15px" v-if="access"> 
        <Col span="24">
        <FormItem>
        <Button type="error" long @click="exit">退出当前登录</Button>
        </FormItem> 
        </Col>
        </Row>
        <Row justify="center" type="flex" style="margin-top:-15px">
        <Col span="12" offset="12" align="right">
        <FormItem>
        <router-link to="/changepassword" style="cursor: pointer;color:#72ACE3">修改密码</router-link>
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
	    		username:"",
	        	password:"",
	    		validatecode:null,
	    		res:null,
                access:false,
                admintoken:null
        	}
        },
        mounted(){
            this.tokenlogin()
            this.doBefore()             
        },
        methods:{
        //根据Token请求数据
        tokenlogin(){
                if (localStorage.getItem('admintoken')&&localStorage.getItem('admintoken')!="undefined"){
                    this.axios.get('/api/user/get')
                    .then((response)=>{this.$store.state.adminloginresponse=response})
                    .catch((error)=>{console.log(error);});
                }
            },
        //发送登录请求
        axioslogin(){
            this.axios.post('/loginapi?username='+this.username+'&password='+this.password+"&imageCode="+this.validatecode)
                .then((response)=>{this.$store.state.adminloginresponse=response})
                .catch((error)=>{console.log(error);});
         },
        //取出记住的用户名
        doBefore(){
            this.admintoken=localStorage.getItem('admintoken');
            if(localStorage.getItem('adminusername') && localStorage.getItem('adminusername')!="undefined"){
                this.username=localStorage.getItem('adminusername');
            }
        },
        //切换密码可视
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
			else if(this.validatecode=='' || this.validatecode==null)
			{this.$Message.error('验证码不能为空');}
			else{
            localStorage.removeItem('token');
            localStorage.removeItem('tokenTime');
            localStorage.removeItem('makertoken');
            localStorage.removeItem('makertokenTime');
            this.$store.state.loginresponse=null;
            localStorage.setItem('adminusername',this.username);
            this.axioslogin();
			}
      	},
        exit(){
            this.admintoken=null;
            this.access=false;
            localStorage.removeItem('admintoken');
            localStorage.removeItem('admintokenTime');
            console.log(this.admintoken)
            this.$router.push({path: '/'});
            this.$router.go(0)
        },
        enter(){
            this.$router.push({path:"/adminmanager"});
        }

       },
       computed:{
            adminloginresponse(){
                return this.$store.state.adminloginresponse;
            }
        },
        watch:{
            adminloginresponse:function(news,olds){
                this.$store.state.userid=null;
                this.$store.state.username=null;
                if(news.data&&news.data!="undefined"){
                if(news.status==200 && news.data.role=="ADMIN"){
                this.access=true;
                this.validatecode=null;
                this.$store.state.userid=news.data.userId;
                this.$store.state.username=news.data.username;
                this.username=news.data.username;
                //只有用户名密码登录时弹出登录成功
                if (!localStorage.getItem('admintoken') || localStorage.getItem('admintoken')=="undefined"){
                    this.$Message.success('登录成功');
                    }
                //存储Jwt Token
                if(news.headers.authorization&&news.headers.authorization!="undefined"){
                    localStorage.setItem('admintoken', JSON.stringify(news.headers.authorization));
                    localStorage.setItem('admintokenTime', Date.now());
                    this.admintoken=localStorage.getItem('admintoken');
                    }
                    this.$router.push({path: '/adminmanager'});
                }           
                else{
                if(news.data=="坏的凭证"){
                this.$Message.error('登录失败，用户名或密码错误');   
                }else if(typeof news.data=="object"){
                this.$Message.error("用户无此登录权限");    
                }else{
                this.$Message.error(news.data);     
                }     
                }
                }else{
                this.$Message.error("此用户不存在");   
                }
            },
            admintoken:function(news,olds){
                if(news&&news!="undefined"&&olds&&olds!="undefined"){
                 this.$Message.success('切换登录成功');   
                }
            }
        }
        
    }
</script>

<style scoped>
.container{
    margin:20px 0px;
    border: 1px solid rgba(0, 0, 0,0.2);
    border-radius:6px;
    padding:5px 24px 0px 24px;
}
</style>
<template>
    <div>
        <header>
            <div class="logo d-none d-md-block">
            <img src="@/assets/img/header.jpg" alt="" class="w-100">
            </div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light" style="border: 4px solid #ff9966;border-radius: 5px">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-index" aria-controls="navbar-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <form class="form-inline my-1">
                <div class="btn-group">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <a href="#" class="btn my-1 my-sm-0 text-white" style="background-color: #ff9966">Search</a>
                </div>
            </form>
            <div class="collapse navbar-collapse justify-content-end" id="navbar-index">
                <ul class="navbar-nav">
                    <li class="nav-item mx-3">
                    <router-link class="nav-link" to="/">首页</router-link>
                </li>
                <li class="nav-item mx-3" v-if="!this.hasLogged">
                    <a class="nav-link" @click="loginDialogShow" style="cursor: pointer;">登录</a>
                </li>
                <li class="nav-item mx-3" v-if="this.hasLogged">
                    <a class="nav-link" style="cursor: pointer;">尊敬的{{this.$store.state.username}},您好!</a>
                </li>
                <li class="nav-item mx-3" v-if="this.hasLogged">
                    <a class="nav-link" style="cursor: pointer;" @click="exit">退出</a>
                </li>
                <li class="nav-item mx-3">
                    <a class="nav-link" href="/register">注册</a>
                </li>
                <li class="nav-item mx-3">
                    <router-link to='/cart' class="nav-link" style='cursor: pointer;'>购物车</router-link>
                </li>
                <li class="nav-item mx-3">
                    <span @click="toAnotherPath('/makerlogin')" class="nav-link" style='cursor: pointer;'>创客中心</span>
                </li>
                </ul>
            </div>	
            </nav>
        </header>
        <div class="login" v-if="isLoginDialog">
			<div class="login-box">
				<button type="button" class="close m-2" aria-label="Close" @click="loginDialogHide">
				  <span aria-hidden="true">&times;</span>
				</button>
				<div class="login-title px-4 py-3">密码登录</div>
				<Form>
				  <div class="form-group row px-4 py-0">
					<label for="username" class="col-2 col-form-label py-0 my-0"><Icon type="md-person" size="36"/></label>
					<div class="col-10">
					  <input type="text" class="form-control justify-content-center" id="username" placeholder="会员名/邮箱号/手机号" v-model="username">
					</div>
				  </div>
				  <div class="form-group row px-4 py-2">
					<label for="password" class="col-2 col-form-label py-0 my-0"><Icon type="ios-keypad" size="36"/></label>
					<div class="col-10">
					  <input type="password" class="form-control" id="password" placeholder="密码" v-model="password">
					</div>
				  </div>
				  <Row type="flex" style="margin-top:0px">
					<Col span="10" offset="2">
					<FormItem>
					<Row>
					<Col span="4">
					<Icon type="ios-paper-plane" size="20"/>
					</Col>
					<Col span="16" offset="4">
					<Input name="validateCode" v-model="validatecode" placeholder="请输入验证码" clearable style="width: 120px" />
					</Col>
					</Row>
					</FormItem>
					</Col>
					<Col span="10">
					<FormItem align="right">
					<img :src="this.$store.state.validateImg" @click="changeimg" style="cursor: pointer;"/>
					</FormItem>
					</Col>
				  </Row>
				  <div class="form-group row px-4 py-0" style="margin-top:-10px">
					<div class="col-6">
						<Checkbox value="rememberpass" v-model:checked.sync="isRemember">
						<span style="color:#72ACE3;cursor:pointer">记住密码</span>
						</Checkbox>
					</div>
					<div class="col-6" style="text-align:right" >
						<span style="cursor: pointer;color:#72ACE3" @click="toAnotherPath('/changepassword')">修改密码</span>
					</div>
				  </div>
				  <div class="form-group row px-4" style="margin-top:-10px">
					<div class="col-12">
					  <button type="button" class="btn btn-primary w-100" @click="login">登录</button>
					</div>
				  </div>
				 <Row>
				 <Col span="10" offset="2">
				 <span @click="toAnotherPath('/findpassword')" style="cursor: pointer;color:#72ACE3">忘记密码</span>
					</Col>
				 <Col span="10" align="right">
				 <span @click="toAnotherPath('/register')" style="cursor: pointer;color:#72ACE3">免费注册</span>
				 </Col> 
				</Row>
				</Form>
			</div>
		</div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
            	loginFailed:false,
            	isRemember:false,
                username:"",
                password:"",
                users:"",
                hasLogged:false,
                isLoginDialog:false,
                validatecode:null
            }
        },
        mounted(){
        	this.tokenlogin()
        	this.doBefore() 	     	
        },
        methods: {
        	//根据Token请求数据
        	tokenlogin(){
        		if (localStorage.getItem('token')&&localStorage.getItem('token')!="undefined"){
					this.axios.get('/api/user/get')
					.then((response)=>{this.$store.state.loginresponse=response})
					.catch((error)=>{console.log(error);});
        		}
        		else{
        	// 只在主页自动弹出登录窗口
        			if(this.$router.currentRoute.fullPath=="/"){
        			this.isLoginDialog=true;	
        			}	
        		}
        	},
        	//发送登录请求
        	axioslogin(){
				this.axios.post('/loginapi?username='+this.username+'&password='+this.password+"&imageCode="+this.validatecode)
					.then((response)=>{this.$store.state.loginresponse=response})
					.catch((error)=>{console.log(error);});
        	},
        	//登录按钮click事件
        	login(){
				if(this.username=='')
				{this.$Message.error('用户名不能为空');}
				else if(this.password=='')
				{this.$Message.error('密码不能为空');}
				else if(this.validatecode=='' || this.validatecode==null)
				{this.$Message.error('验证码不能为空');}
				else{
				localStorage.removeItem('makertoken');
            	localStorage.removeItem('makertokenTime');
            	localStorage.removeItem('admintoken');
            	localStorage.removeItem('admintokenTime');
            	this.$store.state.makerloginresponse=null;	
				localStorage.setItem('username',this.username);
				this.axioslogin();
				}
        		
        	},
        	// 刷新验证码
        	changeimg(){
      		this.$store.state.validateImg="/api/code/image?d="+Math.random();
      		},
      		//取出记住的用户名和密码
        	doBefore(){
        		if(localStorage.getItem('username') && localStorage.getItem('username')!="undefined"){
        			this.username=localStorage.getItem('username');
        		}
        		if(localStorage.getItem('password') && localStorage.getItem('password')!="undefined"){
        			this.isRemember=true;
        			this.password=localStorage.getItem('password');
        		}
        	},
        	toAnotherPath(to){
        		this.isLoginDialog=false;
        		this.$router.push({path: to});
        	},
        	//记住密码
        	rememberPassword(){
        		if(this.isRemember==true){
        			localStorage.setItem('password',this.password);
        			this.password=localStorage.getItem('password');
        		}else {
        			localStorage.removeItem('password');
        			this.password="";
        		}
        	},
            loginDialogShow(){
                this.isLoginDialog=true;
            },
            loginDialogHide(){
                this.isLoginDialog=false;
            },
            exit(){
	            this.hasLogged=false
	            localStorage.removeItem('token');
				localStorage.removeItem('tokenTime');
				this.$router.push({path: '/'});
				this.$router.go(0);
            }
        },
        computed: {
			loginresponse(){
				return this.$store.state.loginresponse;
			}
		},
		watch:{
			loginresponse:function(news,olds){
				this.$store.state.userid=null;
				this.$store.state.username=null;
				if(news.data&&news.data!="undefined"){
				if(news.status==200 && news.data.role=="USER"){
				this.validatecode=null;
				this.$store.state.userid=news.data.userId;
				this.$store.state.username=news.data.username;
				this.username=news.data.username;
				this.rememberPassword();
				//只有用户名密码登录时弹出登录成功
					if (!localStorage.getItem('token') || localStorage.getItem('token')=="undefined"){
						this.$Message.success('登录成功');
					}
				//存储Jwt Token
					if(news.headers.authorization&&news.headers.authorization!="undefined"){
					localStorage.setItem('token', JSON.stringify(news.headers.authorization));
					localStorage.setItem('tokenTime', Date.now());	
					}
				}			
				else{
					localStorage.removeItem('password');
					if(news.data=="坏的凭证"){
					this.$Message.error('登录失败，用户名或密码错误');	
					}else if(typeof news.data=="object"){
					this.$Message.error("用户无此登录权限");	
					}else{
					this.$Message.error(news.data);		
					}	
				}
				}else{
				this.hasLogged=false;
                this.$Message.error("此用户不存在");   
                }
				if(this.$store.state.username!=null){
               	 	this.hasLogged=true;
                	this.isLoginDialog=false;
            	};
			}
		}
    }
</script>

<style scoped>
.ivu-icon:before,
.ivu-icon:after {
    font-family: Ionicons !important;
}
.logo-wraper{
	display: flex;
	justify-content: center;
	align-items: center;
}
.logo-main{
	margin: 0 50px;
	font-family: '华文行楷';
	font-size: 30px
}
.store-name{
	font-size: 20px;
	font-weight:900;
	font-family: '微软雅黑';
}
.login{
	border-radius:8px;
	width: 330px;
	height: 360px;
	background-color: #fff;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
    border: 1px solid rgba(0, 0, 0,0.2);
    z-index: 1000;
}
.login-box{
	position: relative;
}
.login-close{
	position: absolute;
	top: 0;
	right: 0;
	font-size: 25px;
	line-height: 25px;
	cursor: pointer;
}
.login-title{
	font-size: 25px;
	font-family: '微软雅黑';
}
.usernameIcon{
	background-color: #DDDDDD;
	color: white;
	width: 36px;
	height: 36px;
}
.usernameIcon i{
	font-size: 25px;
	line-height: 36px;
}
.passwordIcon{
	background-color: #DDDDDD;
	color: white;
	width: 36px;
	height: 36px;
}
.passwordIcon i{
	font-size: 27px;
	line-height: 36px;
}
.flex{
	display: flex;
	justify-content: center;
}
.order-details-title{
	font-size: 38px;
	font-family: "黑体";
	font-weight: bold;
	color: #ff6600;
}
.logistics-information-title{
	font-size: 20px;
	font-family: "黑体";
	font-weight: bold;
}
.bold{
	font-size: 14px;
	font-family: "黑体";
	font-weight: bold;
}
.order-detail-title{
	font-size: 16px;
	font-family: "微软雅黑";
	font-weight: bold;
	background-color: #e0ebff;
	color: #3C763D;
	width: 100px;
}
.bold-24{
	font-size: 24px;
	font-family: "黑体";
	font-weight: bold;
}
.font-10{
	font-size: 10px;
	font-family: '微软雅黑';
}
.font-12{
	font-size: 12px;
	color: #9a9a9a;
	font-family: '微软雅黑';
}
.ellipsis{
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
.addProduct{
	background-color:#ff9966;
	position:fixed;
	left:50%;
	top:50%;
	transform:translate(-50%,-50%);
	z-index:1000;
	min-width: 300px;
}
</style>
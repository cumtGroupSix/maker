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
                    <a class="nav-link" href="#">创客中心</a>
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
				<div class="login-title px-4 py-4">密码登录</div>
				<form>
				  <div class="form-group row px-4 py-0">
					<label for="username" class="col-2 col-form-label py-0 my-0"><div class="usernameIcon"><i class="iconfont ml-1">&#xe683;</i></div></label>
					<div class="col-10">
					  <input type="text" class="form-control justify-content-center" id="username" placeholder="会员名/邮箱号/手机号" v-model="myUsername">
					</div>
				  </div>
				  <div class="form-group row px-4 py-2">
					<label for="password" class="col-2 col-form-label py-0 my-0"><div class="passwordIcon"><i class="iconfont ml-1">&#xe620;</i></div></label>
					<div class="col-10">
					  <input type="password" class="form-control" id="password" placeholder="密码" v-model="myPassword">
					</div>
				  </div>
				  <div class="form-group row px-4">
					<div class="col-12">
					  <button type="button" class="btn btn-primary w-100" @click="login">登录</button>
					</div>
				  </div>
				</form>
				<div class="forget px-4 py-2 float-left"><a href="#">忘记密码</a></div>
				<div class="registe px-4 py-2 float-right"><a href="#">免费注册</a></div>
			</div>
		</div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                myUsername:"",
                myPassword:"",
                users:"",
                hasLogged:false,
                isLoginDialog:false
            }
        },
        mounted(){
        	this.tokenlogin()
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
        			this.isLoginDialog=true;
        		}
        	},
        	//发送登录请求
        	login(){
        		this.axios.post('/loginapi?username='+this.myUsername+'&password='+this.myPassword)
				.then((response)=>{this.$store.state.loginresponse=response})
				.catch((error)=>{console.log(error);});
        	},
            loginDialogShow(){
                this.isLoginDialog=true;
            },
            loginDialogHide(){
                this.isLoginDialog=false;
            },
            exit(){
	            this.hasLogged=false
	            this.myUsername=""
	            this.myPassword=""
	            localStorage.removeItem('token');
				localStorage.removeItem('tokenTime');
            }
        },
        computed: {
			loginresponse(){
				return this.$store.state.loginresponse;
			}
		},
		watch:{
			loginresponse:function(news,olds){
				if(news.headers.authorization && news.headers.authorization !="undefined"){
					localStorage.setItem('token', JSON.stringify(news.headers.authorization));
				}
				if(localStorage.getItem('token') && localStorage.getItem('token')!="undefined"){
					localStorage.setItem('tokenTime', Date.now());
				}
				this.$store.state.userid=null;
				this.$store.state.username=null;
				if(news.status==200 && typeof news.data=="object"){
				this.$store.state.userid=news.data.userId;
				this.$store.state.username=news.data.username;
				}			
				else{
				alert("登录失败,用户名或密码错误！");
				};
				if(this.$store.state.username!=null){
               	 	this.hasLogged=true;
                	this.isLoginDialog=false;
            	}
			}
		}
    }
</script>

<style scoped>
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
	width: 350px;
	height: 320px;
	background-color: #fff;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
    border: 1px solid black;
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
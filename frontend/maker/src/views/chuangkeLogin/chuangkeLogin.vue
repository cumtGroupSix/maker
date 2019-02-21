<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="9" :md="6" :lg="6" class="container">
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px" v-if="!access">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>创客登录</b></span>
	</Col>
    </Row>
    <Row justify="center" type="flex" style="margin-bottom:10px;margin-top:10px" v-if="access">
    <Col span="24" align="left">
        <span style="font-size:25px"><b>创客中心</b></span>
    </Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" :maxlength="15" placeholder="请输入创客用户名" clearable  ><Icon type="md-person" slot="prefix"></Icon></Input>
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
        <Row justify="center" type="flex" style="margin-top:-15px">
        <Col span="12" align="left">
        <FormItem>
            <Checkbox value="rememberpass" v-model:checked.sync="isRemember">
            <span style="color:#72ACE3;cursor:pointer">记住密码</span>
            </Checkbox>
        </FormItem>
        </Col>
        <Col span="12" align="right">
        <FormItem>
        <router-link to="/changepassword" style="cursor: pointer;color:#72ACE3">修改密码</router-link>
        </FormItem>
        </Col>
        </Row>
    	<Row justify="center" type="flex" style="margin-top:-25px" v-if="!access">	
    	<Col span="24">
		<FormItem>
    	<Button type="primary" long @click="submit">确认登录</Button>
		</FormItem>	
    	</Col>
    	</Row>
        <Row justify="center" type="flex" style="margin-top:-25px" v-if="access"> 
        <Col span="24">
        <FormItem>
        <Button type="primary" long @click="submit">切换登录</Button>
        </FormItem> 
        </Col>
        </Row> 
        <Row justify="center" type="flex" style="margin-top:-15px" v-if="access"> 
        <Col span="24">
        <FormItem>
        <Button type="success" long @click="enter">进入管理界面</Button>
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
        <Row justify="center" type="flex" style="margin-top:-15px;margin-bottom:-15px">
        <Col span="12" align="left">
        <FormItem>
            <span style="color:#72ACE3;cursor:pointer">忘记密码</span>
        </FormItem>
        </Col>
        <Col span="12" align="right">
        <FormItem>
        <router-link to="/makerregister" style="cursor: pointer;color:#72ACE3">免费注册</router-link>
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
                isRemember:false,
	        	pass:"password",
	    		username:"",
	        	password:"",
	    		validatecode:null,
	    		res:null,
                access:false,
                makertoken:null
        	}
        },
        mounted(){
            this.tokenlogin()
            this.doBefore()             
        },
        methods:{
        //根据Token请求数据
        tokenlogin(){
                if (localStorage.getItem('makertoken')&&localStorage.getItem('makertoken')!="undefined"){
                    this.axios.get('/api/user/get')
                    .then((response)=>{this.$store.state.makerloginresponse=response})
                    .catch((error)=>{console.log(error);});
                }
            },
        //发送登录请求
        axioslogin(){
            this.axios.post('/loginapi?username='+this.username+'&password='+this.password+"&imageCode="+this.validatecode)
                .then((response)=>{this.$store.state.makerloginresponse=response})
                .catch((error)=>{console.log(error);});
         },
        //取出记住的用户名和密码
        doBefore(){
            this.makertoken=localStorage.getItem('makertoken');
            if(localStorage.getItem('makerusername') && localStorage.getItem('makerusername')!="undefined"){
                this.username=localStorage.getItem('makerusername');
            }
            if(localStorage.getItem('makerpassword') && localStorage.getItem('makerpassword')!="undefined"){
                this.isRemember=true;
                this.password=localStorage.getItem('makerpassword');
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
        //记住密码
        rememberPassword(){
            if(this.isRemember==true){
                localStorage.setItem('makerpassword',this.password);
                this.password=localStorage.getItem('makerpassword');
            }else {
                localStorage.removeItem('makerpassword');
                this.password="";
            }
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
            localStorage.removeItem('admintoken');
            localStorage.removeItem('admintokenTime');
            this.$store.state.loginresponse=null;
            localStorage.setItem('makerusername',this.username);
            this.axioslogin();
			}
      	},
        exit(){
            this.makertoken=null;
            this.access=false;
            localStorage.removeItem('makertoken');
            localStorage.removeItem('makertokenTime');
            this.$router.push({path: '/'});
            this.$router.go(0)
        },
        enter(){
            this.$router.push({path:"/chuangkeAdministration"});
        }

       },
       computed:{
            makerloginresponse(){
                return this.$store.state.makerloginresponse;
            }
        },
        watch:{
            makerloginresponse:function(news,olds){
                this.$store.state.userid=null;
                this.$store.state.username=null;
                if(news.data&&news.data!="undefined"){
                if(news.status==200 && news.data.role=="MAKER"){
                this.access=true;
                this.validatecode=null;
                this.$store.state.userid=news.data.userId;
                this.$store.state.username=news.data.username;
                this.username=news.data.username;
                this.rememberPassword();
                //只有用户名密码登录时弹出登录成功
                if (!localStorage.getItem('makertoken') || localStorage.getItem('makertoken')=="undefined"){
                    this.$Message.success('登录成功');
                    }
                //存储Jwt Token
                if(news.headers.authorization&&news.headers.authorization!="undefined"){
                    localStorage.setItem('makertoken', JSON.stringify(news.headers.authorization));
                    localStorage.setItem('makertokenTime', Date.now());
                    this.makertoken=localStorage.getItem('makertoken');
                    }
                    this.$router.push({path: '/chuangkeAdministration'});
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
                this.$Message.error("此用户不存在");   
                }
            },
            makertoken:function(news,olds){
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
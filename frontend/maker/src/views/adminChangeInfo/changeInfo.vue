<template>
    <div>
    <Row justify="center" type="flex" :class="mainRow">
    <Col :xs="21" :sm="10" :md="9" :lg="9" class="container">
    	<Row justify="center" type="flex" style="margin-bottom:10px;font-size:15px">
    	<Col span="24" align="left">
    	<div><b>用户信息查询及修改</b></div>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" style="margin-bottom:15px;">
    	<Col span="24">
    		<Input type="text" name="username" v-model="username" :maxlength="15" placeholder="请输入要查询的用户名"  autofocus clearable><Icon type="md-person" slot="prefix"></Icon></Input>
    	</Col>
    	</Row>
        <Row justify="center" type="flex" style="margin-bottom:20px;margin-top:0px;"> 
        <Col span="24">
        <Button type="primary" long @click="searchUser">查询</Button>
        </Col>
        </Row> 
    <Form v-if="isUser" :label-width="65">
    	<Row justify="center" type="flex" style="margin-bottom:5px;font-size:15px">
    	<Col span="12" align="left">
    	<div><b>User用户信息:</b></div>
    	</Col>
        <Col span="12" align="right">
        <div><Icon v-if="lock" @click="isLock" style="cursor:pointer" type="md-lock"/><Icon v-if="!lock" @click="isLock" style="cursor:pointer" type="md-unlock" /></div>
        </Col>
    	</Row>
		<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem label="会员名:">
    		<Input :readonly="disabled" type="text" name="neckname" v-model="nickname" placeholder="会员名" :maxlength="20" ><Icon type="md-people" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="Enable:">
            <Input :readonly="disabled" type="text" name="enable" v-model="enable" placeholder="Enable" :maxlength="1"  ><Icon type="md-attach" slot="prefix"></Icon></Input>
        </FormItem>
        </Col>
        </Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem label="手机号码:">
    		<Input :readonly="disabled" type="text" name="telephone" v-model="telephone" placeholder="手机号码"  @input="inputnumber" :maxlength="20"><Icon type="ios-call" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem label="电子邮箱:">
    		<Input :readonly="disabled" type="text" name="email" v-model="email" placeholder="电子邮箱" :maxlength="30"  ><Icon type="md-mail" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem label="学校名称:">
    		<Input :readonly="disabled" type="text" name="school" v-model="school" placeholder="学校名称" :maxlength="20"  ><Icon type="md-school" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem label="收货地址:">
    		<Input :readonly="disabled" type="text" name="address" v-model="address" placeholder="收货地址" :maxlength="50" ><Icon type="md-compass" slot="prefix" ></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
        <Row justify="center" type="flex" style="margin-bottom:20px;margin-top:-10px"> 
        <Col span="24">
        <Button :disabled="disabled" type="primary" long @click="userSubmit">确认修改</Button>
        </Col>
        </Row> 
    </Form>
    <Form v-if="isMaker" :label-width="65">
        <Row justify="center" type="flex" style="margin-bottom:5px;font-size:15px">
        <Col span="12" align="left">
        <div><b>Maker用户信息:</b></div>
        </Col>
        <Col span="12" align="right">
        <div><Icon v-if="lock" @click="isLock" style="cursor:pointer" type="md-lock"/><Icon v-if="!lock" @click="isLock" style="cursor:pointer" type="md-unlock" /></div>
        </Col>
        </Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="店铺名:">
            <Input :readonly="disabled" type="text" name="neckname" v-model="storename" placeholder="店铺名" :maxlength="20" ><Icon type="md-pricetag" slot="prefix" ></Icon></Input>
        </FormItem>
        </Col>
        </Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="手机号码:">
            <Input :readonly="disabled" type="text" name="mobilenumber" v-model="mobilenumber" placeholder="手机号码"  @input="inputnumber" :maxlength="20"><Icon type="ios-call" slot="prefix"></Icon></Input>
        </FormItem>
        </Col>
        </Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="电子邮箱:">
            <Input :readonly="disabled" type="text" name="email" v-model="makeremail" placeholder="电子邮箱" :maxlength="30"  ><Icon type="md-mail" slot="prefix"></Icon></Input>
        </FormItem>
        </Col>
        </Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="学校名称:">
            <Input :readonly="disabled" type="text" name="school" v-model="makerschool" placeholder="学校名称" :maxlength="20"  ><Icon type="md-school" slot="prefix"></Icon></Input>
        </FormItem>
        </Col>
        </Row>
        <Row justify="center" type="flex" >
        <Col span="24">
        <FormItem label="真实姓名:">
            <Input :readonly="disabled" type="text" name="address" v-model="realname" placeholder="真实姓名" :maxlength="10" ><Icon type="md-people" slot="prefix" ></Icon></Input>
        </FormItem>
        </Col>
        <Col span="24" >
        <FormItem label="学生学号:">
            <Input :readonly="disabled" type="text" name="address" v-model="studentid" placeholder="学生学号" @input="inputnumber" :maxlength="15" ><Icon type="md-send" slot="prefix" ></Icon></Input>
        </FormItem>
        </Col>
        </Row>
        <Row justify="center" type="flex" style="margin-bottom:20px;margin-top:-10px"> 
        <Col span="24">
        <Button :disabled="disabled" type="primary" long @click="makersubmit">确认修改</Button>
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
                lock:true,
                disabled:true,
                mainRow:"Row1",
                isUser:false,
                isMaker:false,
	    		username:"",
                axiosusername:"",
                enable:null,
	    		nickname:"",
	    		telephone:"",
	    		email:"",
	    		address:"",
	    		school:"",
                storename:"",
                mobilenumber:"",
                makeremail:"",
                makerschool:"",
                realname:"",
                studentid:""
        	}
        },
        methods:{
        //获取查询用户名对应角色
        axiosGetRole(){
        this.axios.get("/api/admin/getByUserName?username="+this.username)
        .then((response)=>{
            if(response.data.role=="USER"){
                this.axiosGetUserinfo();
            }else if(response.data.role=="MAKER"){
                this.axiosGetMakerinfo();            
            }else{
                this.$Message.error('无此查询权限');  
            }
        })
        .catch((error)=>{
            console.log(error);
            this.$Message.error('用户名不存在,错误代码:'+error.response.status);  
        });
        },
        //获取USER详细信息
        axiosGetUserinfo(){
        	this.axios.get("/api/admin/getUserInfoByUserName?username="+this.username)
        	.then((response)=>{
                if(response.status==200){
                this.$store.state.inforesponse=response.data;
                this.setUserInfo(this.$store.state.inforesponse);
                }
            })
			.catch((error)=>{console.log(error);});
        },
        //获取MAKER详细信息
        axiosGetMakerinfo(){
            this.axios.get("/api/admin/getMakerInfoByUserName?username="+this.username)
            .then((response)=>{
                if(response.status==200){
                this.$store.state.inforesponse=response.data;
                this.setMakerInfo(this.$store.state.inforesponse);
                }
            })
            .catch((error)=>{console.log(error);});
        },
        // User信息修改
        axiosUpdateUserinfo(){
            this.axios.post("/api/admin/updateUserInfo?username="+this.axiosusername
                +"&enable="+this.enable
                +"&nickname="+this.nickname
                +"&telephone="+this.telephone
                +"&email="+this.email
                +"&address="+this.address
                +"&school="+this.school)
            .then((response)=>{
                if(response.status==200&&response.data==1){
                this.disabled=true;
                this.lock=true;
                this.$Message.success('User用户信息修改成功');
                this.$router.push({path: '/adminmanager/changeinfo'});           
            }else{
                this.$Message.error("信息修改失败");  
            }
            })
            .catch((error)=>{
                console.log(error);
                this.$Message.error('信息修改失败,错误代码:'+error.response.status); 
            });
        },
        // Maker信息修改
        axiosUpdateMakerinfo(){
            this.axios.post("/api/admin/updateMakerInfo?username="+this.axiosusername
                +"&storeName="+this.storename
                +"&mobileNumber="+this.mobilenumber
                +"&email="+this.makeremail
                +"&school="+this.makerschool
                +"&realName="+this.realname
                +"&studentId="+this.studentid)
            .then((response)=>{
                if(response.status==200&&response.data==1){
                this.disabled=true;
                this.lock=true;
                this.$Message.success('Maker用户信息修改成功');
                this.$router.push({path: '/adminmanager/changeinfo'});           
            }else{
                this.$Message.error("信息修改失败");  
            }
            })
            .catch((error)=>{
                console.log(error);
                this.$Message.error('信息修改失败,错误代码:'+error.response.status); 
            });
        },
        //USER详细信息渲染info
        setUserInfo(info){
            this.doBefore();
            this.isUser=true;
            this.isMaker=false;
            this.enable=(info.enable?1:0);
            this.nickname=info.nickname;
            this.telephone=info.telephone;
            this.email=info.email;
            this.address=info.address;
            this.school=info.school;
        },
        //MAKER详细信息渲染
        setMakerInfo(info){
            this.doBefore();
            this.isUser=false;
            this.isMaker=true;
            this.storename=info.storeName;
            this.mobilenumber=info.mobileNumber;
            this.makeremail=info.email;
            this.makerschool=info.school;
            this.realname=info.realName;
            this.studentid=info.studentId;
        },
        searchUser(){
            if(this.username=='')
            {this.$Message.error('查询用户名不能为空');}
            else{
                this.axiosGetRole();
            }
        },
      	userSubmit(){
      		if(this.username=='')
    		{this.$Message.error('用户名不能为空');}
            else if(this.enable!=0&&this.enable!=1)
            {this.$Message.error('Enable输入格式错误,只能输入0或1;');}
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
    		else{
    		this.axiosUpdateUserinfo();
    		}
      	},
        makersubmit(){
            if(this.username=='')
            {this.$Message.error('用户名不能为空');}
            else if(this.storename=='')
            {this.$Message.error('店铺名不能为空');}
            else if(this.mobilenumber=='')
            {this.$Message.error('手机号码不能为空');}
            else if(this.makeremail=='')
            {this.$Message.error('用户邮箱不能为空');}
            else if(this.makerschool=='')
            {this.$Message.error('学校名称不能为空');}
            else if(this.realname=='')
            {this.$Message.error('真实姓名不能为空');}
            else if(this.studentid=='')
            {this.$Message.error('学生学号不能为空');}
            else{
            this.axiosUpdateMakerinfo();
            }
        },
        doBefore(){
            this.disabled=true;
            this.lock=true;
            this.axiosusername=this.username;
            this.mainRow="Row2";
        },
        isLock(){
            this.lock=!this.lock;
            this.disabled=!this.disabled;
        },
        inputnumber(){
            this.telephone=this.telephone.replace(/\D/g,'');
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
.Row1{
    margin-top:55px;
    margin-bottom:60px;
}
.Row2{
    margin-top:0px;
    margin-bottom:0px;
}
</style>
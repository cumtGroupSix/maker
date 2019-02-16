<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="10" :md="9" :lg="9" class="container">
    <Row justify="center" type="flex" style="margin-bottom:15px;margin-top:15px">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>修改密码</b></span>
	</Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" placeholder="用户名" :maxlength="15" clearable ><Icon type="md-person" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="newpassword" v-model="newpassword" placeholder="新密码" :maxlength="20"><Icon type="md-lock" slot="prefix"/></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" style="margin-bottom:10px">	
    	<Col span="24">
		<FormItem>
    	<Button type="primary" long @click="submitChange">确认修改</Button>
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
    		username:"",
    		oldpassword:"",
    		newpassword:"",
    		res:null
        	}
        },
        methods:{
        axiosResetPassword(){
        	this.axios.post("/api/admin/resetPassword?username="+this.username+"&newPassword="+this.newpassword)
        	.then((response)=>{if(response.data==1){
        		this.$Modal.success({
                            title:"重设密码成功",
                            content:"已成功重设密码",
                            onOk: () => {
                            this.$router.go(0); 
                            },
                        }); 
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
			else if(this.newpassword=='')
			{this.$Message.error('新密码不能为空');}
			else if(this.newpassword.length<6 || this.newpassword.length>20)
            {this.$Message.error('密码长度应为6-20位');}
			else{
				this.axiosResetPassword();
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
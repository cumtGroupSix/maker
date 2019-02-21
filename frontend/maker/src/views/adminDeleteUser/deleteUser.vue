<template>
    <div>
    <Row justify="center" type="flex">
    <Col :xs="21" :sm="10" :md="9" :lg="9" class="container">
    <Row justify="center" type="flex" style="margin-bottom:15px;margin-top:15px">
    <Col span="24" align="left">
    	<span style="font-size:25px"><b>删除用户</b></span>
	</Col>
    </Row>
    <Form>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username" v-model="username" :maxlength="15" placeholder="请输入要删除的用户名" clearable  ><Icon type="md-person" slot="prefix"></Icon></Input>
    	</FormItem>
    	</Col>
    	</Row>
    	<Row justify="center" type="flex" >
    	<Col span="24">
		<FormItem>
    		<Input type="text" name="username2" v-model="username2" placeholder="请确认要删除的用户名" :maxlength="20"  ><Icon type="md-person" slot="prefix"/></Input>
    	</FormItem>
    	</Col>
    	</Row>
        <Row justify="center" type="flex" style="margin-bottom:10px">  
        <Col span="24">
        <FormItem>
        <Button type="error" long @click="submit">确认删除</Button>
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
	        	username2:"",
	    		res:null,
                admintoken:null
        	}
        },
        methods:{
        axiosdeleteuser(){
            this.axios.delete('/api/admin/deleteUser?username='+this.username)
                .then((response)=>{
                    if(response.status==200&&response.data==1){
                    this.$Modal.success({
                            title:"删除成功",
                            content:"已成功删除此用户",
                            onOk: () => {
                            this.$router.go(0); 
                            },
                        });
                    }else{
                    this.$Message.error('删除失败,权限不足或此用户不存在');
                    }
                })
                .catch((error)=>{console.log(error);});
         },
         confirm() {
                this.$Modal.confirm({
                    title: '操作警告:',
                    content: '<p>正在尝试删除用户名为: '+this.username+' 的用户</p>',
                    onOk: () => {
                        this.axiosdeleteuser();
                    },
                    onCancel: () => {
                        this.$Message.info('操作取消');
                    }
                });
        },
      	submit(){
      		if(this.username=='')
			{this.$Message.error('要删除的用户名不能为空');}
			else if(this.password=='')
			{this.$Message.error('确认用户名不能为空');}
			else{
            this.confirm();
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
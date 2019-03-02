<template>
    <Row justify="center" type="flex">
        <Col :xs="24" :sm="24" :md="24" :lg="24" class="container">
            <Table stripe :columns="columns1" :data="data1" style="margin-top: 20px;border-radius:3px"></Table>
        </Col>
    </Row>
</template>

<script>
import expandRow from './adminUserInfoExpand.vue';
    export default {
        data () {
            return {
                columns1: [
                    {
                        type: 'expand',
                        width: 50,
                        render: (h, params) => {
                            return h(expandRow, {
                                props: {
                                    row: params.row
                                }
                            })
                        }
                    },
                    {
                        title: 'ID',
                        key: 'userId',
                        width:'60px',
                        align:"center"
                    },
                    {
                        title: 'UserName',
                        key: 'username',
                        align:"center"
                    },
                    {
                        title: '用户昵称',
                        key: 'nickname',
                        align:"center"
                    },
                    {
                        title: '手机号码',
                        key: 'telephone',
                        align:"center"
                    },
                    {
                        title: '是否可用',
                        key: 'enable',
                        align:"center"
                    },
                    {
                        title: '删除',
                        key: 'delete',
                        width:'120px',
                        align:'center',
                        render: (h, params) => {
                        return h('Poptip', {
                        props: {
                            confirm: true,
                            title: '确定要删除此用户?',
                            transfer: true
                        },
                        style: {
                            cursor: 'pointer',
                        },
                        attrs: {
                            title: '删除'
                        },
                        on: {
                            'on-ok': () => {
                                this.$Modal.confirm({
                                        title: '操作警告:',
                                        content: '<p>正在尝试删除用户名为: '+params.row.username+' 的用户</p>',
                                        onOk: () => {
                                            this.axiosdeleteuser(params.row.username);
                                        },
                                        onCancel: () => {
                                            this.$Message.info('操作取消');
                                        }
                                    });
                            }
                        }
                        }, [
                        h('Icon',{
                            props: {
                                title: '删除',
                                type: 'md-trash',
                                color: '#ff5050',
                                size:20
                                }
                             })
                        ])
                        }
                    },          
                ],
                data1: []
            }
        },
        mounted(){
            this.getalluser();
        },
        methods:{
            getalluser(){
                this.axios.get("/api/admin/getAllUser")
                .then((response)=>{
                    this.data1=response.data;
                })
                .catch((error)=>{
                console.log(error);
                this.$Message.error('获取数据失败,错误代码:'+error.response.status);  
                });
            },
            axiosdeleteuser(username){
            this.axios.delete('/api/admin/deleteUser?username='+username)
                .then((response)=>{
                    if(response.status==200&&response.data==1){
                    this.$Message.success("已成功删除此用户");
                    }else{
                    this.$Message.error('删除失败,权限不足或此用户不存在');
                    }
                })
                .catch((error)=>{console.log(error);
                this.$Message.error('删除失败,权限不足或此用户不存在,错误代码:'+error.response.status);});
            },
            }
    }
</script>

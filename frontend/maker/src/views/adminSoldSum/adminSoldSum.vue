<template>
    <Row justify="center" type="flex">
        <Col :xs="23" :sm="23" :md="23" :lg="23" class="container">
            <Table stripe :columns="columns1" :data="data1" style="margin-top: 20px;border-radius:3px"></Table>
        </Col>
    </Row>
</template>

<script>
    export default {
        data () {
            return {
                columns1: [
                    {
                        title: 'ID',
                        key: 'productId',
                        width:'80px',
                        align:"center"
                    },
                    {
                        title: '商品名称',
                        key: 'productName',
                        width:'400px',
                        align:"center"
                    },
                    {
                        title: '销售统计',
                        key: 'sales',
                        align:"center"
                    },
                    {
                        title: '实时库存',
                        key: 'productStock',
                        align:"center"
                    }
                ],
                data1: []
            }
        },
        mounted(){
            this.getproduct();
        },
        methods:{
            getproduct(){
                this.axios.get("/api/admin/getProduct")
                .then((response)=>{
                    this.data1=response.data;
                })
                .catch((error)=>{
                console.log(error);
                this.$Message.error('获取数据失败,错误代码:'+error.response.status);  
                });
            }
        }
    }
</script>

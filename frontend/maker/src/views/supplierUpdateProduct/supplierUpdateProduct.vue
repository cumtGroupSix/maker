<template>
    <div>
        <Form :model="formItem" :label-width="200" class="mr-5">
            <!-- <FormItem label="请输入您要搜索的产品名称" class="m-3">
                <Input v-model="productName" placeholder="产品名称..."></Input>
            </FormItem> -->
            <div v-if="show">
                <FormItem label="产品组名称" class="m-3">
                    <Input v-model="formItem.name" placeholder="产品组名称..."></Input>
                </FormItem>
                <div v-for="(item, index) in this.formItem.products" :key="index">
                    <div style="font-size:20px" class="m-3">第{{index+1}}件商品</div>
                    <FormItem label="产品名称" class="m-3">
                        <Input v-model="item.productName" placeholder="产品名称..."></Input>
                    </FormItem>
                    <FormItem label="产品图片" class="m-3">
                        <img :src="item.imgUrl" alt="" style="height:100px">
                    </FormItem>
                    <FormItem label="产品价格" class="m-3">
                        <Input v-model="item.price" placeholder="产品价格..."></Input>
                    </FormItem>
                    <FormItem label="产品库存量" class="m-3">
                        <Input v-model="item.stock" placeholder="产品库存量..."></Input>
                    </FormItem>
                    <FormItem label="产品规格" class="m-3">
                        <Table :columns="columns" :data="item.specifications"></Table>
                    </FormItem>
                </div>
                <Button icon="ios-build-outline" @click="updateProduct" style="margin:10px auto" class="ml-5">确认修改</Button>
            </div>
        </Form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                columns:[
                    {
                        title: '规格名称',
                        key: 'specification'
                    },
                    {
                        title: '规格值',
                        key: 'specificationValue'
                    }
                ],
                productName: '',
                formItem:{

                },
                show:true
            }
        },
        mounted(){
            this.formItem = this.$store.state.currentGroup
        },
        watch: {
            productName(newValue) {
                if(newValue != ''){
                    this.show = false
                    this.axios.get('/api/product/group/detail?productName='+newValue)
                        .then(res=>{
                            if(res.data != null && res.data != ''){
                                this.show = true
                                this.formItem = res.data
                            }
                        })
                }else{
                    this.show = false
                }
            },
            currentGroup(){
                this.formItem = this.$store.state.currentGroup
            }
        },
        methods: {
            deleteProduct() {
                this.$Modal.confirm({
                    title: '删除商品',
                    content: '<p>确定要将商品删除吗？</p>',
                    onOk: () => {
                        this.axios.delete('/api/product/supplier/delete?productName='+this.formItem[0].productName)
                            .then(res =>{
                            if(res.status == 200){
                                this.$Message.success('删除成功');
                            }
                        }).catch(error =>{
                            alert(error)
                        })
                    },
                    onCancel: () => {
                        this.$Message.info('Clicked cancel');
                    }
                });
            },
            updateProduct(){
                this.$Modal.confirm({
                    title: '修改商品',
                    content: '<p>确定要将商品修改吗？</p>',
                    onOk: () => {
                        this.axios.put('/api/product/supplier/update',this.formItem)
                            .then(res =>{
                            if(res.status == 200){
                                this.$Message.success('修改成功');
                            }
                        }).catch(error =>{
                            alert(error)
                        })
                    },
                    onCancel: () => {
                        this.$Message.info('Clicked cancel');
                    }
                });
            },
            
        },
        computed: {
            currentGroup() {
                return this.$store.state.currentGroup 
            }
        },
    }
</script>

<style scoped>

</style>
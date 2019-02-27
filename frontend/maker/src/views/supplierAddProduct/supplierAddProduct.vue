<template>
    <div class="m-5">
        <Form :model="formItem" :label-width="80">
            <FormItem label="类目">
                <Select v-model="formItem.categoryId">
                    <Option v-for="(item, index) in categorys" :key="index" :value="item.categoryId">{{item.categoryName}}</Option>
                </Select>
            </FormItem>
            <FormItem label="产品组名称">
                <Input v-model="formItem.productName" placeholder="产品名称为必填项"></Input>
            </FormItem>
            <Button type="primary" class="ml-5" @click="addProduct">增加具体商品</Button>
            <div v-for="(item, index) in formItem.products" :key="index" class="mt-3">
                <div style="font-size:20px" class="m-2">第{{index+1}}件商品</div>
                <FormItem label="上传图片">
                    <div class="d-flex">
                        <Upload action="/api/upload"
                        :on-success="(response) => uploadSuccess(index,response)">
                            <Button icon="ios-cloud-upload-outline">Upload image</Button>
                        </Upload>
                        <Input v-model="item.imageUrl" placeholder="图片路径，上传后即可显示..." :readonly="imgLock" class="ml-3"></Input>
                    </div>
                </FormItem>
                <FormItem label="产品描述">
                    <Input v-model="item.description" type="textarea" placeholder="Enter something..." />
                </FormItem>
                <FormItem label="产品价格">
                    <Input v-model="item.price" placeholder="必填项..." />
                </FormItem>
                <FormItem label="产品库存量">
                    <Input v-model="item.stock" placeholder="必填项..." />
                </FormItem>
                <FormItem label="产品规格">
                    <div class="d-flex">
                        <Input v-model="specificationName" placeholder="规格名称..." class="mx-2"></Input>
                        <Input v-model="specificationValue" placeholder="规格值..." class="mx-2"></Input>
                        <Button icon="md-add" @click="addSpecification(index)" class="mx-2">添加</Button>
                    </div>
                </FormItem>
                 <Table :columns="columns" :data="item.specifications"></Table>
                <div><Icon type="md-trash" style="font-size:25px;cursor:pointer" @click="deleteProduct(index)" class="my-2" /></div>
            </div>
        </Form>
        <div><Button icon="md-add" @click="commit" style="margin:10px auto" v-if="commitShow">提交</Button></div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                commitShow:false,
                specificationName:'',
                specificationValue:'',
                columns:[
                    {
                        title: '规格名称',
                        key: 'specificationName'
                    },
                    {
                        title: '规格值',
                        key: 'specificationValue'
                    }
                ],
                imgLock:true,
                categorys:[],
                formItem:{
                    categoryId: 0,
                    productName: "",
                    products: [
                        
                    ]
                }
            }
        },
        mounted(){
            this.axios.get("/api/category/all")
                .then(res=>{
                    this.categorys = res.data
                })
        },
        methods: {
            addProduct() {
                this.formItem.products.push({
                            description: "",
                            imageUrl: "",
                            price: 0,
                            stock: 0,
                            specifications: [
                                
                            ]
                        })
                this.commitShow = true
            },
            deleteProduct(index){
                this.formItem.products.splice(index,1)
            },
            uploadSuccess(index,response){
                console.log(index)
                console.log(response)
                this.formItem.products[index].imageUrl =  response
            },
            addSpecification(index){
                this.formItem.products[index].specifications.push({
                    specificationName : this.specificationName,
                    specificationValue : this.specificationValue
                })
                this.specificationName = ''
                this.specificationValue = ''
            },
            commit(){
                this.$Modal.confirm({
                    title: '上架商品',
                    content: '<p>确定要将商品上架吗？</p>',
                    onOk: () => {
                        this.axios.post('/api/product/supplier/insert',this.formItem).then(res =>{
                            if(res.status == 200){
                                this.$Message.success('上架成功');
                            }
                        }).catch(error =>{
                            alert(error)
                        })
                    },
                    onCancel: () => {
                        this.$Message.info('Clicked cancel');
                    }
                });
            }
        },
    }
</script>

<style scoped>

</style>
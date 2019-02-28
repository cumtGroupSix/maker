<template>
    <div>
        <!-- <Tree :data="information"  :load-data="loadData"></Tree> -->
        <div style="border-bottom: 1px solid #e9e9e9;padding-bottom:6px;margin-bottom:6px;">
            <Checkbox
            :indeterminate="indeterminate"
            :value="checkAll"
            @click.prevent.native="handleCheckAll">全选</Checkbox>
        </div>
        <CheckboxGroup v-model="checkedCategorys" @on-change="checkAllGroupChange">
            <Checkbox :label="item.categoryId" v-for="(item, index) in categorys" :key="index">
                <span>{{item.categoryName}}</span>
            </Checkbox>
        </CheckboxGroup>
        <div class="result">
            <Table :columns="columns" :data="information">
                <template slot-scope="{ row, index }" slot="action">
                    <Button type="primary" size="small" style="margin-right: 5px" @click.native="show(index)"><router-link to="/supplier/updateproduct">查看详情</router-link></Button>
                    <Button type="error" size="small" @click="remove(index)">删除</Button>
                </template>
            </Table>
        </div>
    </div>
</template>

<script>
    import MyTable from './component/myTable.vue'
    export default {
        data() {
            return {
                categorys:[],
                // loading: false,
                information: [
                    
                ],
                indeterminate: true,
                checkAll: false,
                checkedCategorys: [1],
                columns:[
                    {
                        type: 'expand',
                        width: 50,
                        render: (h, params) => {
                            return h(MyTable, {
                                props: {
                                    row: params.row
                                }
                            })
                        }
                    },
                    {
                        title: '产品组名称',
                        key: 'name'
                    },
                    {
                        title: '操作',
                        slot: 'action'
                    },

                ]
            }
        },
        components:{
            MyTable
        },
        mounted() {
            this.axios.get('/api/category/all')
                .then(res=>{
                    this.categorys = res.data
                    // for(let i=0;i<res.data.length;i++){
                    //     this.information.push({
                    //     title: this.categorys[i].categoryName,
                    //     loading: false,
                    //     children: []
                    // })
                    // }
                })
            for(let i=0;i<this.checkedCategorys.length;i++){
                this.axios.get('/api/product/supplier/group/detail?categoryId='+this.checkedCategorys[i])
                    .then(res=>{
                        for(let i=0;i<res.data.length;i++){
                            this.information.push(res.data[i]) 
                        }
                    })
            }
        },
        methods: {
            // loadData (item, callback) {
            //     let data = [
                    
            //     ]
            //     console.log(item.title)
            //     this.axios.get('/api/product/goodslist?categoryName='+item.title)
            //         .then(res=>{
            //             for(let i=0;i<res.data.length;i++){
            //                 data.push({
            //                     title: res.data[i].name
            //                 })
            //             }
            //             callback(data)
            //         })
                
            // },
            handleCheckAll () {
                console.log(this.checkedCategorys)
                if (this.indeterminate) {
                    this.checkAll = false;
                } else {
                    this.checkAll = !this.checkAll;
                }
                this.indeterminate = false;

                if (this.checkAll) {
                    this.checkedCategorys = []
                    for(let i=0;i<this.categorys.length;i++){
                        this.checkedCategorys.push(this.categorys[i].categoryId)
                    }
                } else {
                    this.checkedCategorys = [];
                }
                this.information = []
                for(let i=0;i<this.checkedCategorys.length;i++){
                    this.axios.get('/api/product/supplier/group/detail?categoryId='+this.checkedCategorys[i])
                        .then(res=>{
                            for(let i=0;i<res.data.length;i++){
                                this.information.push(res.data[i]) 
                            }
                        })
                }
            },
            checkAllGroupChange (data) {
                console.log(this.checkedCategorys)
                if (data.length === this.categorys.length) {
                    this.indeterminate = false;
                    this.checkAll = true;
                } else if (data.length > 0) {
                    this.indeterminate = true;
                    this.checkAll = false;
                } else {
                    this.indeterminate = false;
                    this.checkAll = false;
                }
                
                this.information = []
                for(let i=0;i<this.checkedCategorys.length;i++){
                    this.axios.get('/api/product/supplier/group/detail?categoryId='+this.checkedCategorys[i])
                        .then(res=>{
                            for(let i=0;i<res.data.length;i++){
                                this.information.push(res.data[i]) 
                            }
                        })
                }
            },
            remove(index){
                this.$Modal.confirm({
                    title: '删除商品',
                    content: '<p>确定要将商品删除吗？</p>',
                    onOk: () => {
                        this.axios.delete('/api/product/supplier/delete?groupId='+this.information[index].groupId)
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
            show(index){
                this.$store.state.currentGroup = this.information[index]
            }
        },
    }
</script>

<style scoped>
a{
    color: white
}
a:hover{
    color: white
}
</style>
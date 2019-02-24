<template>
    <div class="col-md-3 border px-4 h-100">
        <div class="container" style="max-width: 300px">
            <div class="text-center my-3 text-danger" style="font-family: '华文彩云';font-size: 28px;font-weight: bold">主题市场</div>				
            <ul class="row">
                <li class="col-4 col-sm-6 text-center py-3 border-top px-0 " v-for="(item,index) in categorys" :key="index" style="font-family: '微软雅黑';"><router-link to="/stores" style="font-weight:bold" class="text-danger" @click.native="changeCurrentCategoryId(item.categoryId)">{{item.categoryName}}</router-link></li>
            </ul>	
        </div>		
    </div>
</template>

<script>
    export default {
        data() {
            return {
                categorys:[
                    
                ]
            }
        },
        mounted(){
            this.axios.get("/api/category/all")
                .then(res=>{
                    this.categorys = res.data
                })
        },
        methods: {
            changeCurrentCategoryId(categoryId) {
                this.$store.state.currentCategoryId = categoryId
            }
        },
    }
</script>

<style scoped>

</style>
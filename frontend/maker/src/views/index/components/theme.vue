<template>
    <div class="col-md-3 border px-4 h-100">
        <div class="container" style="max-width: 300px">
            <div class="text-center my-3 text-danger" style="font-family: '华文彩云';font-size: 28px;font-weight: bold">主题市场</div>				
            <ul class="row">
                <li class="col-4 col-sm-6 text-center py-3 border-top px-0 " v-for="(item,index) in keys" :key="index" style="font-family: '微软雅黑';"><router-link to="/stores" style="font-weight:bold" class="text-danger">{{item.name}}</router-link></li>
            </ul>	
        </div>		
    </div>
</template>

<script>
    export default {
        data() {
            return {
                keys:[
                    {name:"特产"},
                    {name:"班服"},
                    {name:"球服"},
                    {name:"情侣装"},
                    {name:"兄弟装"},
                    {name:"自行车"},
                    {name:"键盘"},
                    {name:"鼠标"},
                    {name:"音箱"},
                    {name:"耳机"},
                    {name:"手机壳"},
                    {name:"钢化膜"},
                    {name:"美妆"},
                    {name:"个人护理"},
                    {name:"零食"},
                    {name:"体育用品"},
                    {name:"周边"},
                    {name:"鲜花园艺"},
                    {name:"宿舍用品"},
                    {name:"书籍"},
                    {name:"文具办公"},
                    {name:"DIY"},
                    {name:"学业辅导"},
                    
                ]
            }
        },
    }
</script>

<style scoped>

</style>
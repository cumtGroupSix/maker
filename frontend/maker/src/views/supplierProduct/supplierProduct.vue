<template>
    <div>
        <Tree :data="information"  :load-data="loadData"></Tree>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                categorys:[],
                loading: false,
                information: [
                    
                ],
                
            }
        },
        mounted() {
            this.axios.get('/api/category/all')
                .then(res=>{
                    this.categorys = res.data
                    for(let i=0;i<res.data.length;i++){
                        this.information.push({
                        title: this.categorys[i].categoryName,
                        loading: false,
                        children: []
                    })
                    }
                })
        },
        methods: {
            loadData (item, callback) {
                let data = [
                    
                ]
                console.log(item.title)
                this.axios.get('/api/product/goodslist?categoryName='+item.title)
                    .then(res=>{
                        for(let i=0;i<res.data.length;i++){
                            data.push({
                                title: res.data[i].name
                            })
                        }
                        callback(data)
                    })
                
            }
            
        },
    }
</script>

<style scoped>

</style>
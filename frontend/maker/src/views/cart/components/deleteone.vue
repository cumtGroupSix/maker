<template>
<div id='root'><Button style='color:blue'  @click='deleteone'>删除</Button></div>
</template>

<script>
    export default {
    	props:['items'],
       data(){
			return{
			}
		},
		methods:{
			deleteone(){
				this.$emit('deleteone',this.items.productid);
			}
		}
	}
</script>

<style scoped>
</style>
<template>
<div id='root'><Button style='color:blue' @click='collectone'>收藏</Button></div>
</template>

<script>
    export default {
    	props:['items'],
       data(){
			return{
			}
		},
		methods:{
			collectone(){
				this.$emit('collectone',this.items.groupid);
			}
		}
	}
</script>

<style scoped>
</style>
<template>
<div id='root'><a href='#' @click='deleteone' style='color:blue'>删除</a></div>
</template>

<script>
    export default {
    	props:['items','spids'],
       data(){
			return{
			}
		},
		methods:{
			deleteone(){
				},
		}
	}
</script>

<style scoped>
</style>
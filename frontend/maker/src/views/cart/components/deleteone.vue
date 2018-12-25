<template>
<div id='root'><a href='#' @click='deleteone' style='color:blue'>删除</a></div>
</template>

<script>
    export default {
    	props:['items','spids'],
       data(){
			return{
				count:0,
			}
		},
		methods:{
			deleteone(){
				this.count=this.count+1;
				if(this.spids.indexOf(this.items.info)>=0){
					this.items.vf=false;
					this.$emit('co',this.items.info);
					this.$emit('kong',this.items.info);
					this.$emit('full',this.count);
					}else{
					this.items.vf=false;
					this.$emit('kong',this.items.info);
					this.$emit('full',this.count);
					}
				},
		}
	}
</script>

<style scoped>
</style>
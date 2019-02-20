<template>
    <div class="container" style="max-width: 1500px">
        <div class="row">
            <!--页头-->
            <div class="col-12"><my-title></my-title></div>
            <!--评价等级-->
            <div class="col-12"><my-level></my-level></div>
            <!--评价内容-->
            <div class="col-12"><my-message></my-message></div>
            <!--评价图片-->
            <div class="col-12"><my-picture></my-picture></div>
        </div>
    </div>
</template>

<script>
    import MyTitle from  './components/title'
    import MyLevel from './components/level'
    import MyMessage from './components/message'
    import MyPicture from  './components/picture'

    export default {
        components:{
            MyTitle,
            MyLevel,
            MyMessage,
            MyPicture
        }
    }
</script>

<style scoped>

</style>
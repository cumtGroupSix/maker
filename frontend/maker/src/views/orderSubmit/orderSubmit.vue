<template>
    <div class="container" style="max-width: 1500px">
        <div class="row">
            <!--页头-->
            <div class="col-12"><my-title></my-title></div>
            <!--提交信息1-->
            <div class="col-12"><my-message1></my-message1></div>
            <!--提交信息2-->
            <div class="col-12"><my-message2></my-message2></div>
        </div>
    </div>
</template>

<script>
    import MyTitle from  './components/title'
    import MyMessage1 from './components/message1'
    import MyMessage2 from './components/message2'
    import axios from 'axios'

    export default {
        components:{
            MyTitle,
            MyMessage1,
            MyMessage2
        },
        data(){
            return{
            }
        },

        methods:{
        },
        mounted(){
        }

    }
</script>

<style scoped>

</style>
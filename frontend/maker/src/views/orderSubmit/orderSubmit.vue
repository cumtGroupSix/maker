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
        mounted(){
        this.axiosgetorderDetail()
        },
        methods: {
            axiosgetorderDetail() {
                this.axios.get('api/orderDetail/get')
                    .then((response) => {
                        this.$store.state.certain = response.data;
                        console.log(this.$store.state.certain);
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            }
        }
    }
</script>

<style scoped>

</style>
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
    import axios from 'axios'

        export default {
        components:{
            MyTitle,
            MyLevel,
            MyMessage,
            MyPicture
        },

        methods:{
            submit() {
                    this.axios.post('/api/comment/insert', {
                        userId: '2',
                        productId: '2',
                        commentContent: this.commentContent,
                        commentTime: new Date(),
                        starLevel1: '3',
                        starLevel2: '3',
                        starLevel3: '3',
                        imgUrl1: '3',
                        imgUrl2: '3',
                        imgUrl3: '3',
                        imgUrl4: '3',
                    })
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
            }
        },

        mounted(){
            this.submit()
        }
    }
</script>

<style scoped>

</style>

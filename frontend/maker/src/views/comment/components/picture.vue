<template>
    <div class="picture">
        <div class="imgArea">
            <h2>图片上传预览</h2>
            <ul>
                <li v-for="(item,index) in mmm" :key="index">
                    <img v-if="item.data != ''" v-bind:src=" item.data || index " >
                    <input type="file" :id=" item.name " @change="pushImg($event,index)" accept="image/jpeg,image/png,image/gif" alt="">
                    <span class="clear" v-if="item.data != ''" @click="delImg($event,index)">×</span>
                </li>
            </ul>
        </div>
        <router-link to="/product" class="btn btn-danger btn-lg" @click="submit">提交评价</router-link>
    </div>
</template>

<script>
    export default {
        name: 'picture',
        data() {
            return {
                flag: {
                    change: false
                },
                mmm: [
                    {
                        name: 'A',
                        data: ''
                    },
                    {
                        name: 'B',
                        data: ''
                    },
                    {
                        name: 'C',
                        data: ''
                    },
                    {
                        name: 'D',
                        data: ''
                    }
                ],
            }
        },
        methods: {
            pushImg: function (e, i) {
                let mm = this.mmm, flag = this.flag, file = e.target, reader = new FileReader();
                reader.readAsDataURL(file.files[0]);
                reader.onload = function () {
                    mm[i].data = this.result;
                    flag.change = true;
                    setTimeout(() => {
                        flag.change = false;
                    }, 2000)
                }
            },
            delImg: function (e, i) {
                this.mmm[i].data = '';
                let dom = document.getElementById(this.mmm[i].name);
                dom.value = '';
            },
        },
    }

</script>

<style scoped>
    .picture{
        width: 100%;
        height: 100%;
    }
    .imgArea{
        height: 200px;
        margin: 20px auto;
    }
    .imgArea ul{
        margin-top: 30px;
    }
    .imgArea li{
        display: inline-block;
        width: 100px;
        height: 100px;
        line-height: 50px;
        position: relative;
        margin-right: 10px;
        border-radius: 5px;
        border:2px solid #dddddd;
    }
    .imgArea img{
        position: absolute;
        top: 0;
        left: 0;
        width: 100px;
        height: 100px;
    }
    .imgArea input{
        position: absolute;
        left: 0;
        width: 100%;
        height: 100%;
        opacity: 0;
        cursor: pointer;
        z-index: 5;
    }
    .imgArea .clear{
        font-size: 16px;
        color: orangered;
        position: absolute;
        right: -5px;
        top: -25px;
        cursor: pointer;
    }
</style>

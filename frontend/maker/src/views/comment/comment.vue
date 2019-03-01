<template>
    <div class="container" style="max-width: 1500px">
        <div class="row">
            <!--页头-->
            <div class="col-12"><div class="pingjiajiemian"> 评价界面</div></div>
            <!--评价等级-->
            <div class="col-12">
                <!--<div>userID:{{this.username}}</div>-->
                <!--<div>productID:{{this.productId}}</div>-->
                <div id="shoplist1">
                    店铺风格：<Rate v-model="comment.starLevel1" />
                    <br>
                    商品质量：<Rate v-model="comment.starLevel2" />
                    <br>
                    服务态度：<Rate v-model="comment.starLevel3" />
                </div>
            </div>
            <!--评价内容-->
            <div class="col-4">
                <textarea class="message" rows="10" cols="70" style="resize: none" placeholder="此处最多输入200字" v-model="comment.commentContent"></textarea>
            </div>
            <!--评价图片-->
            <div class="col-12">
                <div class="imgArea">
                    <h2>图片上传</h2>
                    <ul>
                        <Upload
                                type="drag"
                                action="/api/upload"
                                :on-success="uploadSuccess1">
                            <div style="padding: 20px 0">
                                <Icon type="ios-cloud-upload" size="20" style="color: #3399ff"></Icon>
                                <p>点击上传</p>
                            </div>
                        </Upload>
                        <Upload
                                type="drag"
                                action="/api/upload"
                                :on-success="uploadSuccess2">
                            <div style="padding: 20px 0">
                                <Icon type="ios-cloud-upload" size="20" style="color: #3399ff"></Icon>
                                <p>点击上传</p>
                            </div>
                        </Upload>
                        <Upload
                                type="drag"
                                action="/api/upload"
                                :on-success="uploadSuccess3">
                            <div style="padding: 20px 0">
                                <Icon type="ios-cloud-upload" size="20" style="color: #3399ff"></Icon>
                                <p>点击上传</p>
                            </div>
                        </Upload>
                        <Upload
                                type="drag"
                                action="/api/upload"
                                :on-success="uploadSuccess4">
                            <div style="padding: 20px 0">
                                <Icon type="ios-cloud-upload" size="20" style="color: #3399ff"></Icon>
                                <p>点击上传</p>
                            </div>
                        </Upload>

                    </ul>
                </div>
                <router-link to="/product" class="btn btn-danger btn-lg" @click.native="submit">提交评价</router-link>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
           return{
               comment:{
                   starLevel1: 5,
                   starLevel2: 5,
                   starLevel3: 5,
                   commentContent: '',
                   commentTime:new Date(),
                   productId: 1,
                   userId:1,
                   imgUrl1:'',
                   imgUrl2:'',
                   imgUrl3:'',
                   imgUrl4:''
               }
           }
        },
        methods:{
            uploadSuccess1(res){
                this.comment.imgUrl1=res
            },
            uploadSuccess2(res){
                this.comment.imgUrl2=res
            },
            uploadSuccess3(res){
                this.comment.imgUrl3=res
            },
            uploadSuccess4(res){
                this.comment.imgUrl4=res
            },
            submit(){
                this.axios.post('api/comment/insertComment',this.comment).then(res=>{
                    if(res.data==200){
                        this.finish=true
                        alert("评论添加成功")
                    }
                }).catch(error=>{
                    alert(error)
                })
            }
        },
        mounted () {
            this.axios.get('api/comment/getComment/1')
        }
    }
</script>

<style scoped>
    .all>input{opacity:0;position:absolute;width:2em;height:2em;margin:0;}
    .all>input:nth-of-type(1),
    .all>span:nth-of-type(1){display:none;}
    .all>span{font-size:2em;color:gold;
        -webkit-transition:color
        .2s;
        transition:color
        .2s;
    }
    .all>input:checked~span{color:#666;}
    .all>input:checked+span{color:gold;}

    .pingjiajiemian{
        font-family: '隶书';
        color:#ff9966;
        font-size: 50px;
    }

    .message{
        border:3px solid #dddddd;
        margin-top: 30px;
        box-shadow: 0px 0px 1px 1px #dddddd;
        border-radius: 5px;
    }
</style>

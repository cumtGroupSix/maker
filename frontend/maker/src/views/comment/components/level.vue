<template>
    <div>
    <div id="shoplist1">
        <p class="all">店铺风格
            <input type="radio" name="a" value="0" v-model="inputdata1"/>
            <span>★</span>
            <input type="radio" name="a" value="1" v-model="inputdata1" />
            <span>★</span>
            <input type="radio" name="a" value="2" v-model="inputdata1" />
            <span>★</span>
            <input type="radio" name="a" value="3" v-model="inputdata1" />
            <span>★</span>
            <input type="radio" name="a" value="4" v-model="inputdata1" />
            <span>★</span>
            <input type="radio" name="a" value="5" v-model="inputdata1" />
            <span>★</span>
        </p>
    </div>
    <div id="shoplist2">
        <p class="all">商品质量
            <input type="radio" name="b" value="0" v-model="inputdata2"/>
            <span>★</span>
            <input type="radio" name="b" value="1" v-model="inputdata2" />
            <span>★</span>
            <input type="radio" name="b" value="2" v-model="inputdata2" />
            <span>★</span>
            <input type="radio" name="b" value="3" v-model="inputdata2" />
            <span>★</span>
            <input type="radio" name="b" value="4" v-model="inputdata2" />
            <span>★</span>
            <input type="radio" name="b" value="5" v-model="inputdata2" />
            <span>★</span>
        </p>
    </div>
    <div id="shoplist3">
        <p class="all">服务态度
            <input type="radio" name="c" value="0" v-model="inputdata3"/>
            <span>★</span>
            <input type="radio" name="c" value="1" v-model="inputdata3" />
            <span>★</span>
            <input type="radio" name="c" value="2" v-model="inputdata3" />
            <span>★</span>
            <input type="radio" name="c" value="3" v-model="inputdata3" />
            <span>★</span>
            <input type="radio" name="c" value="4" v-model="inputdata3" />
            <span>★</span>
            <input type="radio" name="c" value="5" v-model="inputdata3" />
            <span>★</span>
        </p>
    </div>
    </div>
</template>

<script>
    export default {
        name:'shoplist1',
        data(){
            return {
                inputdata1:'5',
                inputdata2:'5',
                inputdata3:'5'
            }
        },

        methods:{
        },
        watch: {
            inputdata(value) {
                console.log(value)
            }
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
</style>
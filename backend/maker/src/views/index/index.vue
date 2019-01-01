<template>
    <div id="root">
      <div class="container" style="max-width: 1050px">
        <div class="row">
          <!--	主题市场-->
          <my-theme></my-theme>
          <div class="col-md-9 col-12">
            <!--	轮播图-->
            <my-carousel></my-carousel>
            <!--	热门店铺-->
            <hot-store></hot-store>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import MyCarousel from './components/carousel'
import MyTheme from './components/theme'
import HotStore from './components/hotStore'
export default {
    data(){
        return{
            
        }
    },
    components:{
        MyCarousel,
        MyTheme,
        HotStore
    },
    mounted: function() {
        this.getJsonInfo();
                var getUrl='/api/store/hot';
                this.$http.get(getUrl).then(response => {
        this.$store.state.hotStore=response.body;
        console.log(this.$store.state.hotStore);
        }, response => {
        console.log("error");
        });
    },
    computed: {
        
    },
    methods:{
        getJsonInfo() {
            this.$http.get('js/User.json').then(function(response){
            this.users=response.body.users;
            }).catch(function(response){
            console.log(response);
            })
        },
        
    }
}
</script>

<style scoped>

</style>
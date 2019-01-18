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
        
    },
    computed: {
        
    },
    methods:{
        
    }
}
</script>

<style scoped>

</style>
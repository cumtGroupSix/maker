<template>
  <div id="app">
    <my-header></my-header>
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
    <my-footer></my-footer> 
  </div>
</template>

<script>
import MyHeader from "./components/myHeader"
import MyFooter from "./components/myFooter"
export default {
  components:{
    MyHeader,
    MyFooter
  }
}
</script>


<style>

</style>

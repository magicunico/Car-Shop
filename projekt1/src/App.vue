<template>
  <div id="app">
    <notifications group="foo" class="x"/>
    <Header/>
    <router-view/>
  </div>
</template>
<script>
import Header from '@/components/Header'
export default {
  name: 'App',
  components:{
    Header
  }

}
</script>
<style>
  /* @import 'assets/styles/main.scss'; */
  #app{
    padding-right: 0%
  }
  .x{
    margin-top: 100px;
    max-width: 300px;
  }
</style>

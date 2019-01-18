<template>
  <div id="app">
    <notifications group="foo"/>
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
</style>

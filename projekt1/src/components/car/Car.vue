<template>
<div class="container">
    <LeftMenu @change-emp="change"/>
    <Form v-if="form"/>
    <List v-if="list"/>
    <All v-if="all"/>
  </div>
</template>

<script>
import axios from 'axios'
import LeftMenu from '@/components/car/CarMenu'
import Form from '@/components/car/CarForm'
import List from '@/components/car/CarList'
import All from '@/components/car/CarAll'



export default {
components:{
    LeftMenu,
    List,
    Form,
    All,
},
  data () {
    return {
      list:true,
      form:false,
      all:false,
     
    }
  },
  methods:{
      change(payload){
        if(payload == 'form'){
            this.form = true;
            this.list = false;
            this.all=false;
            
        } else if (payload == 'list') {
            this.form = false;
            this.list = true;
            this.all = false;
            
        } else if (payload == 'all') {
            this.all=true;
            this.form = false;
            this.list = false;
            
        } 
      }
  }
}
</script>
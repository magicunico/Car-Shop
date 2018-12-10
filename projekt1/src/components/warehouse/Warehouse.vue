<template>
<div class="container">
    <LeftMenu @change-emp="change"/>
    <Form v-if="form"/>
    <List v-if="list"/>
    <List v-if="all"/>
  </div>
</template>

<script>
import axios from 'axios'
import LeftMenu from '@/components/warehouse/WarehouseMenu'
import Form from '@/components/warehouse/WarehouseForm'
import List from '@/components/warehouse/WarehouseList'
import All from '@/components/warehouse/WarehouseAll'
export default {
components:{
    LeftMenu,
    Form,
    List,
    All,
},
  data () {
    return {
      list:false,
      form:true,
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
            this.all=false;

        }else if (payload == 'all') {
            this.all=true;
            this.form = false;
            this.list = false;
        }
      }
  }
}
</script>

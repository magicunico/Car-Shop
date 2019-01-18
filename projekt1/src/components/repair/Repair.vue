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
import LeftMenu from '@/components/repair/RepairMenu'
import Form from '@/components/repair/RepairForm'
import List from '@/components/repair/RepairList'
import All from '@/components/repair/RepairAll'
export default {
components:{
    LeftMenu,
    Form,
    List,
    All
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
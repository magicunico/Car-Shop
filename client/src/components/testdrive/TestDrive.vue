<template>
<div class="container">
    <LeftMenu @change-emp="change"/>
    <Form v-if="form"/>
    <List v-if="list"/>
    <All v-if="all"/>
    <EmployeeList/>
    <CustomerList/>
    <CarList/>
  </div>
</template>

<script>
import axios from 'axios'
import LeftMenu from '@/components/testdrive/TestDriveMenu'
import Form from '@/components/testdrive/TestDriveForm'
import List from '@/components/testdrive/TestDriveList'
import All from '@/components/testdrive/TestDriveAll'
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
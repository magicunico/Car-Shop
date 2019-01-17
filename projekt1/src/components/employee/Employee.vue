<template>
<div class="container">
    <LeftMenu @change-emp="change"/>
    <Form v-if="form"/>
    <List v-if="list"/>
    <All v-if="all"/>
    <Manage v-if="manage"/>
  </div>
</template>

<script>
import axios from 'axios'
import LeftMenu from '@/components/employee/EmployeeMenu'
import Form from '@/components/employee/EmployeeForm'
import List from '@/components/employee/EmployeeList'
import All from '@/components/employee/EmployeeAll'
import Manage from '@/components/employee/EmployeeManage'
export default {
components:{
    LeftMenu,
    Form,
    List,
    All,
    Manage,
},
  data () {
    return {
      list:true,
      form:false,
      all:false,
      manage:false,
    }
  },
  methods:{
      change(payload){
        if(payload == 'form'){
            this.form = true;
            this.list = false;
            this.all=false;
            this.manage=false;
        } else if (payload == 'list') {
            this.form = false;
            this.list = true;
            this.all=false;
            this.manage=false;
        }else if (payload == 'all') {
            this.all=true;
            this.form = false;
            this.list = false;
            this.manage=false;
        }else if (payload == 'manage') {
            this.all=false;
            this.form = false;
            this.list = false;
            this.manage=true;
        }
      }
  }
}
</script>

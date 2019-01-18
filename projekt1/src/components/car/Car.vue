<template>
<div class="container">
    <LeftMenu @change-emp="change"/>
    <Form v-if="form"/>
    <List v-if="list"/>
    <All v-if="all"/>
    <CarBrand v-if="carBrand"/>
    <CarProducer v-if="carProducer"/>
    <CarBrandAll v-if="carBrandAll"/>
    <CarBrandList v-if="carBrandList"/>
    <CarBrandForm v-if="carBrandForm"/>
    <CarProducerAll v-if="carProducerAll"/>
    <CarProducerList v-if="carProducerList"/>
    <CarProducerForm v-if="carProducerForm"/>
  </div>
</template>

<script>
import axios from 'axios'
import LeftMenu from '@/components/car/CarMenu'
import Form from '@/components/car/CarForm'
import List from '@/components/car/CarList'
import All from '@/components/car/CarAll'
import CarBrandAll from '@/components/car/CarBrandAll'
import CarBrandList from '@/components/car/CarBrandList'
import CarBrandForm from '@/components/car/CarBrandForm'
import CarProducerAll from '@/components/car/CarProducerAll'
import CarProducerList from '@/components/car/CarProducerList'
import CarProducerForm from '@/components/car/CarProducerForm'


export default {
components:{
    LeftMenu,
    Form,
    List,
    All,
    CarBrandAll,
    CarBrandList,
    CarBrandForm,
    CarProducerAll,
    CarProducerList,
    CarProducerForm
},
  data () {
    return {
      list:true,
      form:false,
      all:false,
      carBrandAll:false,
      carBrandList:false,
      carBrandForm:false,
      carProducerAll:false,
      carProducerList:false,
      carProducerForm:false,
    }
  },
  methods:{
      change(payload){
        if(payload == 'form'){
            this.form = true;
            this.list = false;
            this.all=false;
            this.carBrandAll=false;
            this.carBrandList=true;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=true;
            this.carProducerForm=false;
        } else if (payload == 'list') {
            this.form = false;
            this.list = true;
            this.all = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=false;
        } else if (payload == 'all') {
            this.all=true;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=false;
        } else if(payload=='carBrandAll'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=true;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=false;
        }else if(payload=='carBrandList'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=true;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=false;
        }else if(payload=='carBrandForm'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=true;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=false;
        } else if(payload=='carProducerAll'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=true;
            this.carProducerList=false;
            this.carProducerForm=false;
        }else if(payload=='carProducerList'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=true;
            this.carProducerForm=false;
        }else if(payload=='carProducerForm'){
            this.all=false;
            this.form = false;
            this.list = false;
            this.carBrandAll=false;
            this.carBrandList=false;
            this.carBrandForm=false;
            this.carProducerAll=false;
            this.carProducerList=false;
            this.carProducerForm=true;
        }
      }
  }
}
</script>
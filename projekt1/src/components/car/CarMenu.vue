<template>
    <Slide class="slide-menu" right>
        <span @click="changeToForm">Form</span>
        <span @click="changeToList">List</span> 
        <span @click="changeToAll">All</span>
        <span @click="changeToCarBrandAll">CarBrandAll</span>   
        <span @click="changeToCarBrandList">CarBrandList</span>        
        <span @click="changeToCarBrandForm">CarBrandForm</span>        
        <span @click="changeToCarProducerAll">CarProducerAll</span>   
        <span @click="changeToCarProducerList">CarProducerList</span>        
        <span @click="changeToCarProducerForm">CarProducerForm</span>        
     
    </Slide>
</template>
<script>
import { Slide } from 'vue-burger-menu'
import moment from 'moment'
export default {
    components:{Slide},
    methods:{
        changeToForm(){
            this.$emit('change-emp','form')
        },
        changeToList(){
            this.$emit('change-emp','list')
        },
         changeToAll(){
            this.$emit('change-emp','all')
        },
         changeToCarBrandAll(){
            this.$emit('change-emp','carBrandAll')
        },
         changeToCarBrandList(){
            this.$emit('change-emp','carBrandList')
        },
         changeToCarBrandForm(){
            this.$emit('change-emp','carBrandForm')
        },
         changeToCarProducerAll(){
            this.$emit('change-emp','carProducerAll')
        },
         changeToCarProducerList(){
            this.$emit('change-emp','carProducerList')
        },
         changeToCarProducerForm(){
            this.$emit('change-emp','carProducerForm')
        },
    },

    
    
}
</script>
<style>
.slide-menu{
    top:150px;
    left:150px;
}

</style>

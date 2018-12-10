<template>
    <Slide class="slide-menu" right>
        <span @click="changeToForm">Form</span>
        <span @click="changeToList">List</span> 
        <span @click="changeToAll">All</span>        
    </Slide>
</template>
<script>
import { Slide } from 'vue-burger-menu'
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
        }
    }
    
    
}
</script>
<style>
.slide-menu{
    top:150px;
    left:150px;
}

</style>

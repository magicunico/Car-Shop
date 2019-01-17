<template>
    <Slide class="slide-menu" right>
        <span @click="changeToForm">Form</span>
        <span @click="changeToList">List</span>    
        <span @click="changeToAll">All</span>
        <span @click="changeToManage">Manage</span>
        
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
        },
         changeToManage(){
            this.$emit('change-emp','manage')
        }
    }
    
    
}
</script>
<style>
.slide-menu{
    top:15%;
}

</style>

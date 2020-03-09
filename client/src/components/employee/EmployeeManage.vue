<template>
         <b-button @click="count()">Generate Raport</b-button>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            field,
        }
    },
    methods:{
        count(){
            axios.get("http://localhost:8080/employee/count")
            .then(data=>this.field=data.data);
            console.log(body)

        }
    }
    
}
</script>

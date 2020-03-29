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
            axios.get(process.env.API_URL + "/employee/count")
            .then(data=>this.field=data.data);
            console.log(body)

        }
    }
    
}
</script>

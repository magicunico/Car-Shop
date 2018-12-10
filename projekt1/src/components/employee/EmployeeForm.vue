<template>
    <b-container fluid>
        <input v-model="name" placeholder="Name">
        <br>
        <input v-model="surname" placeholder="surname">
        <br>
        <input v-model="pesel" placeholder="pesel">
        <input v-model="address" placeholder="address">
        <input v-model="saary" placeholder="date">


    <button class="btn btn-success" @click="submit">Submit</button>
  </b-container>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){return body;},
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'surname' : this.surname,
                'pesel' : this.pesel,
                'address': this.address,
                'status': '1',
                'date': this.date
            }

            axios.post("http://localhost:8080/employee/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

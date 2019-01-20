<template>
    <b-form @submit="submit" :validated="true">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                    description="We'll never share your email with anyone else.">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="name"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add Producer</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            name:'',
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'status' : '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/producer/add",body)
            .catch(body => console.log(body))
            console.log(body)

        }
    }
    
}
</script>

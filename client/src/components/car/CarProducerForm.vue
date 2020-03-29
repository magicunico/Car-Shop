<template>
    <b-form @submit="submit" :validated="true">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                   >
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

            axios.post(process.env.API_URL + "/producer/add",body)
            .catch(body => console.log(body))
            console.log(body)

        }
    }
    
}
</script>

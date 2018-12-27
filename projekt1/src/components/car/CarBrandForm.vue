<template>
    <b-form @submit="submit">
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
      <b-form-group id="exampleInputGroup2"
                    label="producer:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="producer"
                      required
                      placeholder="Enter pesel">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add brand</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            name:'',
            producer:''
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'producer' : {
                    'id': this.producer
                },
                'status' : '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/brand/add",body)
            .catch(body => console.log(body))
            console.log(body)

        }
    }
    
}
</script>

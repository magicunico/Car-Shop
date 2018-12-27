<template>
    <b-form @submit="submit">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="name"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1"
                    label="surname:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="surname"
                      required
                      placeholder="Enter surname">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="Pesel:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="pesel"
                      required
                      placeholder="Enter pesel">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Address:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="address"
                      required
                      placeholder="Enter address">
        </b-form-input>
      </b-form-group>
       
    <b-button type="submit" variant="primary">Add Customer</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            name:'',
            surname:'',
            pesel:'',
            address:'',
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'surname' : this.surname,
                'pesel' : this.pesel,
                'address': this.address,
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/customer/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

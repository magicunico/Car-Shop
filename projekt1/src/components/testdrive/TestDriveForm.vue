
<template>
    <b-form @submit="submit">
      <b-form-group id="exampleInputGroup1"
                    label="Date:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="date"
                      required>
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="Employee:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="employee"
                      required
                      placeholder="Enter employee">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Address:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="customer"
                      required
                      placeholder="Enter customer">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="car:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="car"
                      required
                      placeholder="Enter car">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add testdrive</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            date:'',
            employee:'',
            customer:'',
            car:'',
        }
    },
    methods:{
        submit(){
            let body = {
                'date' : this.date,
                'employee' :{'id': this.employee},
                'customer' :{'id': this.customer},
                'car' :{'id': this.car},
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/testdrive/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

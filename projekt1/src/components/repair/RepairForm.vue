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
      <b-form-group id="exampleInputGroup2"
                    label="price:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="price"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="employee:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="employee"
                      required
                      placeholder="Enter employee id">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="car:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="number"
                      v-model="car"
                      required
                      placeholder="Enter car id">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            name:'',
            price:'',
            employee:'',
            car:'',
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'price' : this.price,
                'employee' :{'id':this.employee } ,
                'car': {'id': this.car},
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/repair/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

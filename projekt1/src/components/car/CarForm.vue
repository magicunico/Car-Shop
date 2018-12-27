<template>
    <b-form @submit="submit">
        <b-form-group id="exampleInputGroup1"
                    label="warehouse:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="warehouse"
                      required
                      placeholder="Enter warehouse id">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="brand"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="brand"
                      required
                      placeholder="Enter brand id">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1"
                    label="Color:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="color"
                      required
                      placeholder="Enter color">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="Price:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="number"
                      v-model="price"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Body:"
                    label-for="exampleInput1"
                    description="select one from: sedan, kombi, SUV, hatchback, kabriolet, liftback, pick-up, minivan ">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="body"
                      required
                      placeholder="Enter body">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="gearbox:"
                    label-for="exampleInput1"
                    description="enter one of: manual, auto">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="gearbox"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add car</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            color:'',
            price:'',
            body:'',
            gearbox:'',
            warehouse:'',
            brand:''
        }
    },
    methods:{
        submit(){
            let body = {
                'color' : this.color,
                'price' : this.price,
                'body' : this.body,
                'gearbox': this.gearbox,
                'warehouse': {
                    'id': this.warehouse},
                'brand': {
                    'id':this.brand
                    },
                'status':'1'
            }

            console.log(body);

            axios.post("http://localhost:8080/car/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

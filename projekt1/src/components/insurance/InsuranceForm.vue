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
                    label="starting:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="date"
                      v-model="starting"
                      required
                      placeholder="Enter pesel">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="ending:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="ending"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="price:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="number"
                      v-model="price"
                      required
                      placeholder="Enter price">
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
            starting:'',
            ending:'',
            price:'',
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'starting' : this.starting,
                'ending' : this.ending,
                'price': this.price,
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/insurance/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

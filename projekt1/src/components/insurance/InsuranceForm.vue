<template>
    <b-form @submit="submit" @keyup.enter="submit()" :validated="true">
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
                      v-model="form.price"
                      v-on:keydown.enter.prevent="submit"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
import { validationMixin } from "vuelidate";
import { and, between,numeric,required, minLength, maxLength,minValue,min } from "vuelidate/lib/validators";

export default {
    components:{axios},
    data(){
        return {
            name:'',
            starting:'',
            ending:'',
            price:'',
            form:{}
        }
    },
    mixins: [validationMixin],
  validations: {
    price: {
      date:{
        minValue:minValue(1) 
      }
    }
  },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'starting' : this.starting,
                'ending' : this.ending,
                'price': this.form.price,
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/insurance/add",body)
            .catch(error => {
              this.$notify({
                group:'foo',
                type:'error',
                title:'VERIFY DATES',
                text:"Dates need to be between 01-01-1990 <br />and 01-01-2100",
                closeOnClick:true,
                duration: 10000
              });
            })
            console.log(body)

        }
    }
    
}
</script>

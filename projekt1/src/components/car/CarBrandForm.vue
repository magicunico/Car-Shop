<template>
    <b-form @submit="submit">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                    description="We'll never share your email with anyone else.">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="form.name"
                       :state="!$v.form.name.$invalid"
                      placeholder="Enter name">
                       <b-form-invalid-feedback
            id="input1LiveFeedback"
          >This is a required field and must be at least 11 characters
          </b-form-invalid-feedback>
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="producer:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="form.producer"
                      :state="!$v.form.producer.$invalid"
                      placeholder="Enter producer id">
                       <b-form-invalid-feedback
            id="input1LiveFeedback"
          >This is a required field and must be at least 11 characters
          </b-form-invalid-feedback>
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add brand</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
import { validationMixin } from "vuelidate";
import { required } from "vuelidate/lib/validators";
export default {
    components:{axios},
    data(){
        return {
            name:'',
            producer:'',
            form:{}
        }
    },
    mixins: [validationMixin],
    validations:{
        form:{
            name:{
                required
            },
             producer:{
                 required
             }
        }
    },
    methods:{
        submit(){
            let body = {
                'name' : this.form.name,
                'producer' : {
                    'id': this.form.producer
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

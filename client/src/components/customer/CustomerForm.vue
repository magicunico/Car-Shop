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
      <b-form-group id="exampleInputGroup1"
                    label="Pesel:"
                    label-for="exampleInput2">
      <b-form-input
          id="exampleInput2"
          type="text"
           v-on:keydown.enter.prevent="submit"
          v-model="form.pesel"
          :state="!$v.form.pesel.$invalid"
          required
          placeholder="Enter pesel"
        >
          <b-form-invalid-feedback
            id="input1LiveFeedback"
          >This is a required field and must be at least 11 characters
          </b-form-invalid-feedback>
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
import { validationMixin } from "vuelidate";
import { and, between,numeric,required, minLength, maxLength,minValue,min } from "vuelidate/lib/validators";

export default {
    components:{axios},
    data(){
        return {
            name:'',
            surname:'',
            pesel:'',
            address:'',
            form:{}
        }
    },
    mixins: [validationMixin],
  validations: {
    form: {
      pesel: {
        and,
        numeric,
        required,
        maxLength: maxLength(11),
        minLength: minLength(11)
      },
    }
  },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'surname' : this.surname,
                'pesel' : this.form.pesel,
                'address': this.address,
                'status': '1'
            }

            console.log(body);

            axios.post(process.env.API_URL + "/customer/add",body)
            .catch(error => {
              this.$notify({
                group:'foo',
                type:'error',
                title:'VERIFY PESEL',
                text:"Customer with this pesel already exists <br /> <br /> All fields need to bee filled",
                closeOnClick:true,
                duration: 10000
              });
            })
            console.log(body)

        }
    }
    
}
</script>

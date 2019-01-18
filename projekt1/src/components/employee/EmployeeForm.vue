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
       <b-form-group id="exampleInputGroup2" label="Pesel:" label-for="exampleInput2">
        <b-form-input
          id="exampleInput2"
          type="text"
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
       <b-form-group id="exampleInputGroup1"
                    label="salary:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="number"
                      v-model="salary"
                      required
                      placeholder="Enter salary">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="date:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="form.date"
                      :state="!$v.form.date.$and"
                      required>
          <b-form-invalid-feedback
            id="input1LiveFeedback"
          >Date must by after 1.01.2000
          </b-form-invalid-feedback>
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Add employee</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
import { validationMixin } from "vuelidate";
import { and, numeric,required, minLength, maxLength } from "vuelidate/lib/validators";

export default {
    components:{axios},
    data(){
        return {
            name:'',
            surname:'',
            pesel:'',
            address:'',
            date:'',
            salary:'',
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
      date:{
        and,
        required,
        numeric
      }
    }
  },
    methods:{
        submit(){
            let body = {
                'name' : this.name,
                'surname' : this.surname,
                'pesel' : this.form.pesel,
                'address': this.address,
                'status': '1',
                'date': this.form.date,
                'salary':this.salary
            }

            console.log(body);

            axios.post("http://localhost:8080/employee/add",body)
            .catch(error => {
              
            })
            console.log(body)

        }
    }
    
}
</script>

<template>
    <b-form @submit="submit" @keyup.enter="submit()" >
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                       v-on:keydown.enter.prevent="submit"
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
                       v-on:keydown.enter.prevent="submit"
                      v-model="surname"
                      required
                      placeholder="Enter surname">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Address:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-on:keydown.enter.prevent="submit"
                      v-model="address"
                      required
                      placeholder="Enter address">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1"
                    label="date:"
                    label-for="exampleInput1"
                    description="Date must be after 01-01-1990"
                    >
                    
        <b-form-input id="exampleInput1"
                      type="date"
                       v-on:keydown.enter.prevent="submit"
                      v-model="form.date"
                      >
          <b-form-invalid-feedback
            id="input1LiveFeedback"
          >Date must by after 1.01.2000
          </b-form-invalid-feedback>
        </b-form-input>
      
      <b-form-group id="exampleInputGroup2" label="Pesel:" label-for="exampleInput2">
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
                    label="salary:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="number"
                      v-on:keydown.enter.prevent="submit"
                      v-model="form.salary"
                      :state="!$v.form.salary.$invalid"
                      required
                      placeholder="Enter salary">
        </b-form-input>
      </b-form-group>
      </b-form-group>
    <b-button type="submit" variant="primary">Add employee</b-button>
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
        name: 'between', params: { type: 'between', min: 2000, max: 2100 } 
      },
      salary:{
        and,
        numeric,
        required,
        minValue: minValue(1)
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
                'salary':this.form.salary
            }

            console.log(body);
            let config = {
                headers: {
                'Authorization': 'Bearer ' + localStorage.token
                }
            }

            axios.post(process.env.API_URL + "/employee/add",body,config)
            .catch(error => {
              this.$notify({
                group:'foo',
                type:'error',
                title:'VERIFY DATE AND PESEL',
                text:"Employee with this pesel may already exists or you picked date before 01-01-1990 <br /> <br /> All fields need to bee filled",
                closeOnClick:true,
                duration: 10000
              });
            })
            console.log(body)

        }
    }
    
}
</script>

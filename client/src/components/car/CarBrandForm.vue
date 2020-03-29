<template>
    <b-form @submit="submit" :validated="true">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      required
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
        <b-form-select id="exampleInput3"
                      :options="producers.map(a =>{return a.name})"
                      required
                      v-model="pro"
                      >
        </b-form-select>
      </b-form-group>
    <b-button type="submit" variant="primary">Add brand</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
import { validationMixin } from "vuelidate";
import { required, numeric } from "vuelidate/lib/validators";
export default {
    components:{axios},
    data(){
        return {
            name:'',
            producer:'',
             producers:[],
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
                 required,
                 numeric
             }
        }
    },
    methods:{
         getId(){
            let id = -1;
            let pom = this.pro.split(' ');
            console.log(pom[0])
            this.producers.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        submit(){
            let body = {
                'name' : this.form.name,
                'producer' : {
                    'id': this.getId()
                },
                'status' : '1'
            }

            console.log(body);

            axios.post(process.env.API_URL + "/brand/add",body)
            .catch(body => console.log(body))
            console.log(body)

        }
    },
     beforeMount() {
      axios
      .get(process.env.API_URL + "/producer/active")
      .then(data => (this.producers = data.data))
      .catch(error => console.error(error));
  }
    
}
</script>

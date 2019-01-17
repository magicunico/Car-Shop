
<template>
    <b-form @submit.prevent="submit" :validated="true">
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
        
        <b-form-select id="exampleInput3"
                      :options="employees.map(a =>{return a.name+' '+a.surname})"
                      required
                      v-model="employee"
                      >
        </b-form-select>
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
            employees:[],
            employeeId:'',
        }
    },
    methods:{
        getId(){
            let id = -1
            let pom = this.employee.split(' ');
            console.log(pom[0])
            this.employees.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        submit(){
            let body = {
                'date' : this.date,
                'employee' :{'id': this.getId()},
                'customer' :{'id': this.customer},
                'car' :{'id': this.car},
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/testdrive/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/employee/all")
        .then(data =>{
            this.employees = data.data;
        })
    }
    
}
</script>

<template>
    <b-form @submit.prevent="submit" @keyup.enter="submit()" :validated="true">
        <b-form-group id="exampleInputGroup1"
                    label="date:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="date"
                      v-on:keydown.enter.prevent="submit"
                      required>
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="payment"
                    label-for="exampleInput1">
        <b-form-radio-group id="exampleInput1"
                      :options="paymentMethods"
                      v-model="payment"
                      required
                      >
        </b-form-radio-group>
      </b-form-group>
      <b-form-group id="exampleInputGroup1"
                    label="place:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="place"
                      required
                      placeholder="Enter address">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Car:"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput1"
                     :options="cars.map(a =>{return a.id+' '+a.brand.name+' '+a.price})"
                      required
                      v-model="car">
        </b-form-select>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="customer:"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput1"
                      :options="customers.map(a =>{return a.name+' '+a.surname+' '+a.id})"
                      required
                      v-model="customer">
        </b-form-select>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="employee:"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput1"
                      :options="employees.map(a =>{return a.name+' '+a.surname+' '+a.id})"
                      required
                      v-model="employee">
        </b-form-select>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="insurance:"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput1"
                     :options="insurances.map(a =>{return a.name+' '+a.price+' '+ a.id})"
                      required
                      v-model="insurance">
        </b-form-select>
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
            date:'',
            payment:'',
            place:'',
            sum:'',
            car:'',
            customer:'',
            employee:'',
            insurance:'',
            cars:[],
            employees:[],
            customers:[],
            insurances:[],
            paymentMethods:['card','cash','check']
        }
    },
    methods:{
        getCar(){
            let id = -1;
            let pom = this.car.split(' ');
            console.log(pom[0])
            this.cars.forEach(element => {
                console.log(element.name);
                if(element.id == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        getEmp(){
            let id = -1;
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
         getCus(){
            let id = -1;
            let pom = this.customer.split(' ');
            console.log(pom[0])
            this.customers.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        getIns(){
            let id = -1;
            let pom = this.insurance.split(' ');
            console.log(pom[0])
            this.insurances.forEach(element => {
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
                'payment':this.payment,
                'place' : this.place,
                'sum' : this.sum,
                'car':{'id':this.getCar()},
                'customer':{'id':this.getCus()},
                'employee':{'id':this.getEmp()},
                'insurance':{'id':this.getIns()},
                'status':'1'
            }

            console.log(body);

            let config = {
                headers: {
                'Authorization': 'Bearer ' + localStorage.token
                }
            }

            axios.post(process.env.API_URL + "/transaction/add",body,config)
            .catch(error => { this.$notify({
                group:'foo',
                type:'error',
                title:'VERIFY DATE',
                text:"Date must be after 01-01-1990 <br /> <br /> All fields need to bee filled",
                closeOnClick:true,
                duration: 10000
              });
            })
            console.log(body)

        }
    },
    beforeMount(){
        axios
      .get(process.env.API_URL + "/customer/active")
      .then(data => (this.customers = data.data))
      .catch(error => console.error(error));
      axios
      .get(process.env.API_URL + "/car/active")
      .then(data => (this.cars = data.data))
      .catch(error => console.error(error));
      axios
      .get(process.env.API_URL + "/insurance/active")
      .then(data => (this.insurances = data.data))
      .catch(error => console.error(error));
      axios
      .get(process.env.API_URL + "/employee/active")
      .then(data => (this.employees = data.data))
      .catch(error => console.error(error));
    }
    
}
</script>

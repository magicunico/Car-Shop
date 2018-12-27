<template>
    <b-form @submit="submit">
        <b-form-group id="exampleInputGroup1"
                    label="date:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="date"
                      required>
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="payment"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="payment"
                      required
                      placeholder="Enter payment">
        </b-form-input>
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
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="car"
                      required
                      placeholder="Enter car">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="customer:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="customer"
                      required
                      placeholder="customer">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="employee:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="employee"
                      required
                      placeholder="employee">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="insurance:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="insurance"
                      required
                      placeholder="insurance">
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
            date:'',
            payment:'',
            place:'',
            sum:'',
            car:'',
            customer:'',
            employee:'',
            insurance:''
        }
    },
    methods:{
        submit(){
            let body = {
                'date' : this.date,
                'payment':this.payment,
                'place' : this.place,
                'sum' : this.sum,
                'car':{'id':this.car},
                'customer':{'id':this.customer},
                'employee':{'id':this.employee},
                'insurance':{'id':this.insurance},
                'status':'1'
            }

            console.log(body);

            axios.post("http://localhost:8080/transaction/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    }
    
}
</script>

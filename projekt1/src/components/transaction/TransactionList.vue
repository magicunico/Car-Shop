<template>
    <div class="container">
         <b-table margin-right:200px striped :items="transactions" :fields="fields" :hover="true" ref="table" id="tranactions-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteTransaction(data.item.id)"></span>
                   <span><img src="../../assets/edit.svg" @click="editTransaction(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateTransaction()">
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
    <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    components:{
        axios
    },
    data(){
        return{
            transactions:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'date',
                sortable:true
            },
            {
                key:'payment',
                sortable:true
            },
            {
                key:'place',
                sortable:false
            },
            {
                key:'sum',
                sortable:true
            },
            {
                key:'car.id',
                sortable:true
            },
            {
                key:'car.brand.name',
                sortable:true
            },
            {
                key:'car.color',
                sortable:true
            },
            {
                key:'customer.id',
                sortable:true
            },
            
            {
                key:'customer.surname',
                sortable:true
            },
            {
                key:'employee.id',
                sortable:true
            },
            
             {
                key:'employee.surname',
                sortable:true
            },
            {
                key:'insurance.id',
                sortable:true
            },
            {
                key:'insurance.name',
            },
            {
                key:"actions"
            }],
            edit:false,
            date:"",
            payment:"",
            place:"",
            sum:"",
            car:"",
            customer:"",
            employee:"",
            insurance:""
        }
    },
    methods:{
        filterList(list){
            let newList = new Array()
            for(let i=0;i<list.lenght;i++){
                list[i].date = list[i].date.trim(0,10)
                console.log(list[i].date)
                newList.push(list[i])
            }
            return newList
        },
        deleteTransaction(data){
            axios.delete("http://localhost:8080/transaction/delete/" + data);
            this.$root.$emit("bv::refresh::table", "transactions-list-table");
            this.$refs.table.refresh();
        },
        editTransaction(data){
            this.edit=true;
            axios.get("http://localhost:8080/transaction/"+data)
            .then(result=>{
                this.date=result.data.date;
                this.payment=result.data.payment;
                this.place=result.data.place;
                this.sum=result.data.sum;
                this.car=result.data.car.id;
                this.customer=result.data.customer.id;
                this.employee=result.data.employee.id;
                this.insurance=result.data.insurance.id;
            })
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/transaction/active")
        .then(data => this.transactions = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

<template>
    <div>
         <b-table striped :items="testDrives" :fields="fields" :hover="true" ref="table" id="testdrives-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteTestDrive(data.item.id)"></span>
                 <span><img src="../../assets/edit.svg" @click="editTestDrive(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateTestDrive()">
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
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="employee"
                      required
                      placeholder="Enter employee">
        </b-form-input>
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
            testDrives:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'date',
                sortable:true
            },
            {
                key:'employee.id',
                sortable:true
            },
            {
                key:'employee.surname'
            },
            {
                key:'customer.id',
                sortable:false
            },
            {
                key:'customer.surname',
                sortable:false
            },
            {
                key:'car.id',
                sortable:true
            },
            {
                key:'car.color',
                sortable:true
            },
            {
                key:'car.brand.name',
                sortable:true
            },
            {
                key:"actions"
            }],
            edit:false,
            date:"",
            employee:"",
            customer:"",
            car:""
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
    deleteTestDrive(data) {
      axios.delete("http://localhost:8080/testdrive/delete/" + data);
      this.$root.$emit("bv::refresh::table", "testdrives-list-table");
      this.$refs.table.refresh();
    },
    editTestDrive(data){
        this.edit=true;
        axios.get("http://localhost:8080/testdrive/"+data)
        .then(result=>{
            this.date=result.data.date;
            this.employee=result.data.employee.id;
            this.customer=result.data.customer.id;
            this.car=result.data.car.id;
        })
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/testdrive/active")
        .then(data => this.testDrives = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

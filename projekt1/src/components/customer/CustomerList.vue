<template>
    <div>
        <b-table striped :items="customer" :fields="fields" :hover="true" ref="table" id="customer-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteCustomer(data.item.id)"></span>
                 <span><img src="../../assets/edit.svg" @click="editCustomer(data.item.id)"></span>
             </template>
         </b-table>
     <b-form v-else @submit="updateCustomer">
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
      <b-form-group id="exampleInputGroup2"
                    label="Pesel:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="pesel"
                      required
                      placeholder="Enter pesel">
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
       
    <b-button type="submit" variant="primary">Edit Customer</b-button>
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
            customer:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:'surname',
                sortable:true
            },
            {
                key:'pesel',
                sortable:false
            },
            {
                key:'address',
                sortable:true
            },
            {
                key: "actions" 
            }
        ],
        edit:false,
        name: "",
        surname:"",
        pesel:"",
        address:""
        };
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
     deleteCustomer(data) {
      axios.delete("http://localhost:8080/customer/delete/" + data);
      this.$root.$emit("bv::refresh::table", "customer-list-table");
      this.$refs.table.refresh();
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/customer/active")
        .then(data => this.customer = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

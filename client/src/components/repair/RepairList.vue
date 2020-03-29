<template>
    <div>
        <b-form-group horizontal label="Search" v-if="!edit" class="mb-0">
      <b-input-group>
        <b-form-input v-model="filter" placeholder="Type to Search"/>
        <b-input-group-append>
          <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
        </b-input-group-append>
      </b-input-group>
    </b-form-group>
         <b-table striped hover :items="repairs" :fields="fields" :filter="filter"   v-if="!edit" ref="repairs" id="repairs-list">
         <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteRepair(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editRepair(data.item.id)">
        </span>
      </template>
      </b-table>
       <b-form v-else @submit="updateRepair()">
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
      <b-form-group id="exampleInputGroup2"
                    label="price:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="number"
                      v-model="price"
                      required
                      placeholder="Enter price">
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
            carses:[],
            carname:"",
            employ:"",
            employees:[],
            repairs:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:'price',
                sortable:true
            },
            {
                label:'employee',
                key:'employee.id',
                sortable:false
            },
             {
                label:'employee',
                key:'employee.name',
                sortable:false
            },
             {
                label:'employee',
                key:'employee.surname',
                sortable:false
            },
            {
                label:'car',
                key:'car.id',
                sortable:false
            },
             {
                label:'producer',
                key:'car.brand.producer.name',
                sortable:false
            },
             {
                label:'brand',
                key:'car.brand.name',
                sortable:false
            },
            {
                key:'actions'
            }],
            edit:false,
            name:"",
            price:"",
            employee:"",
            car:"",
            filter:""
        }
    },
    methods:{
        deleteRepair(data) {
      axios.delete(process.env.API_URL + "/repair/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editRepair(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/repair/" + data).then(result => {
        this.name = result.data.name;
        this.price=result.data.price;
        this.employee=result.data.employee.id;
        this.car=result.data.car.id;
        this.id = result.data.id;
        this.employ=result.data.employee.name;
      });
    },
    updateRepair() {
      let body = {
        name: this.name,
        employee: {id:this.employee},
        car: {id: this.car},
        price: this.price,
        status: "1",
        id: this.id
      };

      axios.put(process.env.API_URL + "/repair/update", body);
    }
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/repair/active")
        .then(data => this.repairs = data.data)
        .catch(error => console.error(error));
         axios
      .get(process.env.API_URL + "/employee/active")
      .then(data => (this.employees = data.data))
      .catch(error => console.error(error));
      axios
      .get(process.env.API_URL + "/car/active")
      .then(data => {this.carses = data.data;
      console.log(data)})
      .catch(error => console.error(error));
    }
    
}
</script>

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
    <b-table
      striped
      :items="testDrives"
      :fields="fields"
      :hover="true"
      ref="table"
      id="testdrives-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
         <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteTestDrive(data.item.id)">
        </span>
        <!-- <span>
          <img src="../../assets/edit.svg" @click="editTestDrive(data.item.id)">
        </span> -->
      </template>
    </b-table>
    <b-form v-else @submit="updateTestDrive()">
      <b-form-group id="exampleInputGroup1" label="Date:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="date" v-model="date" required></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2" label="Employee:" label-for="exampleInput2">
         <b-form-select id="exampleInput3"
                      :options="employees.map(a =>{return a.name+' '+a.surname})"
                      required
                      v-model="employee"
                      >
        </b-form-select>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="Customer:" label-for="exampleInput1">
        <b-form-select
          :options="customers.map(a =>{return a.name+' '+a.surname})"
                      required
                      v-model="customer">
        </b-form-select>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="car:" label-for="exampleInput1">
        <b-form-input 
        id="exampleInput1" 
        type="text" 
        v-model="car" required placeholder="Enter car"></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  components: {
    axios
  },
  data() {
    return {
      testDrives: [],
      fields: [
        {
          key: "id",
          sortable: true
        },
        {
          key: "date",
          sortable: true
        },
        {
          key: "employee.id",
          sortable: true
        },
        {
          key: "employee.surname"
        },
        {
          key: "customer.id",
          sortable: false
        },
        {
          key: "customer.surname",
          sortable: false
        },
        {
          key: "car.id",
          sortable: true
        },
        {
          key: "car.color",
          sortable: true
        },
        {
          key: "car.brand.name",
          sortable: true
        },
        {
          key: "actions"
        }
      ],
      edit: false,
      date: "",
      employee: "",
      customer: "",
      car: "",
      id: "",
      filter:"",
      employees:[],
      customers:[]
    };
  },
  methods: {
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
        getIdid(){
            let id = -1
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
    deleteTestDrive(data) {
                  let config = {
                headers: {
                'Authorization': 'Bearer ' + localStorage.token
                }
            }

      axios.delete(process.env.API_URL + "/testdrive/delete/" + data,config)
      .then(()=>{
          this.$router.go();
      })
    },
    editTestDrive(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/testdrive/" + data).then(result => {
        this.date = new Date(result.data.date)
          .toLocaleDateString("ko-KR")
          .replace(" ", "")
          .replace(" ", "")
          .replace(".", "-")
          .replace(".", "-")
          .replace(".", "");
        this.employee = result.data.employee.id;
        this.customer = result.data.customer.id;
        this.car = result.data.car.id;
        this.id = result.data.id;
      });
    },
    updateTestDrive() {
      let body = {
        id: this.id,
        date: this.date,
        employee: {
          id: this.getId()
        },
        customer: {
          id: this.getIdid()
        },
        car: {
          id: this.car
        },
        status: "1"
      };
                  let config = {
                headers: {
                'Authorization': 'Bearer ' + localStorage.token
                }
            }

      axios.put(process.env.API_URL + "/testdrive/update", body,config);
    },
    test(data) {
      let i = 0;
      data.forEach(element => {
        this.testDrives[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
  },
  beforeMount() {
  axios
      .get(process.env.API_URL + "/testdrive/active")
      .then(data => {
        this.testDrives = data.data;
        this.test(this.testDrives);
      })
      .catch(error => console.error(error));
      axios.get(process.env.API_URL + "/employee/active")
        .then(data =>{
            this.employees = data.data;
        });
        axios.get(process.env.API_URL + "/customer/active")
        .then(data =>{
            this.customers = data.data;
        })
  }
};
</script>

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
          <img src="../../assets/delete.svg" @click.prevent="deleteTestDrive(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editTestDrive(data.item.id)">
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateTestDrive()">
      <b-form-group id="exampleInputGroup1" label="Date:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="date" v-model="date" required></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2" label="Employee:" label-for="exampleInput2">
        <b-form-input
          id="exampleInput2"
          type="text"
          v-model="employee"
          required
          placeholder="Enter employee"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="Address:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="customer"
          required
          placeholder="Enter customer"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="car:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="text" v-model="car" required placeholder="Enter car"></b-form-input>
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
      filter:""
    };
  },
  methods: {
    
    deleteTestDrive(data) {
      axios.delete("http://localhost:8080/testdrive/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editTestDrive(data) {
      this.edit = true;
      axios.get("http://localhost:8080/testdrive/" + data).then(result => {
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
          id: this.employee
        },
        customer: {
          id: this.customer
        },
        car: {
          id: this.car
        },
        status: "1"
      };
      axios.put("http://localhost:8080/testdrive/update", body);
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
      .get("http://localhost:8080/testdrive/active")
      .then(data => {
        this.testDrives = data.data;
        this.test(this.testDrives);
      })
      .catch(error => console.error(error));
  }
};
</script>

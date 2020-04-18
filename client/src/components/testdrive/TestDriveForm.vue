
<template>
  <b-form @submit="submit" @keyup.enter="submit" :validated="true">
    <b-form-group id="exampleInputGroup1" label="Date:" label-for="exampleInput1">
      <b-form-input
        id="exampleInput1"
        type="date"
        v-model="date"
        v-on:keydown.enter.prevent="submit"
        required
      ></b-form-input>
    </b-form-group>
    <b-form-group id="exampleInputGroup2" label="Employee:" label-for="exampleInput2">
      <b-form-select
        id="exampleInput3"
        :options="employees.map(a =>{return a.name+' '+a.surname})"
        required
        v-model="employee"
      ></b-form-select>
    </b-form-group>
    <b-form-group id="exampleInputGroup1" label="Customer:" label-for="exampleInput1">
      <b-form-select
        id="exampleInput1"
        :options="customers.map(a =>{return a.name+' '+a.surname})"
        required
        v-model="customer"
      ></b-form-select>
    </b-form-group>
    <b-form-group id="exampleInputGroup1" label="car:" label-for="exampleInput1">
      <b-form-select
        id="exampleInput1"
        :options="cars.map(a =>{return a.id+' '+a.color})"
        required
        v-model="car"
      ></b-form-select>
    </b-form-group>
    <b-button type="submit" variant="primary">Add testdrive</b-button>
  </b-form>
</template>
<script>
import axios from "axios";
export default {
  components: { axios },
  data() {
    return {
      date: "",
      employee: "",
      customer: "",
      car: "",
      employees: [],
      employeeId: "",
      employ: "",
      customers: [],
      cars: []
    };
  },
  methods: {
    getId() {
      let id = -1;
      let pom = this.employee.split(" ");
      console.log(pom[0]);
      this.employees.forEach(element => {
        console.log(element.name);
        if (element.name == pom[0]) {
          id = element.id;
        }
      });
      return id;
    },
    getIdCus() {
      let id = -1;
      let pom = this.customer.split(" ");
      console.log(pom[0]);
      this.customers.forEach(element => {
        console.log(element.name);
        if (element.name == pom[0]) {
          id = element.id;
        }
      });
      return id;
    },
    getIdCar() {
      let id = -1;
      let pom = this.car.split(" ");
      console.log(pom[0]);
      this.cars.forEach(element => {
        console.log(element.id);
        if (element.id == pom[0]) {
          id = element.id;
        }
      });
      return id;
    },
    submit() {
      let body = {
        date: this.date,
        employee: { id: this.getId() },
        customer: { id: this.getIdCus() },
        car: { id: this.getIdCar() },
        status: "1"
      };

      console.log(body);
      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios
        .post(process.env.API_URL + "/testdrive/add", body, config)
        .catch(error => {
          this.$notify({
            group: "foo",
            type: "error",
            title: "VERIFY DATE",
            text:
              "Date can't be before 01-01-1990 <br /> <br /> All fields need to bee filled",
            closeOnClick: true,
            duration: 10000
          });
        });
      console.log(body);
    }
  },
  beforeMount() {
    axios.get(process.env.API_URL + "/employee/active").then(data => {
      this.employees = data.data;
    });
    axios.get(process.env.API_URL + "/customer/active").then(data => {
      this.customers = data.data;
    });
    axios.get(process.env.API_URL + "/car/active").then(data => {
      this.cars = data.data;
    });
  }
};
</script>

<template>
  <div class="container">
    <b-form-group horizontal label="Search" v-if="!edit" class="mb-0">
      <b-input-group>
        <b-form-input v-model="filter" placeholder="Type to Search"/>
        <b-input-group-append>
          <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
        </b-input-group-append>
      </b-input-group>
    </b-form-group>
    <b-table
      margin-right:200px
      striped
      :items="transactions"
      :fields="fields"
      :hover="true"
      ref="table"
      id="tranactions-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteTransaction(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editTransaction(data.item.id)">
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateTransaction()" :validated="true">
      <b-form-group id="exampleInputGroup1" label="payment" label-for="exampleInput1">
        <b-form-radio-group id="exampleInput1" :options="paymentMethods" v-model="payment" required></b-form-radio-group>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="place:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="place"
          required
          placeholder="Enter address"
        ></b-form-input>
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
      transactions: [],
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
          key: "payment",
          sortable: true
        },
        {
          key: "place",
          sortable: false
        },
        {
          key: "sum",
          sortable: true
        },
        {
          label: "Car",
          key: "car.id",
          sortable: true
        },
        {
          label: "Brand",
          key: "car.brand.name",
          sortable: true
        },
        {
          label: "Color",
          key: "car.color",
          sortable: true
        },
        {
          label: "Producer",
          key: "car.brand.producer.name"
        },
        {
          label: "Customer",
          key: "customer.id",
          sortable: true
        },
        {
          label: "Name",
          key: "customer.name"
        },
        {
          label: "Surname",
          key: "customer.surname",
          sortable: true
        },
        {
          label: "Employee",
          key: "employee.id",
          sortable: true
        },
        {
          label: "Name",
          key: "employee.name"
        },
        {
          label: "Surname",
          key: "employee.surname",
          sortable: true
        },
        {
          label: "Insurance",
          key: "insurance.id",
          sortable: true
        },
        {
          label: "Type",
          key: "insurance.name"
        },
        {
          key: "actions"
        }
      ],
      edit: false,
      date: "",
      payment: "",
      place: "",
      sum: "",
      car: "",
      customer: "",
      employee: "",
      insurance: "",
      id: "",
      carEmp:"",
      filter: "",
      cars:[],
            employees:[],
            customers:[],
            insurances:[],
            paymentMethods:['card','cash','check']
    };
  },
  methods: {
   
    deleteTransaction(data) {
      axios
        .delete(process.env.API_URL + "/transaction/delete/" + data)
        .then(() => {
          this.$router.go();
        });
    },
    editTransaction(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/transaction/" + data).then(result => {
        this.date = new Date(result.data.date)
          .toLocaleDateString("ko-KR")
          .replace(" ", "")
          .replace(" ", "")
          .replace(".", "-")
          .replace(".", "-")
          .replace(".", "");
        this.payment = result.data.payment;
        this.place = result.data.place;
        this.sum = result.data.sum;
        this.car = result.data.car.id;
        this.customer = result.data.customer.id;
        this.employee = result.data.employee.id;
        this.insurance = result.data.insurance.id;
        this.id = result.data.id;
      });
    },
    updateTransaction() {
      let body = {
        id: this.id,
        status: "1",
        date: this.date,
        payment: this.payment,
        place: this.place,
        sum: this.sum,
        car: {
          id: this.car
        },
        customer: {
          id: this.customer
        },
        employee: {
          id: this.employee
        },
        insurance: {
          id: this.insurance
        }
      };
      axios.put(process.env.API_URL + "/transaction/update", body);
    },
    test(data) {
      let i = 0;
      data.forEach(element => {
        this.transactions[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
  },
  beforeMount() {
    axios
      .get(process.env.API_URL + "/transaction/active")
      .then(data => {
        this.transactions = data.data;
        this.test(this.transactions);
      })
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
};
</script>
<style>
.container {
  margin-left: 40px;
}
.mb-0 {
  margin-left: 350px;
}
</style>


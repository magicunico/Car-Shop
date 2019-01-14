<template>
  <div class="container">
    <b-table
      margin-right:200px
      striped
      :items="transactions"
      :fields="fields"
      :hover="true"
      ref="table"
      id="tranactions-list-table"
      v-if="!edit"
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
    <b-form v-else @submit="updateTransaction()">
      <b-form-group id="exampleInputGroup1" label="date:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="date" v-model="date" required></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="payment" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="payment"
          required
          placeholder="Enter payment"
        ></b-form-input>
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
      <b-form-group id="exampleInputGroup1" label="Car:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="text" v-model="car" required placeholder="Enter car"></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="customer:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="customer"
          required
          placeholder="customer"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="employee:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="employee"
          required
          placeholder="employee"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="insurance:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="insurance"
          required
          placeholder="insurance"
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
          key: "car.id",
          sortable: true
        },
        {
          key: "car.brand.name",
          sortable: true
        },
        {
          key: "car.color",
          sortable: true
        },
        {
          key: "customer.id",
          sortable: true
        },

        {
          key: "customer.surname",
          sortable: true
        },
        {
          key: "employee.id",
          sortable: true
        },

        {
          key: "employee.surname",
          sortable: true
        },
        {
          key: "insurance.id",
          sortable: true
        },
        {
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
      id: ""
    };
  },
  methods: {
    
    deleteTransaction(data) {
      axios.delete("http://localhost:8080/transaction/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editTransaction(data) {
      this.edit = true;
      axios.get("http://localhost:8080/transaction/" + data).then(result => {
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
    updateTransaction(){
        let body={
            id: this.id,
            status:"1",
            date: this.date,
            payment:this.payment,
            place: this.place,
            sum: this.sum,
            car:{
                id: this.car
            },
            customer:{
                id: this.customer
            },
            employee:{
                id: this.employee
            },
            insurance:{
                id: this.insurance
            }
        };
        axios.put("http://localhost:8080/transaction/update",body);
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
      .get("http://localhost:8080/transaction/active")
      .then(data => {
        this.transactions = data.data;
        this.test(this.transactions);
      })
      .catch(error => console.error(error));
  }
};
</script>

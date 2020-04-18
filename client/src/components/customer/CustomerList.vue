<template>
  <div>
    <b-form-group horizontal label="Search" v-if="!edit" class="mb-0">
      <b-input-group>
        <b-form-input v-model="filter" placeholder="Type to Search" />
        <b-input-group-append>
          <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
        </b-input-group-append>
      </b-input-group>
    </b-form-group>
    <b-table
      striped
      :items="customer"
      :fields="fields"
      :hover="true"
      ref="table"
      id="customer-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteCustomer(data.item.id)" />
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editCustomer(data.item.id)" />
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateCustomer()">
      <b-form-group id="exampleInputGroup1" label="Name:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="name"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="surname:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="surname"
          required
          placeholder="Enter surname"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2" label="Pesel:" label-for="exampleInput2">
        <b-form-input
          id="exampleInput2"
          type="text"
          v-model="pesel"
          required
          placeholder="Enter pesel"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="Address:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="address"
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
      customer: [],
      fields: [
        {
          key: "id",
          sortable: true
        },
        {
          key: "name",
          sortable: true
        },
        {
          key: "surname",
          sortable: true
        },
        {
          key: "pesel",
          sortable: false
        },
        {
          key: "address",
          sortable: true
        },
        {
          key: "actions"
        }
      ],
      edit: false,
      name: "",
      surname: "",
      pesel: "",
      address: "",
      id: "",
      filter: ""
    };
  },
  methods: {
    deleteCustomer(data) {
      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios.delete(process.env.API_URL + "/customer/delete/" + data, config);
      //   .then(()=>{
      //     //   this.$refs.table.refresh();
      //     //   this.$router.go();
      //   });
      this.$refs.table.refresh();
      this.$router.go();
    },
    editCustomer(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/customer/" + data).then(result => {
        this.name = result.data.name;
        this.surname = result.data.surname;
        this.pesel = result.data.pesel;
        this.address = result.data.address;
        this.id = result.data.id;
      });
    },
    updateCustomer() {
      let body = {
        id: this.id,
        status: "1",
        name: this.name,
        surname: this.surname,
        pesel: this.pesel,
        address: this.address
      };
      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios.put(process.env.API_URL + "/customer/update", body, config);
      console.log(body);
    }
  },
  beforeMount() {
    axios
      .get(process.env.API_URL + "/customer/active")
      .then(data => (this.customer = data.data))
      .catch(error => console.error(error));
  }
};
</script>

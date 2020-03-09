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
      :items="insurances"
      :fields="fields"
      :hover="true"
      ref="table"
      id="insurance-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteInsurance(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editInsurance(data.item.id)">
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateInsurance()">
      <b-form-group id="exampleInputGroup1" label="Name:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="name"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2" label="starting:" label-for="exampleInput2">
        <b-form-input
          id="exampleInput2"
          type="date"
          v-model="starting"
          required
          placeholder="Enter pesel"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="ending:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="date"
          v-model="ending"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="price:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="number"
          v-model="price"
          required
          placeholder="Enter price"
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Submit</b-button>
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
      insurances: [],
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
          key: "starting",
          sortable: true
        },
        {
          key: "ending",
          sortable: false
        },
        {
          key: "price",
          sortable: false
        },
        {
          key: "actions"
        }
      ],
      edit: false,
      name: "",
      starting: "",
      startingdate: "",
      ending: "",
      price: "",
      id: "",
      filter:""
    };
  },
  methods: {
   
    deleteInsurance(data) {
      axios.delete("http://localhost:8080/insurance/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editInsurance(data) {
      this.edit = true;
      axios.get("http://localhost:8080/insurance/" + data).then(result => {
        this.name = result.data.name;
        this.starting= new Date(result.data.starting)
          .toLocaleDateString("ko-KR")
          .replace(" ", "")
          .replace(" ", "")
          .replace(".", "-")
          .replace(".", "-")
          .replace(".", "");
        this.ending = new Date(result.data.ending)
          .toLocaleDateString("ko-KR")
          .replace(" ", "")
          .replace(" ", "")
          .replace(".", "-")
          .replace(".", "-")
          .replace(".", "");
        this.price = result.data.price;
        this.id = result.data.id;
      });
    },
    updateInsurance() {
      let body = {
        id: this.id,
        status: "1",
        name: this.name,
        starting: this.starting,
        ending: this.ending,
        price: this.price
      };
      axios.put("http://localhost:8080/insurance/update/", body);
      console.log(body);
    },
    test(data) {
      let i = 0;
      data.forEach(element => {
        this.insurances[i].starting = new Date(element.starting).toLocaleDateString(
          "en-GB"
        );
        this.insurances[i].ending = new Date(element.ending).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
  },
  beforeMount() {
    axios
      .get("http://localhost:8080/insurance/active")
      .then(data => {
        this.insurances = data.data;
        this.test(this.insurances);})
      .catch(error => console.error(error));
  }
};
</script>

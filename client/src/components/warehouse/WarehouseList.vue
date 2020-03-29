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
      :items="warehouses"
      :fields="fields"
      :hover="true"
      ref="table"
      id="warehouses-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteWarehouse(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editWarehouse(data.item.id)">
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateWarehouse()">
      <b-form-group id="exampleInputGroup1" label="Name:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="name"
          required
          placeholder="Enter name"
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
      warehouses: [],
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
          key: "actions"
        }
      ],
      edit: false,
      name: "",
      id: "",
      filter:""
    };
  },
  methods: {
    
    deleteWarehouse(data) {
      axios.delete(process.env.API_URL + "/warehouse/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editWarehouse(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/warehouse/" + data).then(result => {
        this.name = result.data.name;
        this.id = result.data.id;
      });
    },
    updateWarehouse() {
      let body = {
        name: this.name,
        status: "1",
        id: this.id
      };

      axios.put(process.env.API_URL + "/warehouse/update", body);
    }
  },
  beforeMount() {
    axios
      .get(process.env.API_URL + "/warehouse/active")
      .then(data => (this.warehouses = data.data))
      .catch(error => console.error(error));
  }
};
</script>

<template>
  <div>
    <b-table
      striped
      :items="warehouses"
      :fields="fields"
      :hover="true"
      ref="table"
      id="warehouses-list-table"
      v-if="!edit"
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
      <b-form-group id="exampleInputGroup1" label="Id:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="text" v-model="id" required placeholder="Enter name"></b-form-input>
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
      id: ""
    };
  },
  methods: {
    filterList(list) {
      let newList = new Array();
      for (let i = 0; i < list.lenght; i++) {
        list[i].date = list[i].date.trim(0, 10);
        console.log(list[i].date);
        newList.push(list[i]);
      }
      return newList;
    },
    deleteWarehouse(data) {
      axios.delete("http://localhost:8080/warehouse/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editWarehouse(data) {
      this.edit = true;
      axios.get("http://localhost:8080/warehouse/" + data).then(result => {
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

      axios.put("http://localhost:8080/warehouse/update", body);
    }
  },
  beforeMount() {
    axios
      .get("http://localhost:8080/warehouse/active")
      .then(data => (this.warehouses = data.data))
      .catch(error => console.error(error));
  }
};
</script>

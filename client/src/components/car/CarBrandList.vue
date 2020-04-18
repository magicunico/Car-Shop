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
      :items="brand"
      :fields="fields"
      :hover="true"
      ref="tableBrand"
      id="brand-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteBrand(data.item.id)" />
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editBrand(data.item.id)" />
        </span>
      </template>
    </b-table>
    <b-form v-else @click="updateBrand()" @keyup.space="updateBrand()">
      <b-form-group id="exampleInputGroup1" label="Name:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="text"
          v-model="form.name"
          required
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2" label="producer:" label-for="exampleInput2">
        <b-form-select
          id="exampleInput3"
          :options="producers.map(a =>{return a.name})"
          required
          v-model="pro"
        ></b-form-select>
      </b-form-group>
      <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
  </div>
</template>
<script>
import axios from "axios";
import CarBrandAll from "@/components/car/CarBrandAll";
import { validationMixin } from "vuelidate";
import {
  and,
  numeric,
  required,
  minLength,
  maxLength
} from "vuelidate/lib/validators";

export default {
  components: {
    axios
  },
  data() {
    return {
      brand: [],
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
          key: "producer.id"
        },
        {
          key: "producer.name"
        },
        {
          key: "actions"
        }
      ],
      edit: false,
      name: "",
      producer: "",
      id: "",
      filter: "",
      pro: "",
      producers: [],
      form: {}
    };
  },
  mixins: [validationMixin],
  validations: {
    form: {
      name: {
        required
      }
    }
  },
  methods: {
    getId() {
      let id = -1;
      let pom = this.pro.split(" ");
      console.log(pom[0]);
      this.producers.forEach(element => {
        console.log(element.name);
        if (element.name == pom[0]) {
          id = element.id;
        }
      });
      return id;
    },

    deleteBrand(data) {
      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios
        .delete(process.env.API_URL + "/brand/delete/" + data, config)
        .then(() => {
          this.$refs.tableBrand.refresh();
          this.$router.go();
        });
    },
    editBrand(data) {
      this.edit = true;
      axios.get(process.env.API_URL + "/brand/" + data).then(result => {
        this.form.name = result.data.name;
        this.producer = result.data.producer.id;
        this.pro = result.data.producer.name;
        this.id = result.data.id;
      });
    },
    updateBrand() {
      let body = {
        id: this.id,
        name: this.form.name,
        status: "1",
        producer: {
          id: this.getId()
        }
      };

      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios.put(process.env.API_URL + "/brand/update", body, config);
      //   .catch(error=>
      // {
      //   this.$notify({
      //     group:'foo',
      //     title:'Imp',
      //     text:error,
      //     closeOnClick:10000
      //   });
      //})
      //.then(()=>{this.updateupdate})

      console.log(body);
    },
    updateupdate(body) {
      let config = {
        headers: {
          Authorization: "Bearer " + localStorage.token
        }
      };

      axios
        .put(process.env.API_URL + "/brand/update", body, config)
        .then(() => {
          this.$refs.refresh();
        });
    }
  },
  beforeMount() {
    axios
      .get(process.env.API_URL + "/brand/active")
      .then(data => (this.brand = data.data))
      .catch(error => console.error(error));
    axios
      .get(process.env.API_URL + "/producer/active")
      .then(data => (this.producers = data.data))
      .catch(error => console.error(error));
  }
};
</script>

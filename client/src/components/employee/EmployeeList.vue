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

   <table ref="hiring">
    
      <tr>
            <td colspan="10" height=20px></td>
     </tr>
      <td scope="col">
        
      </td>
      <td scope="col">
        You hiring 
      </td>
      <td scope="col">
                         
      </td>
      <td scope="col" v-text="hiredd">
        
      </td>
      <td scope="col">
        
      </td>
      <td scope="col">
        employees at this moment.
      </td>
       <tr>
            <td colspan="10" height=20px></td>
     </tr>
    </table>

    <b-table
      striped
      :items="employees"
      :fields="fields"
      :hover="true"
      ref="tableEmp"
      id="employee-list-table"
      v-if="!edit"
      :filter="filter"
    >
      <template slot="actions" slot-scope="row">
        <b-button @click="pomFoo(row.item.id)">Promote</b-button>
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click="deleteEmployee(row.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editEmployee(row.item.id)">
        </span>
      </template>
    </b-table>

    <b-form-group v-if="showField">
      <b-input type="text" id="promote-input" v-model="promoteValue"></b-input>
      <b-button v-if="showField" @click="promote(promoteValue)">Accept</b-button>
    </b-form-group>

    <b-form v-if="edit" @submit="updateEmployee" @keyup.space="updateEmployee">
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
          v-model="form.pesel"
          placeholder="Enter pesel"
        >
          <b-form-invalid-feedback
            id="input1LiveFeedback"
          >This is a required field and must be at least 11 characters
          </b-form-invalid-feedback>
        </b-form-input>
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
      <b-form-group id="exampleInputGroup1" label="salary:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="number"
          v-model="salary"
          required
          placeholder="Enter salary"
        >
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="date:" label-for="exampleInput1">
        <b-form-input 
        id="exampleInput1" 
        type="date"
         v-model="date" 
         required>
         </b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
    
  </div>
</template>
<script>
import axios from "axios";
import { validationMixin } from "vuelidate";
import { required,and,numeric, minLength, maxLength } from "vuelidate/lib/validators";
export default {
  components: {
    axios
  },
  data() {
    return {
      hiredd:"",
      employees: [],
      hired: [],
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
          key: "date",
          sortable: false
        },
        {
          key: "address",
          sortable: true
        },
        {
          key: "salary",
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
      date: "",
      salary: "",
      id: "",
      showField: false,
      promoteValue: "",
      promoteId: "",
      error: "",
      form: {},
      filter: ""
    };
  },
  mixins: [validationMixin],
  validations: {
    form: {
      pesel: {
        required,
        and,
        maxLength: maxLength(11),
        minLength: minLength(11),
        numeric
      }
    }
  },
  methods: {
    hiredEmp(){
        axios.get("http://localhost:8080/employee/hired")
      .then(data=> this.hiredd=data.data);
       this.$refs.hiring.refresh();
       this.$router.go()
    },
    promote(data) {
      let body = {
        employee: this.promoteId,
        howmuch: data
      };
      axios.post("http://localhost:8080/employee/promote/", body).then(data => {
        this.showField = false;
      });
      this.$refs.tableEmp.refresh();
      this.$router.go();
    },
    pomFoo(id) {
      this.showField = true;
      this.promoteId = id;
    },
    deleteEmployee(data) {
      axios.delete("http://localhost:8080/employee/delete/" + data).then(() => {
        //this.$refs.tableEmp.refresh();
        this.$router.go();
      });
    },
    editEmployee(data) {
      this.edit = true;
      axios
        .get("http://localhost:8080/employee/" + data)
        .then(result => {
          this.name = result.data.name;
          this.surname = result.data.surname;
          this.form.pesel = result.data.pesel;
          this.address = result.data.address;
          this.date = new Date(result.data.date)
            .toLocaleDateString("ko-KR")
            .replace(". ", "-")
            .replace(". ", "-")
            .replace(".", "");
          this.salary = result.data.salary;
          this.id = result.data.id;
        })
        .catch(error => {
          console.log("DUPA");
          this.$notify({
            group: "foo",
            title: "Error found",
            text: error,
            type: "Error"
          });
          this.$refs.tableEmp.refresh();
        });
      console.log(this.date);
    },
    test(data) {
      let i = 0;
      data.forEach(element => {
        this.employees[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    },
    updateEmployee() {
      let body = {
        id: this.id,
        status: "1",
        name: this.name,
        surname: this.surname,
        pesel: this.form.pesel,
        address: this.address,
        date: this.date,
        salary: this.salary
      };
      axios.put("http://localhost:8080/employee/update", body).catch(error => {
        console.log(error);
        this.error = error;
        this.$notify({
          group: "foo",
          title: "Error found",
          text: "Incorrect field values, please chceck pesel",
          type: "Error"
        });
        this.$refs.tableEmp.refresh();
      });
    },
    showDetails() {}
  },
  beforeMount() {
    axios
      .get("http://localhost:8080/employee/active")
      .then(data => {
        this.employees = data.data;
        this.test(this.employees);
        console.log(data);
      })
      .catch(error => console.error(error));
      axios.get("http://localhost:8080/employee/hired")
      .then(data=> this.hiredd=data.data);
      
  }
};
</script>

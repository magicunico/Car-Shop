<template>
  <div>
    <b-form-input id="filter-search" placeholder="Type to Search" @input="filterData" @change="filterData"/>
    <b-table
      striped
      :items="employees"
      :fields="fields"
      :hover="true"
      ref="table"
      id="employee-list-table"
      v-if="!edit"
      @filtered="onFiltered"
      :current-page="currentPage"
    >
      <template slot="actions" slot-scope="data">
        <span style="padding-left:20px;">
          <img src="../../assets/delete.svg" @click.prevent="deleteEmployee(data.item.id)">
        </span>
        <span>
          <img src="../../assets/edit.svg" @click="editEmployee(data.item.id)">
        </span>
      </template>
    </b-table>
    <b-form v-else @submit="updateEmployee">
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
      <b-form-group id="exampleInputGroup1" label="salary:" label-for="exampleInput1">
        <b-form-input
          id="exampleInput1"
          type="number"
          v-model="salary"
          required
          placeholder="Enter salary"
        ></b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1" label="date:" label-for="exampleInput1">
        <b-form-input id="exampleInput1" type="date" v-model="date" required></b-form-input>
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
      employees: [],
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
      id:"",
      backUpEmployees:[],
      fiter:null,
      totalRows:0,
      currentPage:1
    };
  },
  methods: {
    // filter(data){
    //   console.log(data);
    // },
    filterList(list) {
      let newList = new Array();
      for (let i = 0; i < list.lenght; i++) {
        list[i].date = list[i].date.trim(0, 10);
        newList.push(list[i]);
      }
      return newList;
    },
    deleteEmployee(data) {
      axios.delete("http://localhost:8080/employee/delete/" + data);
      // this.$root.$emit("bv::refresh::table", "employee-list-table");
      //this.$refs.table.refresh();
      this.$forceUpdate();
    },
    editEmployee(data) {
      this.edit = true;
      axios.get("http://localhost:8080/employee/" + data).then(result => {
        this.name = result.data.name;
        this.surname = result.data.surname;
        this.pesel = result.data.pesel;
        this.address = result.data.address;
        this.date = new Date(result.data.date)
          .toLocaleDateString("ko-KR")
          .replace(" ", "")
          .replace(" ", "")
          .replace(".", "-")
          .replace(".", "-")
          .replace(".", "");
        this.salary = result.data.salary;
        this.id=result.data.id;
      });
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
      let body={
        id:this.id,
        status:"1",
        name: this.name,
        surname: this.surname,
        pesel: this.pesel,
        address:this.address,
        date: this.date,
        salary:this.salary
      };
      axios.put("http://localhost:8080/employee/update",body);
    },
  //    onFiltered (filteredItems) {
  //     // Trigger pagination to update the number of buttons/pages due to filtering
  //     this.totalRows = filteredItems.length
  //     this.currentPage = 1
  //   },
  //   filterData(){
  //     let input = document.getElementById('filter-search');
  //     this.employees.forEach(element =>{  
  //       if(element.name.includes(input.value)){
  //         if(this.backUpEmployees.indexOf(element.name)<0){
  //           this.backUpEmployees.push(element.name);
  //         }
  //       } 
  //     })
  //     this.employees = this.backUpEmployees;
  //   },
  //   clone(obj) {
  //     if (null == obj || "object" != typeof obj) return obj;
  //     var copy = obj.constructor();
  //     for (var attr in obj) {
  //         if (obj.hasOwnProperty(attr)) copy[attr] = obj[attr];
  //     }
  //     return copy;
  // }
  },
  beforeMount() {
    axios
      .get("http://localhost:8080/employee/active")
      .then(data => {
        this.employees = data.data;
        this.test(this.employees);
        this.totalRows = data.data.length;
      })
      .catch(error => console.error(error));
  }
};
</script>

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
         <b-table striped hover :items="employees" :fields="fields" :filter="filter"></b-table>
    </div>
</template>
<script>
import axios from 'axios'
export default {
    components:{
        axios
    },
    data(){
        return{
            employees:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:'surname',
                sortable:true
            },
            {
                key:'pesel',
                sortable:false
            },
            {
                key:'date',
                sortable:false
            },
            {
                key:'address',
                sortable:true
            },
            {
                key:'salary',
                sortable:true
            }],
            filter:""
        }
    },
    methods:{
        test(data) {
      let i = 0;
      data.forEach(element => {
        this.employees[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/employee/all")
        .then(data => {this.employees = data.data;
        this.test(this.employees);})
        .catch(error => console.error(error))
    }
    
}
</script>

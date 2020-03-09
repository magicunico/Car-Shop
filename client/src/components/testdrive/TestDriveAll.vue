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
         <b-table striped hover :items="testdrives" :fields="fields" :filter="filter"></b-table>
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
            testdrives:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'date',
                sortable:true
            },
            {
                key:'employee.id',
                sortable:true
            },
            {
                key:'customer.id',
                sortable:false
            },
            {
                key:'car.id',
                sortable:true
            }],
            filter:""
        }
    },
    methods:{
        test(data) {
      let i = 0;
      data.forEach(element => {
        this.testdrives[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/testdrive/all")
        .then(data =>{ 
            this.testdrives = data.data;
            this.test(this.testdrives);
            })
        .catch(error => console.error(error))
    }
    
}
</script>

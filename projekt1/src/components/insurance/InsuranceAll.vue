<template>
    <div>
        <b-form-group horizontal label="Search" class="mb-0">
      <b-input-group>
        <b-form-input v-model="filter" placeholder="Type to Search"/>
        <b-input-group-append>
          <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
        </b-input-group-append>
      </b-input-group>
    </b-form-group>
         <b-table striped hover :items="insurances" :fields="fields" :filter="filter"></b-table>
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
            insurances:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:'starting',
                sortable:true
            },
            {
                key:'ending',
                sortable:false
            },
            {
                key:'price',
                sortable:false
            }],
            filter:""
        }
    },
    methods:{
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
    beforeMount(){
        axios.get("http://localhost:8080/insurance/all")
        .then(data => {
        this.insurances = data.data;
        this.test(this.insurances);})
        .catch(error => console.error(error))
    }
    
}
</script>

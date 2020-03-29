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
         :hover="true"
         :items="cars" 
         :fields="fields" 
         ref="tableCar"
         id="car-list-table"
         v-if="!edit"
         :filter="filter">
         </b-table>
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
            cars:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'color',
                sortable:true
            },
            {
                key:'price',
                sortable:true
            },
            {
                key:'body',
                sortable:false
            },
            {
                key:'gearbox',
                sortable:true
            },
             {
                key:'warehouse.id',
                sortable:true
            },
            {
                key: 'warehouse.name'
            },
             {
                key:'brand.id',
                sortable:true
            },
            {
                key:'brand.name'
            }
            ],
            edit: false,
            filter: ""
        };
    },
    methods:{
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/car/all")
        .then(data => this.cars = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

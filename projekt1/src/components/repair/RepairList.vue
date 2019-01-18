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
         <b-table striped hover :items="repairs" :fields="fields" :filter="filter"></b-table>
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
            repairs:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:'price',
                sortable:true
            },
            {
                label:'employee',
                key:'employee.id',
                sortable:false
            },
             {
                label:'employee',
                key:'employee.name',
                sortable:false
            },
             {
                label:'employee',
                key:'employee.surname',
                sortable:false
            },
            {
                label:'car',
                key:'car.id',
                sortable:false
            },
             {
                label:'producer',
                key:'car.brand.producer.name',
                sortable:false
            },
             {
                label:'brand',
                key:'car.brand.name',
                sortable:false
            }],
            filter:""
        }
    },
    methods:{
    },
    beforeMount(){
        axios.get("http://localhost:8080/repair/active")
        .then(data => this.repairs = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

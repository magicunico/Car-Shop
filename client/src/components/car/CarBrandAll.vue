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
         <b-table striped hover :items="brand" :fields="fields" :filter="filter"></b-table>
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
            brand:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
            },
            {
                key:"producer.id"
            },
            {
                key:"producer.name"
            }],
            edit: false,
            filter:""
        }
    },
    methods:{
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/brand/all")
        .then(data => this.brand = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

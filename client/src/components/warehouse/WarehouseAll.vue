<template>
    <div>
        <b-form-group horizontal label="Search"  class="mb-0">
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
            }],
            filter:""
        }
    },
    methods:{
        filterList(list){
            let newList = new Array()
            for(let i=0;i<list.lenght;i++){
                list[i].date = list[i].date.trim(0,10)
                console.log(list[i].date)
                newList.push(list[i])
            }
            return newList
        }
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/warehouse/all")
        .then(data => this.employees = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

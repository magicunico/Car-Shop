<template>
    <div>
         <b-table striped :items="testDrives" :fields="fields" :hover="true" ref="table" id="testdrives-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteTestDrive(data.item.id)"></span>
             </template>
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
            testDrives:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'date',
                sortable:true
            },
            // {
            //     key:'employee.id',
            //     sortable:true
            // },
            {
                key:'employee.name'
            },
            {
                key:'employee.surname'
            },
            // {
            //     key:'customer.id',
            //     sortable:false
            // },
            {
                key:'customer.name',
                sortable:false
            },
            {
                key:'customer.surname',
                sortable:false
            },
            // {
            //     key:'car.id',
            //     sortable:true
            // },
            {
                key:'car.color',
                sortable:true
            },
            {
                key:'car.brand.name',
                sortable:true
            },
            {
                key:"actions"
            }]
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
        },
    deleteTestDrive(data) {
      axios.delete("http://localhost:8080/testdrive/delete/" + data);
      this.$root.$emit("bv::refresh::table", "testdrives-list-table");
      this.$refs.table.refresh();
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/testdrive/active")
        .then(data => this.testDrives = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

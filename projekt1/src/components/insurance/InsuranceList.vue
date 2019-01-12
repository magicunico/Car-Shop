<template>
    <div>
        <b-table striped :items="insurances" :fields="fields" :hover="true" ref="table" id="insurance-list-table" >
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteInsurance(data.item.id)"></span>
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
            },
            {
                key: "actions"
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
        deleteInsurance(data){
            axios.delete("http://localhost:8080/insurance/delete/" + data);
            this.$root.$emit("bv::refresh::table", "insurance-list-table");
            this.$refs.table.refresh();
     
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/insurance/active")
        .then(data => this.insurances = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

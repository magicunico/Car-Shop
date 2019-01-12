<template>
    <div class="container">
         <b-table margin-right:200px striped :items="transactions" :fields="fields" :hover="true" ref="table" id="tranactions-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteTransaction(data.item.id)"></span>
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
            transactions:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'date',
                sortable:true
            },
            {
                key:'payment',
                sortable:true
            },
            {
                key:'place',
                sortable:false
            },
            {
                key:'sum',
                sortable:true
            },
            {
                key:'car.id',
                sortable:true
            },
            {
                key:'car.brand.name',
                sortable:true
            },
            {
                key:'car.color',
                sortable:true
            },
            {
                key:'customer.id',
                sortable:true
            },
            {
                key:'customer.name',
                sortable:true
            },
            {
                key:'customer.surname',
                sortable:true
            },
            {
                key:'employee.id',
                sortable:true
            },
             {
                key:'employee.name',
                sortable:true
            },
             {
                key:'employee.surname',
                sortable:true
            },
            {
                key:'insurance.id',
                sortable:true
            },
            {
                key:'insurance.name',
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
        deleteTransaction(data){
            axios.delete("http://localhost:8080/transaction/delete/" + data);
            this.$root.$emit("bv::refresh::table", "transactions-list-table");
            this.$refs.table.refresh();
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/transaction/active")
        .then(data => this.transactions = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

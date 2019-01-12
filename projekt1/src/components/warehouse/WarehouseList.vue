<template>
    <div>
        <b-table striped :items="warehouses" :fields="fields" :hover="true" ref="table" id="warehouses-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteWarehouse(data.item.id)"></span>

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
            warehouses:[],
            fields:[{
                key:'id',
                sortable:true
            },
            {
                key:'name',
                sortable:true
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
        deleteWarehouse(data){
            axios.delete("http://localhost:8080/warehouse/delete/" + data);
             this.$root.$emit("bv::refresh::table", "warehouses-list-table");
            this.$refs.table.refresh();
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/warehouse/active")
        .then(data => this.warehouses = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

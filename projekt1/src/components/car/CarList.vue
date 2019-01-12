<template>
    <div>
         <b-table striped :items="cars" :fields="fields" :hover="true" ref="table" id="cars-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteCar(data.item.id)"></span>
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
                key:'brand.id',
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
        deleteCar(data){
        axios.delete("http://localhost:8080/car/delete/" + data);
      this.$root.$emit("bv::refresh::table", "cars-list-table");
      this.$refs.table.refresh();
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/car/active")
        .then(data => this.cars = data.data)
        .catch(error => console.error(error))
    },
    
}
    
</script>

<template>
    <div>
        <b-table striped :items="brand" :fields="fields" :hover="true" ref="table" id="brand-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteBrand(data.item.id)"></span>
             </template>
         </b-table>
    </div>
</template>
<script>
import axios from 'axios'
import CarBrandAll from '@/components/car/CarBrandAll'
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
                key:"actions"
            }],
        };
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
     deleteBrand(data) {
      axios.delete("http://localhost:8080/brand/delete/" + data);
      this.$root.$emit("bv::refresh::table", "brand-list-table");
      this.$refs.table.refresh();
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/brand/active")
        .then(data => this.brand = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

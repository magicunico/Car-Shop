<template>
    <div>
         <b-table striped :items="producer" :fields="fields" :hover="true" ref="table" id="producer-list-table">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteProducer(data.item.id)"></span>
                
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
            producer:[],
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
    deleteProducer(data) {
      axios.delete("http://localhost:8080/producer/delete/" + data);
      this.$root.$emit("bv::refresh::table", "producer-list-table");
      this.$refs.table.refresh();
    }
    },


    beforeMount(){
        axios.get("http://localhost:8080/producer/active")
        .then(data => this.producer = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

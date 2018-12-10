<template>
    <div>
         <b-table striped hover :items="employees" :fields="fields"></b-table>
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
                key:'date',
                sortable:true
            },
            {
                key:'employee',
                sortable:true
            },
            {
                key:'customer',
                sortable:false
            },
            {
                key:'car',
                sortable:true
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
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/testdrive/all")
        .then(data => this.employees = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

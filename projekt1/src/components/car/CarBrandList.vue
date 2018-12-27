<template>
    <div>
         <b-table striped hover :items="brand" :fields="fields"></b-table>
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
        axios.get("http://localhost:8080/brand/active")
        .then(data => this.brand = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

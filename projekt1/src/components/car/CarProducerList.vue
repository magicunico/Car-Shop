<template>
    <div>
         <b-table striped :items="producer" :fields="fields" :hover="true" ref="table" id="producer-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteProducer(data.item.id)"></span>
                <span><img src="../../assets/edit.svg" @click="editProducer(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateProducer()">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                    description="We'll never share your email with anyone else.">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="name"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
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
            }],
            edit:false,
            name:""
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
    },
    editProducer(data){
        this.edit=true;
        axios.get("http://localhost:8080/producer/"+data)
        .then(result=>{
            this.name=result.data.name;
        })
    },
    updateProducer(){}
    },


    beforeMount(){
        axios.get("http://localhost:8080/producer/active")
        .then(data => this.producer = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

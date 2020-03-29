<template>
    <div>
         <b-form-group horizontal label="Search" v-if="!edit" class="mb-0">
      <b-input-group>
        <b-form-input v-model="filter" placeholder="Type to Search"/>
        <b-input-group-append>
          <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
        </b-input-group-append>
      </b-input-group>
    </b-form-group>
         <b-table striped :items="producer" :fields="fields" :hover="true" refs="tableProd" id="producer-list-table" v-if="!edit" :filter="filter">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteProducer(data.item.id)"></span>
                <span><img src="../../assets/edit.svg" @click="editProducer(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateProducer()">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                   >
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
            name:"",
            id:"",
            filter:""
        }
    },
    methods:{
       
    deleteProducer(data) {
      axios.delete(process.env.API_URL + "/producer/delete/" + data)
      .then(()=>{
          this.$router.go();
      })
    },
    editProducer(data){
        this.edit=true;
        axios.get(process.env.API_URL + "/producer/"+data)
        .then(result=>{
            this.name=result.data.name;
            this.id=result.data.id;
        })
    },
    updateProducer(){
        let body = {
            id: this.id,
            name: this.name,
            status: '1'
        };
        axios.put(process.env.API_URL + "/producer/update",body);
        console.log(body);
    }
    },


    beforeMount(){
        axios.get(process.env.API_URL + "/producer/active")
        .then(data => this.producer = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

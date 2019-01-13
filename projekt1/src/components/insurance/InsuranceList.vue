<template>
    <div>
        <b-table striped :items="insurances" :fields="fields" :hover="true" ref="table" id="insurance-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteInsurance(data.item.id)"></span>
                 <span><img src="../../assets/edit.svg" @click="editInsurance(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateInsurance()">
      <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="name"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="starting:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="date"
                      v-model="starting"
                      required
                      placeholder="Enter pesel">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="ending:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="date"
                      v-model="ending"
                      required
                      placeholder="Enter name">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="price:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="number"
                      v-model="price"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
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
            }],
            edit: false,
            name:"",
            starting:"",
            ending:"",
            price:""
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
     
        },
        editInsurance(data){
            this.edit=true;
            axios.get("http://localhost:8080/insurance/"+data)
            .then(result=>{
                this.name=result.data.name;
                this.starting=result.data.starting;
                this.ending=result.data.ending;
                this.price=result.data.price;
            })
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/insurance/active")
        .then(data => this.insurances = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

<template>
    <div>
        <b-table striped :items="brand" :fields="fields" :hover="true" ref="table" id="brand-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteBrand(data.item.id)"></span>
                  <span><img src="../../assets/edit.svg" @click="editBrand(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit.prevent="updateBrand()">
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
      <b-form-group id="exampleInputGroup2"
                    label="producer:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="producer"
                      required
                      placeholder="Enter pesel">
        </b-form-input>
      </b-form-group>
    <b-button type="submit" variant="primary">Update</b-button>
    </b-form>
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
            edit:false,
            name:"",
            producer:""
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
    },
    editBrand(data){
        this.edit = true;
        axios.get("http://localhost:8080/brand/"+data)
        .then( result => {
            this.name = result.data.name;
            this.producer=result.data.producer.id;
        })
    }
    },
    beforeMount(){
        axios.get("http://localhost:8080/brand/active")
        .then(data => this.brand = data.data)
        .catch(error => console.error(error))
    }
    
}
</script>

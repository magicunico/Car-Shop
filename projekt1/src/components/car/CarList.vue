<template>
    <div>
         <b-table striped :items="cars" :fields="fields" :hover="true" ref="table" id="cars-list-table" v-if="!edit">
             <template slot="actions" slot-scope="data">
                 <span style="padding-left:20px;"><img src="../../assets/delete.svg" @click="deleteCar(data.item.id)"></span>
                 <span><img src="../../assets/edit.svg" @click="editCar(data.item.id)"></span>
             </template>
         </b-table>
         <b-form v-else @submit="updateCar()">
        <b-form-group id="exampleInputGroup1"
                    label="warehouse:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="warehouse"
                      required
                      placeholder="Enter warehouse id">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="brand"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="brand"
                      required
                      placeholder="Enter brand id">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup1"
                    label="Color:"
                    label-for="exampleInput1">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="color"
                      required
                      placeholder="Enter color">
        </b-form-input>
      </b-form-group>
      <b-form-group id="exampleInputGroup2"
                    label="Price:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="number"
                      v-model="price"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="Body:"
                    label-for="exampleInput1"
                    description="select one from: sedan, kombi, SUV, hatchback, kabriolet, liftback, pick-up, minivan ">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="body"
                      required
                      placeholder="Enter body">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="gearbox:"
                    label-for="exampleInput1"
                    description="enter one of: manual, auto">
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="gearbox"
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
            }],
            edit:false,
            color: "",
            price:"",
            body:"",
            gearbox:"",
            warehouse:"",
            brand:""
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
        },
        editCar(data){
             this.edit = true;
            axios.get("http://localhost:8080/car/"+data)
            .then( result => {
            this.color = result.data.color;
            this.price = result.data.price;
            this.body = result.data.body;
            this.gearbox = result.data.gearbox;
            this.warehouse=result.data.warehouse.id;
            this.brand = result.data.brand.id;
        })
        },
        updateCar(){}
    },
    beforeMount(){
        axios.get("http://localhost:8080/car/active")
        .then(data => this.cars = data.data)
        .catch(error => console.error(error))
    },
    
}
    
</script>

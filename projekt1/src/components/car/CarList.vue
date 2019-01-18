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
         <b-table 
         striped 
         :items="cars"
          :fields="fields"
           :hover="true"
            ref="table"
             id="cars-list-table"
              v-if="!edit"
              :filter="filter">
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
                key:'warehouse.name'
            },
             {
                key:'brand.id',
                sortable:true
            },
            {
                key:'brand.name'
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
            brand:"",
            id:"",
            filter:""
        }
    },
    methods:{
       
        deleteCar(data){
        axios.delete("http://localhost:8080/car/delete/" + data)
        .then(()=>{
          this.$router.go();
      })
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
            this.id=result.data.id;
        })
        },
        updateCar(){
            let body = {
            color: this.color,
            price:this.price,
            body:this.body,
            gearbox:this.gearbox,
            warehouse:{id: this.warehouse},
            brand:{id: this.brand},
            id:this.id,
            status:"1"
        
      };
            axios.put("http://localhost:8080/car/update",body);
            console.log(body);
        }
    },
    beforeMount(){
        axios.get("http://localhost:8080/car/active")
        .then(data => this.cars = data.data)
        .catch(error => console.error(error))
    },
    
}
    
</script>

<template>
    <b-form @submit="submit" :validated="true">
        <b-form-group id="exampleInputGroup1"
                    label="warehouse:"
                    label-for="exampleInput1">
         <b-form-select id="exampleInput3"
                      :options="cars.map(a =>{return a.name})"
                      required
                      v-model="warehouse"
                      >
        </b-form-select>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="brand"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput3"
                      :options="brands.map(a =>{return a.name})"
                      required
                      v-model="brand"
                      >
        </b-form-select>
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
         <b-form-radio-group id="radios1" v-model="body" :options="bodies" name="radioOpenions">
      </b-form-radio-group>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="gearbox:"
                    label-for="exampleInput1"
                    description="enter one of: manual, auto">
       <b-form-radio-group id="exampleInput3"
                      :options="gearboxes"
                      required
                      v-model="gearbox"
                      >
        </b-form-radio-group>
      </b-form-group>
    <b-button type="submit" variant="primary">Add car</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            cars:[],
            brands:[],
            color:'',
            price:'',
            body:null,
            gearbox:null,
            warehouse:'',
            brand:'',
            bodies:['sedan','kombi','SUV','hatchback','kabriolet','liftback','pick-up','minivan'],
            gearboxes:['manual','auto']
        }
    },
    methods:{
           getId(){
            let id = -1;
            let pom = this.warehouse.split(' ');
            console.log(pom[0])
            this.cars.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        getIdId(){
            let id = -1;
            let pom = this.brand.split(' ');
            console.log(pom[0])
            this.brands.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        submit(){
         
            let body = {
                'color' : this.color,
                'price' : this.price,
                'body' : this.body,
                'gearbox': this.gearbox,
                'warehouse': {
                    'id': this.getId()},
                'brand': {
                    'id':this.getIdId()
                    },
                'status':'1'
            }

            console.log(body);

            axios.post("http://localhost:8080/car/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    },
    beforeMount() {
      axios
      .get("http://localhost:8080/warehouse/active")
      .then(data => (this.cars = data.data))
      .catch(error => console.error(error));
      axios
      .get("http://localhost:8080/brand/active")
      .then(data => (this.brands = data.data))
      .catch(error => console.error(error));
  }
    
}
</script>

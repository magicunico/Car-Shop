<template>
    <b-form @submit.prevent="submit">
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
                    label="price:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="price"
                      required
                      placeholder="Enter price">
        </b-form-input>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="employee:"
                    label-for="exampleInput1">
        <b-form-select id="exampleInput3"
                      :options="employees.map(a =>{return a.name+' '+a.surname})"
                      required
                      v-model="employee"
                      >
        </b-form-select>
      </b-form-group>
       <b-form-group id="exampleInputGroup1"
                    label="car:"
                    label-for="exampleInput1">
       <b-form-select id="exampleInput3"
                      :options="carses.map(a =>{return a.id+' model: '+a.brand.producer.name+' color: '+a.color+' at: '+a.warehouse.name})"
                      required
                      v-model="car"
                      >
        </b-form-select>
      </b-form-group>
    <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
</template>
<script>
import axios from 'axios'
export default {
    components:{axios},
    data(){
        return {
            employees:[],
            carses:[],
            name:'',
            price:'',
            employee:'',
            car:'',
           
        }
    },
    methods:{
        getId(){
            let id = -1
            let pom = this.employee.split(' ');
            console.log(pom[0])
            this.employees.forEach(element => {
                console.log(element.name);
                if(element.name == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
         getIdis(){
            let id = -1
            let pom = this.car.split(' ');
            console.log(pom[0])
            this.carses.forEach(element => {
                console.log(element.id);
                if(element.id == pom[0]){
                    id = element.id;
                }
            });
            return id;
        },
        submit(){
            let body = {
                'name' : this.name,
                'price' : this.price,
                'employee' :{'id':this.getId() } ,
                'car': {'id': this.getIdis()},
                'status': '1'
            }

            console.log(body);

            axios.post("http://localhost:8080/repair/add",body)
            .catch(error => console.error(error))
            console.log(body)

        }
    },
    beforeMount(){
        axios
      .get("http://localhost:8080/employee/active")
      .then(data => (this.employees = data.data))
      .catch(error => console.error(error));
      axios
      .get("http://localhost:8080/car/active")
      .then(data => {this.carses = data.data;
      console.log(data)})
      .catch(error => console.error(error));
    }
    
}
</script>

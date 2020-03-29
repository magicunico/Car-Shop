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
         <b-table striped hover :items="transactions" :fields="fields" :filter="filter" v-if="!edit"></b-table>
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
            transactions:[],
            fields:[
                {
          key: "id",
          sortable: true
        },
        {
          key: "date",
          sortable: true
        },
        {
          key: "payment",
          sortable: true
        },
        {
          key: "place",
          sortable: false
        },
        {
          key: "sum",
          sortable: true
        },
        {
          label:"Car",
          key: "car.id",
          sortable: true
        },
        {
          label:"Brand",
          key: "car.brand.name",
          sortable: true
        },
        {
          label:"Color",
          key: "car.color",
          sortable: true
        },
        {
          label:"Producer",
          key: "car.brand.producer.name"
        },
        {
          label:"Customer",
          key: "customer.id",
          sortable: true
        },
        {
          label:"Name",
          key:"customer.name"
        },
        {
          label:"Surname",
          key: "customer.surname",
          sortable: true
        },
        {
          label:"Employee",
          key: "employee.id",
          sortable: true
        },
        {
          label:"Name",
          key:"employee.name"
        },
        {
          label:"Surname",
          key: "employee.surname",
          sortable: true
        },
        {
          label:"Insurance",
          key: "insurance.id",
          sortable: true
        },
        {
          label:"Type",
          key: "insurance.name"
        }
       ],
            filter:"",
            edit:false
        }
    },
    methods:{
        test(data) {
      let i = 0;
      data.forEach(element => {
        this.transactions[i].date = new Date(element.date).toLocaleDateString(
          "en-GB"
        );
        i++;
      });
    }
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/transaction/all")
        .then(data => {
            this.transactions = data.data;
            this.test(this.transactions);})
        .catch(error => console.error(error))
    }
    
}
</script>

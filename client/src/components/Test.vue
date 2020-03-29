<template>
  <body class="container">
    <form class="form-signin">
      <h1 class="h3 mb-3 font-weight-normal">Add post</h1>
      <label for="inputEmail" class="sr-only">Topic</label>
      <input class="form-control" placeholder="Topic" v-model="topic" required autofocus>
      <label  class="sr-only">Type here</label>
      <input  v-model="body" class="form-control topic-body" placeholder="Topic body" required>
      <button class="btn btn-lg btn-primary btn-block" @click="addTopic" type="submit">Add topic</button>
    </form>
    <br>
     <!-- <div class="row" v-for="item in topics">
        <div class="col-4">{{item.id}}</div>
        <div class="col-4">{{item.value}}</div>
     </div>
      <div class="row" v-for="item in user">
        <div class="col-4">{{item.id}}</div>
        <div class="col-4">{{item.name}}</div>
     </div> -->
  </body>
</template>
<script>
import axios from 'axios'
export default {
    components:{
        axios
    },
    name: 'Test',
    data(){
        return{
            topics:[],
            topic:'',
            body:'',
            user:[]
        }
    },
    methods:{
        addTopic(e){
            e.preventDefault();
            let obj = {
                id : this.topic,
                value : this.body,
            }
            this.topics.push(obj);
        }
    },
    beforeMount(){
        axios.get(process.env.API_URL + "/customer/all")
        .then(data => this.user = data.data).
        catch(err => console.error(err))
    }
}
</script>
<style>
html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: -webkit-box;
  display: flex;
  -ms-flex-align: center;
  -ms-flex-pack: center;
  -webkit-box-align: center;
  /* align-items: center; */
  -webkit-box-pack: center;
  justify-content: center;
  /* padding-top: 40px; */
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 600px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

body {
  padding-top: 2rem;
  padding-bottom: 2rem;
}

h3 {
  margin-top: 2rem;
}

.row {
  margin-bottom: 1rem;
}
.row .row {
  margin-top: 1rem;
  margin-bottom: 0;
}
[class*="col-"] {
  padding-top: 1rem;
  padding-bottom: 1rem;
  background-color: rgba(86, 61, 124, .15);
  border: 1px solid rgba(86, 61, 124, .2);
}

hr {
  margin-top: 2rem;
  margin-bottom: 2rem;
}
</style>



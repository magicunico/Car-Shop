<template>
    <div id="signup">
        <h1>Sign Up</h1>
        <input type="text" name="username" v-model="username" placeholder="Username" />
        <input type="password" name="password" v-model="password" placeholder="Password" />
        <button type="button" v-on:click="signUp()">Sign Up</button>
         <button type="button" v-on:click="loginN()">Login into existing account</button>
    </div>
</template>

<script>
import axios from 'axios'
    export default {
        name: 'Login',
        data() {
            return {
                    username: "",
                    password: ""
            }
        },
        methods: {
            signUp: function(event) {
                let user={
                    'username':this.username,
                    'password':this.password
                }
                console.log(user);
                axios.post(process.env.API_URL + "/login/signup",user)
                .then(data=>{this.$router.replace({name: 'Login'})})
                .catch(error => {
              this.$notify({
                group:'foo',
                type:'error',
                title:'WRONG USERNAME',
                text:'Username is already taken!',
                closeOnClick:true,
                duration: 10000
              });
            });
                // if(this.input.username != "" && this.input.password != "") {
                //     if(this.input.username == "admin" && this.input.password == "pass") {
                //         // this.$emit("authenticated", true);
                //         this.$router.replace({ name: "HelloWorld" });
                //     } else {
                //         console.log("The username and / or password is incorrect");
                //     }
                // } else {
                //     console.log("A username and password must be present");
                // }
            },
            check: function(data){
                if(data.data){
                    this.$router.replace({name: 'Login'});
                }else{
                    this.$notify({
                group:'foo',
                type:'error',
                title:'error',
                text:response.message,
                closeOnClick:true,
                duration: 10000
              });
                }
            },
            authorize: function(data){
                if(data){
                    this.$router.replace({name: 'Login'});
                }
            },
            loginN: function(event){
                this.$router.replace({name: 'Login'});
            }
        }
    };
</script>

<style scoped>
    #signup {
        width: 500px;
        border: 1px solid #CCCCCC;
        background-color: #FFFFFF;
        margin: auto;
        margin-top: 200px;
        padding: 20px;
    }
</style>
<template>
    <div id="login">
        <h1>Login</h1>
        <input type="text" name="username" v-model="username" placeholder="Username" />
        <input type="password" name="password" v-model="password" placeholder="Password" />
        <button type="button" v-on:click="login()">Login</button>
        <button type="button" v-on:click="signUpNew()">Create account</button>
    </div>
</template>

<script>
import axios from 'axios'
    export default {
        name: 'Login',
        data() {
            return {
                    username: "",
                    password: "",
                    token:""
            }
        },
       
        methods: {
            signUpNew: function(event){
                this.$router.replace({name: 'SignUp'});
            },
            login: function(event) {
                let user={
                    'username':this.username,
                    'password':this.password
                }
                console.log(user);
                axios.post(process.env.API_URL + "/login/",user)
                .then((data)=>this.authorize(data))
                .catch(error => {
                    this.$notify({
                        group:'foo',
                        type:'error',
                        title:'WRONG DATA',
                        text:"Incorrect username or password",
                        closeOnClick:true,
                        duration: 10000
                    });
                    delete localStorage.token
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
            authorize: function(data){
                if(data){
                    localStorage.token=data.data.token 
                    this.$router.replace({name: 'HelloWorld'});
                }
            }
        }
    };
</script>

<style scoped>
    #login {
        width: 500px;
        border: 1px solid #CCCCCC;
        background-color: #FFFFFF;
        margin: auto;
        margin-top: 200px;
        padding: 20px;
    }
</style>
<template>
    <div id="login">
        <h1>Login</h1>
        <input type="text" name="username" v-model="input.username" placeholder="Username" />
        <input type="password" name="password" v-model="input.password" placeholder="Password" />
        <button type="button" v-on:click="login()">Login</button>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data() {
            return {
                input: {
                    username: "",
                    password: ""
                }
            }
        },
        methods: {
            login: function(event) {
                // let user={
                //     'login':this.username,
                //     'password':this.password
                // }
                // axios.post("http://localhost:8080/user/login",user)
                // .then(data=>this.authorize(data.data))
                // .then(console.log(data));
                if(this.input.username != "" && this.input.password != "") {
                    if(this.input.username == "admin" && this.input.password == "pass") {
                        // this.$emit("authenticated", true);
                        this.$router.replace({ name: "HelloWorld" });
                    } else {
                        console.log("The username and / or password is incorrect");
                    }
                } else {
                    console.log("A username and password must be present");
                }
            },
            authorize: function(data){
                if(data){
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
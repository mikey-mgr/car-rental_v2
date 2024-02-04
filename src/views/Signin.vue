<template>
    <div class="container">
        <div class="row">
            <div class="col-12 justify-content-center text-start d-flex pt-5">
                <div id="signin-div" class="flex-item border p-3">
                    <h2 class="pt-4 pl-3">Sign In</h2>
                    <form @submit="signin" class="form-group pt-4 pl-4 pr-4">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input v-model="email" id="email" type="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input v-model="password" id="password" type="password" class="form-control">
                        </div>
                        <button class="btn btn-primary mg-2">Login</button>
                        <hr>
                        <label class="col pt-4 pl-0 font-italic">Don't have an Account?</label>
                        <router-link :to="{name: 'SignupView'}"> 
                                <button class="btn btn-primary create-account">Create Account</button>
                        </router-link>    
                    </form>
                </div>
            </div>
        </div>
        
    </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';

export default {
    name: 'SigninView',
    props:['baseURL'],
    data(){
        return{
            email: null,
            password: null,
        };
    },
    methods: {
        async signin (e){
            e.preventDefault();
            const body = {
                email: this.email,
                password: this.password,
            }
            await axios.post(`${this.baseURL}/user/signin`, body)
            .then((res) => {
                this.$emit("fetchData");
                this.$emit("getRole");
                this.$router.push({name: 'HomeView'});
                localStorage.setItem("token", res.data.token);
                swal({
                    text: "Login successful",
                    icon: "success"
                });
            }).catch((err) => {
                console.error('err', err);
                swal({
                    text: "Invalid details, please try again",
                    icon: "warning"
                });
            });
        },
    },
    mounted(){
        
    }
    
}
</script>


<style scoped>
.btn-primary {
    background-color: #f0c14b;
    color: black;
    border-color: #f0c14b;
}

@media screen {
    #signin-div{
        width: 60%;
    }
}
.create-account{
    background-color: lightgray;
    border-color: lightgray;
}

</style>
<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center pt-3 justify-content-center">
                <!-- display logo -->
            </div>
        </div>
    </div>
    <!-- Header -->

    <div class="row">
        <div class="col-12 text-center justify-content-center pt-3 pl-4 pr-4 d-flex">
            <div id="signup-div" class="flex-item border">
                <label for="email"><h2 class="pt-4">Create Account</h2></label>
                <form @submit="signup" class="pt-4 ml-4 mr-4">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input v-model="email" id="email" type="email" class="form-control" required>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input v-model="firstName" id="firstName" type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input v-model="lastName" id="lastName" type="text" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input v-model="password" id="password" type="password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <input v-model="confirmPassword" id="confirmPassword" type="password" class="form-control" required>
                    </div>
                    <button class="btn btn-primary mt-2">Create Account</button>
                    <hr>
                    <label class="col pt-4 font-italic">Already have an Account?</label>
                    <router-link :to="{name: 'SigninView'}"> 
                            <button class="btn btn-primary login">Login</button>
                    </router-link>
                </form>
            </div>

        </div>

    </div>
    
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';
export default {
    name: "SignupView",
    props:['baseURL'],
    data(){
        return{
            email: null,
            firstName: null,
            lastName: null,
            password: null,
            confirmPassword: null,
        }
    },
    methods: {
        async signup(e){
            e.preventDefault();
            if (this.password === this.confirmPassword){
                //call signup api
                const user = {
                    email: this.email,
                    firstName: this.firstName,
                    lastName: this.lastName,
                    password: this.password,
                };
                await axios.post(`${this.baseURL}/user/signup`, user)
                .then(() => {
                    this.$router.replace('/');
                    swal({
                        text: "Signup successful, please login now",
                        icon: "success"
                    });
                })
                .catch((err) => console.error('err', err));

            } else {
                //show some error
                swal({
                        text: "Passwords don't match, please try again",
                        icon: "error"
                    });
            }
        }
    },
    mounted() {
        
    },
    
}
</script>

<style scoped>
.btn-primary {
    background-color: #f0c14b;
    color: black;
    border-color: #f0c14b;
}
@media screen {
    #signup-div{
        width: 60%;
    }
}
.login {
    background-color: lightgray;
    border-color: lightgray;
}

</style>
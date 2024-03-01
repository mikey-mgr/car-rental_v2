<template>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top nav-underline mb-2 p-0">
      <div class="container-fluid">
        <!-- Navbar content -->
        <!--    Logo-->
        <router-link class="navbar-brand p-0 mr-0" :to="{ name: 'HomeView' }" >
          <img id="logo" src="../../public/logo-dark.png"/>
        </router-link>
        <!--    Burger Button-->
        <button
          class="navbar-toggler mr-4"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
          aria-current="true"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mx-4 justify-content-center" id="navbarSupportedContent">
          <ul class="navbar-nav justify-content-evenly w-100">
              <li class="nav-item"><router-link class="nav-link text-light" v-if="role == 'ADMIN'" :to="{name: 'AdminView'}">ADMIN</router-link></li>
              <li class="nav-item"><router-link class="nav-link text-light" :to="{name: 'HomeView'}">HOME</router-link></li>
              <li class="nav-item"><router-link class="nav-link text-light" :to="{name: 'VehiclesView'}">VEHICLES</router-link></li>
              
            <!-- Dropdown for account -->
            <!-- <ul class="navbar-nav nav-underline mr-auto"> -->
              <li class="nav-item dropdown">
                <a href=""
                    class="nav-link text-light dropdown-toggle" 
                      id="navbarAccount" 
                        data-toggle="dropdown"
                        >ACCOUNT
                </a>
                <ul class="dropdown-menu account-dropdown" aria-labelledby="navbarAccount">
                  <router-link v-if="token" class="dropdown-item" :to="{name: 'WishList'}">WISHLIST</router-link>
                  <router-link v-if="!token" class="dropdown-item" :to="{name: 'SignupView'}">SIGNUP</router-link>
                  <li><hr class="dropdown-divider"></li>
                  <router-link v-if="!token" class="dropdown-item" :to="{name: 'SigninView'}">LOGIN</router-link>
                  <a href="#" v-if="token" @click="logout" class="dropdown-item">LOGOUT</a>
                </ul>
              </li>
            <!-- </ul > -->
              <li v-if="role" class="nav-item cart position-relative">
                  <span id="cart-nav-count">{{ cartCount }}</span>
                  <router-link style="font-size: 36px; color: #c18e32;" 
                      :to="{name:'CartView'}" class="py-2 bi bi-cart nav-link text-decoration-none">
                    <!-- <img class="icon-link" style="width: 40px;" src="../../public/cart-shopping-solid.svg" alt=""> -->
                  </router-link>
              </li>
          </ul>
        </div> 
      </div>
    </nav>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';


  export default {
    name: "NavbarView",
    props:["cartCount", "users", "baseURL"],
    data() {
      return {
        role: null,
      }
    },
    methods: {
      async logout(){
        await axios.get(`${this.baseURL}/logout`, { withCredentials: true })
        .then((res) =>{
          if(res.data == "Logout Success"){
            swal({
            text: "You have logged out",
            icon: "success"
            });
            localStorage.removeItem("token");
            localStorage.removeItem("role");
            this.token = null;
            this.$emit("clearUsers");
            this.$router.push({name: 'HomeView'});
            this.$emit("resetCartCount");
            // this.$emit("getUsers");
            window.location.replace("/home");
          }
        }).catch((err) => console.log('err', err));
      },
      
    },
    mounted(){
        this.token = localStorage.getItem("token");
        this.role = localStorage.getItem("role");
    },
  }
</script>


<style scoped>
.navbar{
  background-color: #090051;
  color: #c18e32;
}
#logo {
  width: 120px;
  margin-left: 0px;
  margin-right: 20px;
}
.dropdown-menu{
  /* --bs-dropdown-padding-x: .3rem;
  --bs-dropdown-padding-y: .25rem;
  border-radius: 0.5rem; */
  right: 0;
  left: auto;
  top: 2.8rem;
}
.dropdown-item{
  border-color: black;
  /* border-radius: 0.5rem; */
}
.dropdown-item:hover{
  background-color: lightgrey;
}
.nav-link{
  display: flex;
  height: 100%;
  justify-items: center;
}
.cart{
  margin-top: -0.5rem;
}
#navbarAccount.dropdown-toggle::after{
  display: inline-block;
    margin-left: 0.4em;
    margin-top: 0.7rem;
}
#cart-nav-count{
  text-decoration-style: none;
  background-color: crimson; 
  color: white;
  border-radius: 50%;
  height: 15px;
  width: 15px;
  font-size: 15px;
  align-items: center;
  justify-content: center;
  display: flex;
  padding: 0.65rem;
  position: absolute;
  left: 10px;
  top: 5px;

}
</style>

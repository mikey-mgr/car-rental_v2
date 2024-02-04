<template>
    <nav class="navbar navbar-expand-lg navbar-dark">
      <head>
        <favicon src="../../public/favicon-dark.ico" />
      </head>
      <!-- Navbar content -->
      <!--    Logo-->
      <router-link class="navbar-brand" :to="{ name: 'HomeView' }" >
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
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse mr-4 ml-4" id="navbarSupportedContent">
        
        <!--      Search Bar-->
        <form class="form-inline ml-auto mr-auto">
          <div class="input-group">
            <input
              size="100"
              type="text"
              class="form-control"
              placeholder="Search Items"
              aria-label="Username"
              aria-describedby="basic-addon1"
            />
            <div class="input-group-prepend">
              <span class="input-group-text font-weight-bold" id="search-button-navbar">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  class="bi bi-search"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
                  />
                </svg>
              </span>
            </div>
          </div>
        </form>
        <!-- Dropdown for browse -->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown">
            <a href="" class="nav-link text-light dropdown-toggle" id="navbarAccount" data-toggle="dropdown">Browse</a>
            <div class="dropdown-menu" aria-labelledby="navbarAccount">
              <div><router-link class="dropdown-item" :to="{name: 'HomeView'}">Home</router-link></div>
              <!-- <li><hr class="dropdown-divider"></li> -->
              <div><router-link class="dropdown-item" :to="{name: 'AdminView'}">Admin</router-link></div>
              <!-- <div><router-link  class="dropdown-item" :to="{name: 'CategoryView'}">Category</router-link></div> -->
            </div>
          </li>
        </ul>

        <!-- Dropdown for account -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item dropdown">
            <a href=""
                class="nav-link text-light dropdown-toggle" 
                  id="navbarAccount" 
                    data-toggle="dropdown"
                    >Account
          </a>
            <div class="dropdown-menu account-dropdown" aria-labelledby="navbarAccount">
              <router-link v-if="token" class="dropdown-item" :to="{name: 'WishList'}">Wishlist</router-link>
              <router-link v-if="!token" class="dropdown-item" :to="{name: 'SignupView'}">Signup</router-link>
              <li><hr class="dropdown-divider"></li>
              <router-link v-if="!token" class="dropdown-item" :to="{name: 'SigninView'}">Login</router-link>
              <a href="#" v-if="token" @click="logout" class="dropdown-item">Logout</a>
            </div>
          </li>
        </ul> 
          <div class="cart" style="position: relative;">
            <span id="cart-nav-count">{{ cartCount }}</span>
            <router-link style="text-decoration-style: none; font-size: 36px; color: #c18e32;" :to="{name:'CartView'}">
              <img class="icon-link" style="width: 40px;" src="../../public/cart-shopping-solid.svg" alt="">
            </router-link>
          </div>
      </div>

    </nav>
</template>

<script>
import swal from 'sweetalert';


  export default {
    name: "NavbarView",
    props:["cartCount", "users"],
    data() {
      return {
        
      }
    },
    methods: {
      logout(){
       localStorage.removeItem("token");
       this.token = null;
       this.$router.push({name: 'HomeView'});
       swal({
        text: "You have logged out",
        icon: "success"
       });
       this.$emit("resetCartCount");
       this.$emit("getUsers");
       this.$router.push({name: 'HomeView'});
      },
      
    },
    mounted(){
        this.token = localStorage.getItem("token");
    },
  }
</script>


<style scoped>
.navbar{
  margin-bottom: 15px;
  background-color: #090051;
  color: #c18e32;
}
#logo {
  width: 150px;
  margin-left: 20px;
  margin-right: 20px;
}
div.dropdown-menu.account-dropdown.show{
  
}
.dropdown-menu{
  /* --bs-dropdown-padding-x: .3rem;
  --bs-dropdown-padding-y: .25rem;
  border-radius: 0.5rem; */
  right: 0;
  left: auto;
  top: 2.8rem;
}
#search-button-navbar{
  background-color: #c18e32;
  border-radius: 0 0.5rem 0.5rem 0;
}
#search-button-navbar:hover{
  cursor: pointer;
}
.dropdown-item{
  border-color: black;
  /* border-radius: 0.5rem; */
}
.dropdown-item:hover{
  background-color: lightgrey;
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
  margin-left: 10px;

}
</style>

<template>
        <!-- <head>
          <favicon src="../../public/favicon-dark.ico"/>
        </head> -->
  <Navbar :cartCount="cartCount" 
  @resetCartCount="resetCartCount" 
  :token="token" 
  @getUsers="getUsers"
  :users="users"
  @clearUsers="clearUsers"
  ></Navbar>

  <router-view v-if="categories && products" style="min-height: 60vh;"
  :baseURL="baseURL"
  :categories="categories"
  :products="products"
  @fetchData="fetchData"
  @getUsers="getUsers"
  :users="users"
  :cartItems="cartItems"
  :totalCost="totalCost"
  :wishlists="wishlists"
  ></router-view>
  <Footer />
</template>

<script>
import Navbar from "./components/Navbar.vue";
import axios from 'axios';
import Footer from "./components/Footer.vue";

export default {
  components: { Navbar, Footer },
  data() {
    return {
      baseURL : "http://localhost:8081",
      products: null,
      categories: null,
      cartCount: 0,
      token: null,
      users: null,
      cartItems: null,
      totalCost: 0,
      wishlists: null
    }
  },
  methods: {
    async fetchData() {

      // api call to get all the categories
      await axios.get(this.baseURL + "/category/list")
      .then(res => {
        this.categories = res.data
      }).catch((err) => console.log('err', err));

      // api call to get the products
      await axios.get(this.baseURL + "/product/list")
      .then(res => {
        this.products = res.data
      }).catch((err) => console.log('err', err));

      //fetch cart items if token is present ie. logged in
      if(this.token){
        await axios.get(`${this.baseURL}/cart/?token=${this.token}`)
        .then((res) => {
            const result = res.data;
            this.cartCount = result.cartItems.length;
          }).catch((err) => {console.log("err", err)});
      }

      //fetch all items in all carts as admin
      await axios.get(`${this.baseURL}/admin/all-cart-items/?token=${this.token}`)
      .then((res) => {
          const result = res.data;
          this.cartItems = result.cartItems;
          this.totalCost = result.totalCost;
      }).catch((err) => {console.log("err", err)});

      //fetch all items in wishlists as admin
      await axios.get(`${this.baseURL}/admin/all-wishlists/?token=${this.token}`)
      .then((res) => {
          this.wishlists = res.data;
      }).catch((err) => {console.log("err", err)});
    },


    resetCartCount(){
      this.cartCount = 0;
      this.$router.push({name: 'HomeView'});
    },

    getUsers(){
      //fetch users and their roles
      this.token = localStorage.getItem("token");
      axios.post(`${this.baseURL}/admin/users/?token=${this.token}`)
      .then((res) => {
      this.users = res.data;
      }).catch((err) => {console.log("err", err)});
    },
    clearUsers(){
      this.users = null
    }
  },
  mounted() {
    this.fetchData();
    this.getUsers();
    this.token = localStorage.getItem("token");
  }
};
</script>

<style>
html{
  overflow-y: scroll;
  transition: all 1s ease-in-out 0s;
  
}
div{
  font-family: "Georgia, 'Times New Roman', Times, serif;"
}
#app{
  margin-top: 8.4rem;
  transition: all 1s ease-in-out 0s;
}
div{
  
}

</style>
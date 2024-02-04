<template>
  <head>
    <!-- our project just needs Font Awesome Solid + Brands -->
    <link href="../src/assets/fontawesome-free-6.5.1-web/css/fontawesome.css" rel="stylesheet">
    <link href="../src/assets/fontawesome-free-6.5.1-web/css/brands.css" rel="stylesheet">
    <link href="../src/assets/fontawesome-free-6.5.1-web/css/ css/solid.css" rel="stylesheet">
  </head>
  <Navbar :cartCount="cartCount" @resetCartCount="resetCartCount" :token="token" :admin="admin" @getUsers="getUsers"></Navbar>
  <router-view v-if="categories && products" style="min-height: 60vh;"
  :baseURL="baseURL"
  :categories="categories"
  :products="products"
  @fetchData="fetchData"
  @getUsers="getUsers"
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
        axios.get(`${this.baseURL}/cart/?token=${this.token}`)
        .then((res) => {
            const result = res.data;
            this.cartCount = result.cartItems.length;
          }).catch((err) => {console.log("err", err)});
      }
    },
    resetCartCount(){
      this.cartCount = 0;
      this.$router.push({name: 'HomeView'});
    },
    getUsers(){
      //fetch users and their roles
      axios.post(`${this.baseURL}/admin/users/?token=${this.token}`)
      .then((res) => {
      this.users = res.data;
      }).catch((err) => {console.log("err", err)});
    },
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
}

</style>
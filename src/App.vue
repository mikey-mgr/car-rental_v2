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
  :baseURL="baseURL"
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
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle'


document.addEventListener('click', function(e) {
  // get the navbar element
  let navbar = document.getElementById('navbarSupportedContent');
  // check if the target element is inside the navbar or not
  if (!e.target.closest('.navbar')) {
    // if not, toggle the navbar collapse
    let bsCollapse = new bootstrap.Collapse(navbar, {toggle: false});
    bsCollapse.hide();
  }
});
document.addEventListener('scroll', function(){
  let navbar = document.getElementById('navbarSupportedContent');
  let bsCollapse = new bootstrap.Collapse(navbar, {toggle: false});
    bsCollapse.hide();
})

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
      await axios.get(this.baseURL + "/category/list", { withCredentials: true })
      .then(res => {
        this.categories = res.data
      }).catch((err) => console.log('err', err));

      // api call to get the products
      await axios.get(this.baseURL + "/product/list", { withCredentials: true })
      .then(res => {
        this.products = res.data
      }).catch((err) => console.log('err', err));

      //fetch cart items if token is present ie. logged in
      if(this.token){
        await axios.get(`${this.baseURL}/cart/?token=${this.token}`, { withCredentials: true })
        .then((res) => {
            const result = res.data;
            this.cartCount = result.cartItems.length;
          }).catch((err) => {console.log("err", err)});
      }

      //fetch all items in all carts as admin
      await axios.get(`${this.baseURL}/admin/all-cart-items/`, { withCredentials: true })
      .then((res) => {
          const result = res.data;
          this.cartItems = result.cartItems;
          this.totalCost = result.totalCost;
      }).catch((err) => {console.log("err", err)});

      //fetch all items in wishlists as admin
      await axios.get(`${this.baseURL}/admin/all-wishlists/`, { withCredentials: true })
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
      axios.get(`${this.baseURL}/admin/users/`, { withCredentials: true })
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
  font-family: Akrobat-Regular, sans-serif
}
#app{
  margin-top: 8.4rem;
}
div{
  
}

</style>
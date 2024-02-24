<template>
    <div class="container" v-if="users">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="pt-4 pb-4">Admin Categories Page</h3>
          <router-link :to="{ name: 'AddCategory' }">
            <button class="btn btn-add-cat" style="float:right">Add Category</button>
          </router-link>
        </div>
      </div>
      <div class="row justify-content-evenly">
        <div
          v-for="category of categories"
          :key="category.id"
          class="col-xl-4 col-md-6 col-12 pt-3 d-flex"
        >
          <CategoryBox :category="category"></CategoryBox>
        </div>
      </div>
    </div>
  </template>
  <script>
  import CategoryBox from "../../components/Category/CategoryBox.vue";
  export default {
    name: "AdminCategory",
    props:["categories", "users"],
    components: { CategoryBox },
    data() {
      return {
        baseURL: "http://localhost:8081",
      };
    },
    methods: {
    },
    mounted() {},
  };
  </script>
<style scoped>
.btn-add-cat{
  border-color: #c18e32;
  background-color: #c18e32;
  color: white;
}
.btn-add-cat:hover{
  color: black;
  background-color: white;
}
</style>
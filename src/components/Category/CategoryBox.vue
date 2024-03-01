<template>
    <div class="card w-100 h-100" style="margin-top: 10px; width: 18rem">
      <div class="embed-responsive embed-responsive-16by9">
        <!-- dynamic image -->
        <img
          class="card-img-top embed-responsive-item"
          :src="category.imageUrl"
          alt="Category Image"
        />
        <!-- static image -->
        <!-- <img
          class="card-img-top embed-responsive-item"
          src="../../assets/AppImages/cars/fortuner2020.jpg"
          alt="Category Image"
        /> -->
      </div>
      <div class="card-body">
        <router-link :to="{name: 'ListProducts', params: {id: category.id}}">
          <h5 class="card-title">{{ category.categoryName }}</h5>
        </router-link>
        
        <p class="card-text">
          {{ category.description }}
        </p>
        <router-link :to="{name: 'EditCategory', params: {id: category.id}}"
                     v-show="$route.name == 'AdminCategory'">
          <button class="btn btn-primary edit-cat">Edit</button>
        </router-link>
      </div>
    </div>
  </template>
  <script>
  export default {
    name: "CategoryBox",
    props: ["category"],
    methods: {},
  };
  </script>
  
  <style scoped>
  .card-img-top {
    object-fit: cover;
  }
  a {
    text-decoration: none;
  }
  .edit-cat{
    background-color: #c18e32;
    color: white;
    border-color: #c18e32;
  }
  </style>  
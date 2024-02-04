<template>
    <div class="card h-100 w-100" style="width: 18rem">
        <div class="embed-responsive embed-responsive-16by9">
            <img
                class="card-img-top embed-responsive-item img-thumbnail"
                src="../assets/AppImages/benz.jpg"
                alt="Card image cap"
            />
        </div>
        <div class="card-body">
            <router-link :to="{name:'ProductDetails', params: {id: product.id}}">
                <h5 class="card-title">{{ product.name }}</h5>
            </router-link>
            <!-- <strong class="card-text">${{ product.price }}.00</strong> -->
            <p class="card-text">
                {{ product.description.substring(0, 65) }}...
            </p>
            <router-link :to="{name: 'EditProduct', params: {id: product.id}}" v-show="$route.name == 'AdminProduct'" >
                <button class="btn btn-primary edit-prod">Edit</button>
            </router-link>
        </div>
    </div>
</template>
<script>
    export default {
        name: "ProductBox",
        props: ["product"]
    }
</script>
<style scoped>
    .card-img-top {
        object-fit: cover;
    }
    a {
        text-decoration: none;
    }
    .card-title {
        color: #484848;
    }
    .edit-prod{
      background-color: #c18e32;
      color: white;
      border-color: #c18e32;
    }
</style>
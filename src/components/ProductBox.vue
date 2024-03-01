<template>
    <div class="card h-100 w-100" style="width: 18rem; min-height: 18rem;">
        <div class="embed-responsive embed-responsive-16by9">
            <!-- dynamic image -->
            <img
                class="card-img-top embed-responsive-item"
                :src="product.imageURL"
                alt="Vehicle Image"
                title="Click on the Vehicle name to view details"
            />
            <!-- static image -->
            <!-- <img
                class="card-img-top embed-responsive-item"
                src="../assets/AppImages/cars/benz.jpg"
                alt="Vehicle image"
                title="Click on the Vehicle name to view details"
            /> -->
        </div>
        <div class="card-body">
            <router-link :to="{name:'ProductDetails', params: {id: product.id, name: product.name}}" title="Click to view more details">
                <h5 class="card-title">{{ product.name }}</h5>
            </router-link>
            <!-- <strong class="card-text">${{ product.price }}.00</strong> -->
            <p class="card-text">
                {{ product.description.substring(0, 65) }}...
            </p>
            <router-link :to="{name: 'EditProduct', params: {id: product.id}}"
                v-show="$route.name == 'AdminProduct' || role == 'ADMIN'" >
                <button class="btn btn-primary edit-prod mr-2">Edit</button>
            </router-link>
            <router-link :to="{name:'ListProducts', params: {id: product.categoryId}}" title="Click to view the category">
                <h5 class="float-right">{{ categoryName }}</h5>
            </router-link>
        </div>
    </div>
</template>
<script>

    export default {
        name: "ProductBox",
        props: ["product", "role", "categoryName"],
        data() {
            return {
                
            }
        },
        methods:{

        }
    }
</script>
<style scoped>
    .card-img-top {
        object-fit: cover;
    }
    a {
        text-decoration: none;
    }
    .edit-prod{
      background-color: #c18e32;
      color: white;
      border-color: #c18e32;
    }
    .float-right{
        font-size: medium;
        margin: 0;
    }
</style>
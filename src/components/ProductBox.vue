<template>
    <div class="card h-100 w-100" style="width: 18rem; min-height: 18rem;">
        <div class="embed-responsive embed-responsive-16by9">
            <img
                class="card-img-top embed-responsive-item"
                src="../assets/AppImages/benz.jpg"
                alt="Card image cap"
                title="Click on the Vehicle name to view details"
            />
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
        </div>
    </div>
</template>
<script>

    export default {
        name: "ProductBox",
        props: ["product", "role"],
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
    .card-title {
        color: #484848;
    }
    .edit-prod{
      background-color: #c18e32;
      color: white;
      border-color: #c18e32;
    }
</style>
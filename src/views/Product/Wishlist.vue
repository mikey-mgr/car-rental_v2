<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 v-if="products" class="pt-3">Your Wishlist</h4>
                

            </div>
        </div>
        <!-- display products -->
        <div class="row">
            <div v-for="product of products" :key="product.id"
            class="col-md-6 col-xl-4 col-12 pt-3 d-flex">
                <ProductBox :product="product"/>
            </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios';
import ProductBox from '@/components/ProductBox.vue';

export default {
    name: 'WishList',
    props: ["baseURL"],
    component: {ProductBox},
    data() {
        return {
            token: null,
            products: null,
        };
    },
    methods: {
        fetchWishlist() {
            axios.get(`${this.baseURL}/wishlist/${this.token}`)
                .then((data) => {
                this.products = data.data;
            }).catch((err) => {
                console.log('err', err);
            });
        }
    },
    mounted() {
        this.token = localStorage.getItem("token");
        this.fetchWishlist();
    },
    components: { ProductBox }
}
</script>


<style scoped>

</style>
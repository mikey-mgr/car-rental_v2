<template>
    <div class="container">
        <div class="row justify-content-center align-items-center">
            <div class="col-12 text-center">
                <h4 class="pt-4">{{ category.categoryName }}</h4>
            </div>
            <div class="row align-items-center">
                <!-- <div v-for="(product, productSize) in filteredProds" :key="productSize"> -->
                <div v-for="product of filteredProds" :key="product.id"
                    class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
                    <ProductBox :product="product"></ProductBox>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ProductBox from '@/components/ProductBox.vue';
import axios from 'axios';

export default {
    name: 'ListProducts',
    props: ["products", "categories", "baseURL"], 
    components: { ProductBox },

    data() {
        return {
            category: "",
            filteredProds: "",
            id: ""
        };
    },
    methods: {
        async getProducts(){
            //API call to get FilteredProducts
            axios({
                method: "get",
                url: `${this.baseURL}/category/show/${this.id}`,
                data: JSON.stringify(this.filteredProds),
                headers: {
                    "Content-Type": "application/json",
                },
            }).then(result => {
                this.filteredProds = result.data
            }).catch((err) => console.log('Error: ', err));
        }
    },

    mounted() {
        this.id = this.$route.params.id;
        this.category = this.categories.find(category => category.id == this.id);
        // this.filteredProds = this.products.find(filteredProds => filteredProds.categoryId == this.id);
        this.getProducts();
    },
}
</script>

<style>

</style>
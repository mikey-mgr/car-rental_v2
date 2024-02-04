<template>
    <div class="container">
        <div class="row">
            <div class="col-12 mt-4 text-center">
                <h4>Admin Products Page</h4>
                <router-link :to="{name: 'AddProduct'}" style="float: right">
                    <button class="btn btn-add-prod" >
                        Add Product
                    </button> 
                </router-link>
            </div>
        </div>
        <div class="row">
<!--            display all the products in productbox component-->
            <div v-for="product of products" :key="product.id"
                 class="col-md-6 col-xl-4 col-12 pt-3 d-flex">
                <ProductBox :product="product"/>
            </div>
        </div>
    </div>
</template>
<script>
    import ProductBox from "../../components/ProductBox";
    export default {
        name: "AdminProduct",
        components: {ProductBox},
        props:["products"]
    }
</script>

<style scoped>
.btn-add-prod{
  border-color: #c18e32;
  background-color: #c18e32;
  color: white;
}
.btn-add-prod:hover{
  color: black;
  background-color: white;
}

</style>
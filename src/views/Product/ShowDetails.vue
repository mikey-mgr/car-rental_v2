<template>
    <div class="container" v-if="product">
        <div class="row align-items-center pt-5">
            <!-- <div class="col-md-1"></div> -->
            <!-- display image -->
            <div class="col-md-6 col-12">
                <img src="../../assets/AppImages/demio.jpg" alt="Product image" class="img-fluid">
            </div>
            <!-- display product details -->
            <div class="col-md-6 col-12 pt-3 pt-md-0">
                <h4>{{ product.name }}</h4>
                <h6 class="category font-italic">{{ category.categoryName }}</h6>
                <h6 class="font-weight-bold">${{ product.price }}</h6>
                <p>{{ product.description }}</p>
                <p>{{ product.bookingStatus }}</p>

                <div class="d-flex flex-row justify-content-between">
                    <div class="input-group col-md-3 col-4 p-0">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Number of days</span>
                        </div>
                            <input type="number" class="form-control" v-model="quantity"/>
                    </div>
                    <div class="input-group col-md-3 col-4 p-2 py-1">
                        <button @click="addToCart" class="btn btn-primary add-to-cart-button">{{cartString}}</button>
                    </div>
                </div>
                <div class="features pt-3">
                    <h5><strong>Features</strong></h5>
                    <ul>
                        <li>6 speed gears</li>
                        <li>4x4</li>
                        <li>Manual</li>
                    </ul>
                </div>
                <button id="wishlist-button" class="btn mr-3 p-2 py-1" @click="addToWishlist">
                    {{wishlistString}}
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';

export default {
    
    data(){
        return{
            product: {},
            category: {},
            id: "",
            wishlistString: "Add To Wishlist",
            quantity: 1,
            cartString: "Book Now",
            inWishlist: false,
            inCart: false,
        }
    },
    name: "ProductDetails",
    props: ["baseURL", "products", "categories"],
    methods: {
        //async call activated when add to cart button is clicked
        async addToCart(){
            if(!this.token){
                //user isn's logged in
                swal({
                    text: "Please login or signup to add to cart",
                    icon: "warning"
                });
                return;
            }
            //logged in, so add item to cart
            await axios.post(`${this.baseURL}/cart/add?token=${this.token}`, {
                productId: this.id,    
                quantity: this.quantity,
            }).then((res) => {
                if(res.status == 201){
                    swal({
                        text: "Your car has been added to cart",
                        icon: "success"
                    });
                    this.cartString = "Added to cart",
                    this.$emit("fetchData")
                }
            }).catch((err) => console.error('err', err));

        },
        //async call activated when add to wishlist button is clicked
        async addToWishlist(){
            if(!this.token){
                //user isn's logged in
                swal({
                    text: "Please login to add item to wishlist",
                    icon: "warning"
                });
                return;
            }
            //logged in, so add item to wishlist
            await axios.post(`${this.baseURL}/wishlist/add?token=${this.token}`, {
                id: this.product.id,
            }).then((res) => {
                //if backend sucessfully adds to wishlist, change button text to confirm
                if(res.status === 201){
                    this.wishlistString ="Added to wishlist";
                    swal({
                    text: "Added to wishlist",
                    icon: "success"
                });
                }
            }).catch((err) => {console.log("err", err);
            });
        }
    },

    mounted() {
        this.id = this.$route.params.id;
        this.product = this.products.find(product => product.id == this.id);
        this.category = this.categories.find((category) => category.id == this.product.categoryId);
        this.token = localStorage.getItem("token");
    },
}
</script>

<style scoped>

.category{
    font-weight: 400;
}
#wishlist-button {
    border-radius: 0%;
    background-color: rgb(62, 0, 112);
    border-color: rgb(62, 0, 112);
    color: white;
} #wishlist-button:hover{
    background-color: white;
    color: black;
    
}
.add-to-cart-button{
    background-color: #f0c14b;
    color: black;
    border-color: #f0c14b;
}
.add-to-cart-button:hover{
    
    background-color: white;
    border-color: #f0c14b;
    color: black;
}
</style>
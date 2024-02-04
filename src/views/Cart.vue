<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pt-3">
                    Your Shopping Cart
                </h3>
                <!-- loop over cart items -->
                <div class="mt-2 pt-3"></div>
                <hr>
                    <div v-for="cartItem in cartItems" 
                        :key="cartItem.id"
                        class="row mt-2">
                        <div class="col-md-3 embed-responsive-16by9 justify-content-around">
                            <!-- <img :src="cartItem.product.imageURL" alt="" class="w-100"> -->
                            <img src="../assets/AppImages/demio.jpg" alt="" 
                            class="w-100 mb-4 card-image-top embed-responsive-item"
                            style="object-fit: cover;">
                        </div>
                        <!-- display product name and qty -->
                        <div class="col-md-5 px-3">
                            <div class="card-block">
                                <h6 class="card-title">
                                    <router-link class="text-decoration-none" :to="{name:'ProductDetails', params: {id: cartItem.product.id}}"
                                    >{{ cartItem.product.name }}
                                    </router-link>
                                </h6>
                                <p class="mb-0 font-weight-bold" id="item-price">$ {{ cartItem.product.price }} per unit</p>
                                <p class="mb-0" style="float: left;">Quantity: {{ cartItem.quantity }}</p>
                                <p class="mb-0" style="float: right;">
                                    Total : 
                                    <span class="font-weight-bold">
                                        $ {{ cartItem.quantity * cartItem.product.price }}
                                    </span>
                                </p>
                                <br>
                                <a href="#" @click="deleteItem(cartItem.id)" class="text-right text-decoration-none">
                                    Remove from Cart
                                </a>
                            </div>
                        </div>
                        <div class="col-2"></div>
                        <div class="col-12"><hr></div>
                </div>
                <!-- display total price -->
                <div class="total-cost pt-2 text-right">
                    <h5>Total : ${{ totalCost.toFixed(2) }}</h5>
                    <button @click="bookRental" v-show="totalCost" class="btn btn-primary confirm">Confirm Booking</button>
                </div>
            </div>
        </div>
        
    </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';

export default {
    name: 'CartView',
    props: ["baseURL"],

    data() {
        return {
            cartItems: [],
            token: null,
            totalCost: 0,
        }
    },

    methods:{
        bookRental(){
            this.$router.push({name: 'CheckoutPage'});
        },
        //fetch all items in cart
        listCartItems(){
            axios.get(`${this.baseURL}/cart/?token=${this.token}`)
            .then((res) => {
                const result = res.data;
                this.cartItems = result.cartItems;
                this.totalCost = result.totalCost;
            }).catch((err) => {console.log("err", err)});
        },
        //delete a cart item
        deleteItem(id){
            axios.delete(`${this.baseURL}/cart/delete/${id}?token=${this.token}`)
            .then((res) => {
                if(res.status == 200){
                    this.$router.go(0);
                } else {
                    swal({
                        text: "Item not deleted",
                        icon: "error"
                    })
                }
            }).catch((err) => console.log('err', err));
        }
    },
    mounted() {
        this.token = localStorage.getItem("token");
        this.listCartItems();
    },
}
</script>

<style scoped>
h4, h5{
    color: #484848;
    font-size: 700;
}

</style>
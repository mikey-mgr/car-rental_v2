<template>
    <div class="container p-3 mt-5 border" v-if="product">
        <div class="row align-items-center">
            <!-- display image, bootstrap carousel-->
            <div class="col-md-6 col-12">
                <div id="autoplayCarousel" class="carousel slide" data-bs-ride="troue">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                        <img src="../../assets/AppImages/ford.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                        <img src="../../assets/AppImages/car.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                        <img src="../../assets/AppImages/demio.jpg" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#autoplayCarousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#autoplayCarousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
            <!-- display product details -->
            <div class="col-md-6 col-12">
                <h4 class="border-bottom border-dark py-2">{{ product.name }}</h4>
                <h6 class="category font-style-italic">{{ category.categoryName }}</h6>
                <h6 class="fw-bold">${{ product.price }} per day</h6>
                <p>{{ product.description }}</p>
                <span v-if="product.bookingStatus=='Checked Out'" class="mb-3 badge rounded-pill text-bg-primary">{{ product.bookingStatus }}</span>
                <span v-if="product.bookingStatus=='Reserved'" class="mb-3 badge rounded-pill text-bg-info">{{ product.bookingStatus }}</span>
                <span v-if="product.bookingStatus=='Booking Confirmed'" class="mb-3 badge rounded-pill text-bg-success">{{ product.bookingStatus }}</span>
                <span v-if="product.bookingStatus=='Available'" class="mb-3 badge rounded-pill text-bg-warning">{{ product.bookingStatus }}</span>
                <span v-if="product.bookingStatus=='Unavailable'" class="mb-3 badge rounded-pill text-bg-dark">{{ product.bookingStatus }}</span>
                <form @submit="addToCart">
                    <div class="d-flex flex-row justify-content-between">
                        <div class="input-group input-group-parent p-0">
                            <div class="input-group col-lg-5 col-md-9 col-sm-5 p-0 mb-2">
                                <span class="input-group-text">Number of days</span>
                                <input type="number" min="1" max="30" id="days-input" class="form-control" v-model="quantity" required/>
                            </div>
                            <div class="input-group col-md-9 col-lg-7 col-sm-6 p-0 mb-2">
                                <span class="input-group-text">Date to book</span>
                                <input type="date" :min="minDate" :max="maxDate" id="date-input" class="form-control" v-model="bookedFor" required/>
                            </div>
                            <div class="col-12 p-0">
                                <button type="submit" :disabled="inCart"
                                    class="btn btn-primary add-to-cart-button">{{cartString}}
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="features pt-3">
                    <h5><strong>Features</strong></h5>
                    <ul>
                        <li>6 speed gears</li>
                        <li>4x4</li>
                        <li>Manual</li>
                    </ul>
                </div>
                <button v-show="!inWishlist" id="wishlist-button" class="btn mr-3" @click="addToWishlist" :disabled="addedToWishlist">
                    {{wishlistString}}
                </button>
                <button class="btn btn-danger mr-3" style="border-radius: 0%;" v-show="inWishlist" @click="removeWishlist(wishlistId)" :disabled="deletedFromWishlist">
                    {{wishlistString}}
                </button>

                            <!-- Modal to confirm booking -->
                <div class="modal fade" id="bookingModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content text-center">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirm Booking</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Your car has been added to cart.<br>View your cart to confirm your booking
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <router-link :to="{name: 'CartView'}"><button class="btn btn-primary" data-bs-dismiss="modal">View Cart</button></router-link>
                            </div>
                        </div>
                    </div> 
                </div>
                <!-- Modal to direct user to signin page -->
                <div class="modal fade " id="registerModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content text-center text-bg-dark-subtle">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Login or Register</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                {{ modalText}}
                            </div>
                            <div class="modal-footer">
                                <router-link :to="{name: 'SignupView'}"><button class="btn btn-primary" data-bs-dismiss="modal">Create account</button></router-link>
                                <router-link :to="{name: 'SigninView'}"><button class="btn btn-primary" data-bs-dismiss="modal">Login</button></router-link>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle'

export default {
    name: "ProductDetails",
    props: ["baseURL", "products", "categories"],
    data(){
        return{
            product: {},
            category: {},
            id: "",
            quantity: 1,
            bookedFor: null,
            wishlistString: "Add To Wishlist",
            cartString: "Book Now",
            addedToWishlist: false,
            deletedFromWishlist: null,
            inWishlist: false,
            inCart: false,
            cartItems: null,
            wishlist: null,
            wishlistId: null,
            modalText: null
            
        }
    },
    methods: {
        //fetch all items in cart n set cart button to disabled if product is present
        async getCart(){
            await axios.get(`${this.baseURL}/cart/?token=${this.token}`, { withCredentials: true })
            .then((res) => {
                const result = res.data;
                this.cartItems = result.cartItems;
            }).catch((err) => {console.log("err", err)});
            if(this.cartItems!=null){
                for(let i = 0;i < this.cartItems.length;this.cartItems[i++]){
                    if(this.id == this.cartItems[i].product.id){
                        this.inCart = true;
                        this.cartString = "Car booked"
                    }
                }
            }
            //sets button to disabled if vehicle is already reserved
            if(this.product.bookingStatus !='Available'){
                this.inCart = true;
            }
        },
        
        //fetch all items in wishlist n set wishlist button to disabled if product is present
        async getWishlist() {
            await axios.get(`${this.baseURL}/wishlist/${this.token}`, { withCredentials: true })
            .then((result) => {
                this.wishlist = result.data;
            }).catch((err) => {console.log('err', err)});
            if(this.wishlist!=null){
                for(let i = 0; i < this.wishlist.length; this.wishlist[i++]){
                    if(this.id == this.wishlist[i].productId){
                        this.wishlistString = 'Remove from wishlist';
                        this.inWishlist = true;
                        this.wishlistId = this.wishlist[i].id
                    }
                }
            }
        },

        //async call activated when add to cart button is clicked
        async addToCart(e){
            e.preventDefault();
            if(!this.token){
                //user isn't logged in
                let modal2 = document.getElementById('registerModal');
                let bsShowModal = new bootstrap.Modal(modal2, {toggle: false});
                bsShowModal.show();
                this.modalText = "Please login or create a new account to add booking";
                return;
            }
            //logged in, so add item to cart
            await axios.post(`${this.baseURL}/cart/add?token=${this.token}`, 
            {
                productId: this.id,    
                quantity: this.quantity,
                bookedFor: this.bookedFor
            }, { withCredentials: true }
            ).then((res) => {
                if(res.status == 201){
                    let modal1 = document.getElementById('bookingModal');
                    let bsShowModal = new bootstrap.Modal(modal1, {toggle: false});
                    bsShowModal.show();
                    this.cartString = "Added to bookings",
                    this.inCart = true,
                    this.$emit("fetchData")
                }
            }).catch((err) => console.error('err', err));
        },

        //async call activated when add to wishlist button is clicked
        async addToWishlist(){
            if(!this.token){
                //user isn't logged in
                let modal2 = document.getElementById('registerModal');
                let bsShowModal = new bootstrap.Modal(modal2, {toggle: false});
                bsShowModal.show();
                this.modalText = "Please login or create a new account to add to wishlist";
                return;
            }
            //logged in, so add item to wishlist
            await axios.post(`${this.baseURL}/wishlist/add?token=${this.token}`,
            {
                id: this.product.id,
            }, { withCredentials: true }
            ).then((res) => {
                //if backend sucessfully adds to wishlist, change button text to confirm
                if(res.status === 201){
                    this.wishlistString = "Added to wishlist";
                    this.addedToWishlist = true;
                    swal({
                    text: "Added to wishlist",
                    icon: "success"
                });
                }
            }).catch((err) => {console.log("err", err);
            });
        },

        //remove item from wishlist
        async removeWishlist(id){
            await axios.delete(`${this.baseURL}/wishlist/delete/${id}?token=${this.token}`, { withCredentials: true })
            .then((res) => {
                if(res.status == 200){
                    this.wishlistString = 'Removed from wishlist'
                    this.$emit("fetcData");
                    this.deletedFromWishlist = true;
                    swal({
                        text: "Car has been removed from wishlist",
                        icon: "success"
                    })
                } else {
                    swal({
                        text: "Item not deleted",
                        icon: "error"
                    })
                }
            }).catch((err) => console.log('err', err));
        },

        //set the midate for the date element
        minDate() {
            // Get the current date
            let today = new Date();
            // Format the date as yyyy-mm-dd
            let yyyy = today.getFullYear();
            let mm = today.getMonth() + 1; // January is 0
            let dd = today.getDate();
            if (mm < 10) {
                mm = "0" + mm;
            }
            if (dd < 10) {
                dd = "0" + dd;
            }
            return yyyy + "-" + mm + "-" + dd;
        },

        //set the maxdate for the date element
        maxDate() {
            // Get the current date
            let today = new Date();
            // Add 30 days to the date
            let after30Days = new Date(today.setDate(today.getDate() + 30));
            // Format the date as yyyy-mm-dd
            let yyyy = after30Days.getFullYear();
            let mm = after30Days.getMonth() + 1; // January is 0
            let dd = after30Days.getDate();
            if (mm < 10) {
                mm = "0" + mm;
            }
            if (dd < 10) {
                dd = "0" + dd;
            }
            return yyyy + "-" + mm + "-" + dd;
        },
    },

    mounted() {
        this.id = this.$route.params.id;
        this.product = this.products.find(product => product.id == this.id);
        this.category = this.categories.find((category) => category.id == this.product.categoryId);
        this.token = localStorage.getItem("token");
        this.getWishlist();
        this.getCart();
    },
}
</script>

<style scoped>
.d-block.w-100{
    height: 40vh;
    width: 50vh;
    object-fit: cover;
}
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
@media (min-width: 0px) and (max-width: 576px) {
      .input-group-parent{
        width: 15rem;
      }
}
</style>
<template>
    <div class="container" v-if="users">
        <div class="row justify-content-center">
            <div class="col-md-5 col-10">
                <h4 class="py-3">Edit Car</h4>
                <form v-if="product" @submit="editProduct">
                    <div class="form-group">
                        <label> Category</label>
                        <select class="form-control" v-model="product.categoryId" required>
                            <option v-for="category of categories"
                                    :key="category.id"
                                    :value="category.id"> {{category.categoryName}}</option>

                        </select>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" v-model="product.name" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea type="text" class="form-control" v-model="product.description" required />
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" class="form-control" v-model="product.imageURL" required/>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" class="form-control" v-model="product.price" required/>
                    </div>
                    <div class="form-group">
                        <label>Booking Status</label>
                        <select class="form-control" v-model="product.bookingStatus" required>
                            <option>Available</option>
                            <option>Reserved</option>
                            <option>Booking Confirmed</option>
                            <option>Checked Out</option>
                            <option>Unavailable</option>
                        </select>
                    </div>
                    <div class="col-12 mt-3">
                        <button type="submit" class="btn btn-primary mx-2">Submit</button>
                        <button class="btn btn-danger" @click="deleteProduct">
                            Delete
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios'
    import swal from 'sweetalert'
    export default {
        props: ["baseURL", "categories", "products","users"],
        data() {
            return {
                product: null,
                id: null
            }
        },
        methods: {
            async editProduct(e) {
                e.preventDefault();
                await axios.post(`${this.baseURL}/product/update/${this.id}`, this.product, { withCredentials: true })
                    .then(() => {
                        this.$emit("fetchData");
                        this.$router.push({name: 'ListProducts', params: {id: this.product.categoryId}});
                        swal({
                            text: "Car has been updated successfully",
                            icon: "success"
                        })
                    }).catch(err => console.log('err', err));
            },
            async deleteProduct(){
                await axios.delete(`${this.baseURL}/product/delete/${this.id}`, { withCredentials: true })
                .then(() =>{
                    this.$emit("fetchData");
                    swal({
                        text: "Car has been deleted successfully",
                        icon: "success"
                    });
                    window.location.replace("/admin/products");
                }).catch((err) => console.log('err', err))
            }
        },
        mounted() {
            this.id = this.$route.params.id;
            this.product = this.products.find(product => product.id == this.id)
        }
    }
</script>

<style scoped>
.form-group{
    padding-top: 14px;
}
</style>
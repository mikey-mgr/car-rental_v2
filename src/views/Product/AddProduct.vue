<template>
    <div class="container" v-if="users">
        <div class="row justify-content-center pt-3">
            <div class="col-md-5 col-10">
                <h4 class="text-center">Add New Vehicle</h4>
                <form class="form-group" @submit="addProduct">
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" v-model="categoryId" required>
                            <option v-for="category in categories" :key="category.id"
                                    :value="category.id">{{ category.categoryName }}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" v-model="name" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea type="text" v-model="description" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label>Image Url</label>
                        <input type="text" rows="3" v-model="imageURL" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" v-model="price" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Booking Status</label>
                        <select class="form-control" v-model="bookingStatus" required>
                            <option>Available</option>
                            <option>Reserved</option>
                            <option>Booking Confirmed</option>
                            <option>Checked Out</option>
                            <option>Unavailable</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary btn-add-prod mt-3">Add Vehicle</button>
                </form>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios'
    import swal from 'sweetalert'
    export default {
        props: ["baseURL", "categories", "users"],
        data() {
            return {
                id: "",
                categoryId: "",
                name: "",
                description: "",
                imageURL: "",
                price: "",
                bookingStatus: ""
            }
        },
        methods: {
            addProduct(e) {
                e.preventDefault();
                const newProduct = {
                    categoryId: this.categoryId,
                    description: this.description,
                    name: this.name,
                    imageURL: this.imageURL,
                    price: this.price,
                    bookingStatus: this.bookingStatus
                };

                axios.post(this.baseURL+"/product/add", newProduct)
                .then(() => {
                    swal({
                        text: "Vehicle added successfully",
                        icon: "success"
                    });
                    window.location.replace("/admin/products")
                }).catch((err)=> {
                    console.log("err", err);
                })


            }
        }
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
.form-group{
    padding-top: 14px;
}
</style>

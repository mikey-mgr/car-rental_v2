<template>
    <div class="container" v-if="users">
        <div class="row justify-content-center">
            <form class="row px-3" v-if="product" @submit="editProduct">
                <h4 class="py-3">Edit Car</h4>
                <div class="form-group col-lg-6">
                    <label> Category</label>
                    <select class="form-control" v-model="product.categoryId" required>
                        <option v-for="category of categories"
                                :key="category.id"
                                :value="category.id"> 
                            {{category.categoryName}}
                        </option>

                    </select>
                </div>
                <div class="form-group col-lg-6">
                    <label>Name</label>
                    <input type="text" class="form-control" v-model="product.name" required/>
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <textarea type="text" class="form-control" v-model="product.description" required/>
                </div>
                <div class="form-group col-md-4">
                    <label>Image URL</label>
                    <input type="text" class="form-control" v-model="product.imageURL" required/>
                </div>
                <div class="form-group col-md-4">
                    <label>Price</label>
                    <input type="number" class="form-control" v-model="product.price" required/>
                </div>
                <div class="form-group col-md-4">
                    <label>Booking Status</label>
                    <select class="form-control" v-model="product.bookingStatus" required>
                        <option>Available</option>
                        <option>Reserved</option>
                        <option>Booking Confirmed</option>
                        <option>Checked Out</option>
                        <option>Unavailable</option>
                    </select>
                </div>
                <div class="input-group">
                    <!-- features edit -->
                    <label class="col-12 px-0" for="">Features</label>
                    <div class="input-group mb-2">
                        <div v-for="(feature, index) in this.features" :key="index" class="input-group col-md-6 col-lg-4 mb-3 p-0 border border-0">
                            <input v-model="features[index]" type="text" maxlength="100" placeholder="Enter a feature" class="form-control" style="border-radius: 0;" required>
                            <a v-if="canRemoveFeature" class="btn btn-outline-danger" @click="removeFeature(index)" style="border-radius: 0;">Remove</a>
                        </div>
                    </div>
                    <div class="col-12 mb-4 px-0">
                        <a v-if="canAddFeature" class="btn btn-primary" @click="addFeature" style="border-radius: 2px;">Add Feature</a>
                    </div>
                    <!-- carousel images edit -->
                    <label class="col-12 px-0" for="">Vehicle images</label>
                    <div class="input-group mb-2">
                        <div v-for="(image, index) in this.carouselImg" :key="index" class="input-group col-md-6 col-lg-4 mb-3 p-0 border border-0">
                            <input v-model="carouselImg[index]" type="text" placeholder="Enter an image url" class="form-control" style="border-radius: 0;" required>
                            <a v-if="canRemoveImg" class="btn btn-outline-danger" @click="removeImg(index)" style="border-radius: 0;">Remove</a>
                        </div>
                    </div>
                    <div class="col-12 mb-4 px-0">
                        <a v-if="canAddImg" class="btn btn-primary" @click="addImg" style="border-radius: 2px;">Add Image</a>
                    </div>
                </div>
                <div class="col-12 mt-3">
                    <button type="submit" class="btn btn-success mx-2">Submit</button>
                    <button class="btn btn-danger" @click="deleteProduct">
                        Delete
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script>
    import axios from 'axios'
    import swal from 'sweetalert'
    export default {
    props: ["baseURL", "categories", "products", "users"],
    data() {
        return {
            product: null,
            id: null,
            features: ["", "", ""],
            carouselImg: ["", "", "", ""]
        }
    },

    computed: {
        canAddFeature(){
            return this.features.length < 6;
        },
        canRemoveFeature(){
            return this.features.length > 3;
        },
        canAddImg(){
            return this.carouselImg.length < 12;
        },
        canRemoveImg(){
            return this.carouselImg.length > 4;
        },
    },
    methods: {
        addFeature(){
            if(this.canAddFeature){
                this.features.push("");
            }
        },

        removeFeature(index){
            if(this.canRemoveFeature){
                this.features.splice(index, 1)
            }
        },
        
        ifFeaturesEmpty(){
            if(!this.product.features){
                this.features = ["", "", ""]
            } else this.features = this.product.features;
        },
        
        addImg(){
            if(this.canAddImg){
                this.carouselImg.push("");
            }
        },

        removeImg(index){
            if(this.canRemoveImg){
                this.carouselImg.splice(index, 1)
            }
        },
        
        ifImgsEmpty(){
            if(!this.product.carousel_imgs){
                this.carouselImg = ["", "", "", ""]
            } else this.carouselImg = this.product.carousel_imgs;
        },

        async editProduct(e) {
            e.preventDefault();
            this.product.features = this.features;
            this.product.carousel_imgs = this.carouselImg;
            await axios.post(`${this.baseURL}/product/update/${this.id}`, this.product)
                .then((res) => {
                    if(res.data.message=="Product has been updated"){
                        this.$emit("fetchData");
                        this.$router.push({name: 'ListProducts', params: {id: this.product.categoryId}});
                        swal({
                            text: "Car has been updated successfully",
                            icon: "success"
                        })
                    } else swal({
                        text: 'Something went wrong',
                        icon: 'warning'
                    });
                }).catch(err => console.log('err', err));
        },
        async deleteProduct(){
            await axios.delete(`${this.baseURL}/product/delete/${this.id}`)
            .then((res) =>{
                if(res.data.message == "Product deleted successfully"){
                    this.$emit("fetchData");
                    swal({
                        text: "Car has been deleted successfully",
                        icon: "success"
                    });
                    window.location.replace("/admin/vehicles");
                } else {
                    swal({
                        text: 'Something went wrong',
                        icon: 'warning'
                    })
                }
            }).catch((err) => console.log('err', err))
        }
    },
    mounted() {
        this.id = this.$route.params.id;
        this.product = this.products.find(product => product.id == this.id);
        this.ifFeaturesEmpty();
        this.ifImgsEmpty();
    }
}
</script>

<style scoped>
.form-group{
    padding-top: 14px;
}
label{
    font-weight: bold;
}
</style>
<template>
    
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3>Add Category</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form action="">
                    <div class="form-group">
                        <label for="">Name</label>
                        <input type="text" class="form-control" v-model="categoryName">
                    </div>
                    <div class="form-group">
                        <label for="">Description</label>
                        <textarea type="text" class="form-control" v-model="description"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="">Image</label>
                        <input type="text" class="form-control" v-model="imageUrl">
                    </div>
                    <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
            
        </div>
    </div>
</template>

<script>
const axios = require("axios");
const sweetalert = require("sweetalert");

export default {
    
    data() {
        return {
            categoryName: "",
            description: "",
            imageUrl: ""
        }
    },
    methods: {
        addCategory(){
            console.log(this.categoryName, this.description);

            const newCategory = {
                categoryName: this.categoryName,
                description: this.description,
                imageUrl: this.imageUrl
            };

            const baseURL = "http://localhost:8081";

            axios ({
                method: "post",
                url:    `${baseURL}/category/create`,
                data:    JSON.stringify(newCategory),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(()  =>  {
                sweetalert({
                    text: "Category Added Successfully",
                    icon: "success"
                });

            }).catch(err =>{
                console.log(err);
            })

        },
    },
}
</script>

<style scoped>
    
</style>
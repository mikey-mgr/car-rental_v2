<template>
    <div class="grid text-center pt-5" style="--bs-columns: 4; --bs-gap: 5rem;">
        <router-link :to="{name: 'AdminCategory'}">
            <button class="btn btn-primary btn-lg g-col-2 m-5" type="button">Admin Category</button>
        </router-link>
        <router-link :to="{name: 'AdminProduct'}">
            <button class="btn btn-primary btn-lg g-col-2 m-5" type="button">Admin Product</button>
        </router-link> 
        <div class="col-12"></div>    
        <router-link :to="{name: 'UsersView'}">
            <button class="btn btn-primary btn-lg g-col-2 m-5" type="button">Users</button>
        </router-link>
    </div>
</template>


<script>
export default {
    name: "AdminView",

}
</script>


<style>
    

</style>
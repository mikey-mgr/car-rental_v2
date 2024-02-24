<template>
    <div v-if="users" class="container pt-5 text-center">
        <div class="p-3">
            <router-link :to="{name: 'AdminCategory'}">
                <button class="btn btn-primary btn-lg" type="button">Admin Category</button>
            </router-link>
        </div>
        <div class="p-3">
            <router-link :to="{name: 'AdminProduct'}">
                <button class="btn btn-primary btn-lg" type="button">Admin Cars</button>
            </router-link>
        </div>
        <div class="p-3">
            <router-link :to="{name: 'UsersView'}">
                <button class="btn btn-primary btn-lg" type="button">Users</button>
            </router-link>
        </div>
    </div>
</template>


<script>
export default {
    name: "AdminView",
    props:["users"]

}
</script>


<style>
    

</style>
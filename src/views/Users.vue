<template>
    <div class="containter mg-">
        <ol class="list-group list-group-numbered">
            <li v-for="user of users" :key="user.id"
                class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div class="fw-bold">{{ user.firstName }}</div>
                    {{ user.lastName }}
                </div>
                <span class="badge text-bg-primary rounded-pill">14</span>
            </li>
        </ol>

        
    </div>
</template>
<!-- 
"id": 0,
"firstName": "string",
"lastName": "string",
"email": "string",
"role": 0 -->
<script>
export default {
    name: 'UsersView',
    props: ['users'],
}
</script>

<style>


</style>
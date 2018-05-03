<template>
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab"
               aria-controls="pills-home" aria-selected="true">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab"
               aria-controls="pills-profile" aria-selected="false">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab"
               aria-controls="pills-contact" aria-selected="false">Contact</a>
        </li>
    </ul>
    <!--<router-link to="/" tag="li" active-class="active" exact><a>Home</a></router-link>-->
    <!--<router-link to="/user" tag="li" active-class="active"><a>User</a></router-link>-->
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>
<template>
    <div class="container">
        <app-Resource-List></app-Resource-List>
    </div>
</template>

<script>
    import ResourceList from './ResourceList';

    export default {
        name: "SharePage",
        components: {
            appResourceList: ResourceList
        }
    }
</script>

<style scoped>

</style>
<template>
    <div class="container">
        <app-Resource-Detail></app-Resource-Detail>
        <app-Resource-List></app-Resource-List>
    </div>
</template>

<script>
    import ResourceList from './ResourceList';
    import ResourceDetail from './ResourceDetail';

    export default {
        name: "SharePage",
        components: {
            appResourceList: ResourceList,
            appResourceDetail: ResourceDetail
        }
    }
</script>

<style scoped>

</style>
<template>
    <p>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample1"
                aria-controls="multiCollapseExample2" aria-expanded="false">Toggle first element
        </button>
        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2"
                aria-controls="multiCollapseExample1" aria-expanded="false">Toggle second element
        </button>
    </p>
</template>

<script>
    export default {
        name: "GamesHeader",
        methods: {},
        created: function () {
            this.$axios.get("/3dm/" + value).then(res => {
                this.pageData = res.data;
            }).catch(error => console.log(error))
        }
    }
</script>

<style scoped>

</style>
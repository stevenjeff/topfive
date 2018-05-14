<template>
    <div class="col">
        <p>
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample1"
                    aria-controls="multiCollapseExample2" aria-expanded="false">Toggle first element
            </button>
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2"
                    aria-controls="multiCollapseExample1" aria-expanded="false">Toggle second element
            </button>
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse"
                    aria-controls="multiCollapseExample1 multiCollapseExample2" aria-expanded="false">Toggle both
                elements
            </button>
        </p>
        <div class="row">
            <div class="col">
                <div class="collapse multi-collapse" id="multiCollapseExample1">
                    <div class="card card-body">
                        testaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "GamesHeader",
        methods: {}
    }
</script>

<style scoped>

</style>
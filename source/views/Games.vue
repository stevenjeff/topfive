<template>
    <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
        <table class="table table-striped table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">名称</th>
                <th scope="col">点击率</th>
                <th scope="col">链接</th>
            </tr>
            </thead>
            <tbody>
            <template v-if="pageData">
                <tr v-for="(rowData,index) in pageData" :key="rowData">
                    <th scope="row">{{++index}}</th>
                    <td>{{rowData.name}}</td>
                    <td>{{rowData.rate}}</td>
                    <td><a :href="rowData.href" target="_blank">打开</a></td>
                </tr>
            </template>
            </tbody>
        </table>
    </div>
</template>
<script>
    export default {
        name: "Games",
        data: function () {
            return {
                pageData: []
            };
        },
        created: function () {
            this.$axios.get("/3dm").then(res => {
                this.pageData = res.data;
            }).catch(error => console.log(error))
        }
    }
</script>
<style scoped>

</style>
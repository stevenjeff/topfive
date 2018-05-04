<template>
    <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
        <table class="table table-striped table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            <template v-if="pageData">
                <tr v-for="rowData in pageData" :key="rowData">
                    <td>{{rowData.name}}</td>
                    <td>{{rowData.rate}}</td>
                    <td><a :href="rowData.href" target="_blank"></a></td>
                </tr>
            </template>
            </tbody>
        </table>
    </div>
</template>
<script>
    export default {
        name: "Games"
    }
</script>
<style scoped>

</style>
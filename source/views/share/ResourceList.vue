<template>
    <BootstrapTable :columns="columns"
                    :values="values"
                    :show-filter="true"
                    :show-column-picker="true"
                    :sortable="true"
                    :paginated="true"
                    :multi-column-sortable=true
                    :filter-case-sensitive=false
    ></BootstrapTable>
</template>

<script>
    export default {
        name: "ResourceList",
        components: {
            BootstrapTable: VueBootstrapTable
        },
        data: function () {
            return {
                columns: [
                    {
                        title: "id",
                    },
                    {
                        title: "name",
                        visible: true,
                        editable: true,
                    },
                    {
                        title: "age",
                        visible: true,
                        editable: true,
                    },
                    {
                        title: "country",
                        visible: true,
                        editable: true,
                    }
                ],
                values: [
                    {
                        "id": 1,
                        "name": "John",
                        "country": "UK",
                        "age": 25,
                    },
                    {
                        "id": 2,
                        "name": "Mary",
                        "country": "France",
                        "age": 30,
                    },
                    {
                        "id": 3,
                        "name": "Ana",
                        "country": "Portugal",
                        "age": 20,
                    }
                ]
            };
        }
    }
</script>

<style scoped>

</style>
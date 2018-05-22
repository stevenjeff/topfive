<template>
    <div class="collapse tab-pane fade show active" id="multiCollapseExample1" role="tabpanel"
         aria-labelledby="pills-home-tab">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">日期</label>
            </div>
            <select class="custom-select" id="inputGroupSelect01" v-model="selectedValue">
                <option v-for="(rowData,index) in dateRange" :key="index" :value="rowData">近{{rowData}}天</option>
            </select>
        </div>
        <section>
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">名称</th>
                    <th scope="col">创建时间</th>
                    <th scope="col">点击率</th>
                    <th scope="col">链接</th>
                </tr>
                </thead>
                <tbody>
                <template v-if="pageData">
                    <tr v-for="(rowData,index) in pageData" :key="index">
                        <th scope="row">{{++index}}</th>
                        <td>{{rowData.name}}</td>
                        <td>{{rowData.createDate}}</td>
                        <td>{{rowData.rate}}</td>
                        <td><a :href="rowData.href" target="_blank">打开</a></td>
                    </tr>
                </template>
                </tbody>
            </table>
        </section>
    </div>
</template>
<script>
    import {mapGetters} from 'vuex';
    import {store} from '../../vuex/store';
    import * as types from '../../vuex/types';

    export default {
        name: "Games",
        data: function () {
            return {
                selectedValue: 7
            };
        },
        computed: {
            ...mapGetters({
                dateRange: types.DATE_RANGE_GETTER,
                pageData: types.PAGE_DATA_GETTER,
                site: types.SITE_CHANGE_GETTER
            })
        },
        methods: {},
        watch: {
            selectedValue: function (value) {
                let payload = {
                    key: this.site,
                    interval: value
                };
                store.dispatch(types.ACTION_GAMES_DATA_CHANGE, payload)
            }
        }
    }
</script>
<style scoped>

</style>
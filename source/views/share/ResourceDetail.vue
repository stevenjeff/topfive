<template>
    <el-dialog title="收货地址" :visible.sync="showPanel">
        <el-form :model="form">
            <el-form-item label="资源名称" :label-width="formLabelWidth">
                <el-input v-model="form.name" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="资源类型" :label-width="formLabelWidth">
                <el-select v-model="form.type" placeholder="请选择资源类型">
                    <el-option label="游戏" value="0"></el-option>
                    <el-option label="电影" value="1"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="资源地址" :label-width="formLabelWidth">
                <el-input v-model="form.url" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="作者" :label-width="formLabelWidth">
                <el-input v-model="form.author" auto-complete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="hidePage()">取 消</el-button>
            <el-button type="primary" @click="hidePage()">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
    import {mapGetters} from 'vuex';
    import {store} from '../../vuex/store';
    import * as types from '../../vuex/types';

    export default {
        name: "ResourceDetail",
        created: function () {
        },
        computed: {
            ...mapGetters({
                showAddForm: types.RESOURCE_SHOW_PAGE_GETTER
            })
        },
        watch: {
            showPanel: function (value) {
                if (!value) {
                    store.commit(types.MUTATE_SHOW_PAGE_RESOURCE, value);
                }
            },
            showAddForm: function (value) {
                this.showPanel = value;
            }
        },
        data: function () {
            return {
                form: {
                    name: '',
                    type: '',
                    url: '',
                    author: ''
                },
                formLabelWidth: '120px',
                showPanel: false
            };
        },
        methods: {
            hidePage() {
                store.commit(types.MUTATE_SHOW_PAGE_RESOURCE, false);
            }
        }
    }
</script>

<style scoped>

</style>
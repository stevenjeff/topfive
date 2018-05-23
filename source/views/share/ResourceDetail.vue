<template>
    <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
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
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
    export default {
        name: "ResourceDetail",
        data: function () {
            return {
                form: {
                    name: '',
                    type: '',
                    url: '',
                    author: ''
                },
                dialogFormVisible: false,
                formLabelWidth: '120px'
            };
        }
    }
</script>

<style scoped>

</style>
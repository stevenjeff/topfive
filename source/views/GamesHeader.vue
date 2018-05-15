<template>
    <p ref="btnGroup">
        <button v-for="key in gameKeys" :c="key" class="btn btn-primary" type="button" data-toggle="collapse"
                aria-expanded="false" :key="key" @click="buttonHandler($event)">
            {{key}}
        </button>
    </p>
</template>

<script>
    import {mapActions} from 'vuex';
    import store from '../vuex/store';
    import * as types from '../vuex/types';
    export default {
        name: "GamesHeader",
        data: function () {
            return {
                gameKeys: []
            };
        },
        methods: {
            buttonHandler: function (e) {
                let els = this.$refs.btnGroup.querySelectorAll('button');
                alert(els);
                for (let i = 0; i < els.length; i++) {
                    console.log(els[i].getAttribute('id'));
                }
                alert(e.target.getAttribute("id"));
                store.dispatch(types.ACTION_GAMES_DATA_CHANGE, e.target.getAttribute("id"));
            }
        },
        created: function () {
            this.$axios.get("/games/keys").then(res => {
                this.gameKeys = res.data;
            }).catch(error => console.log(error));
        }
    }
</script>

<style scoped>

</style>
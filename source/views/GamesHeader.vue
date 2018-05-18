<template>
    <section>
        <div ref="btnGroup" class="btn-group btn-group-toggle" data-toggle="buttons">
            <label v-for="(key,index) in gameKeys" :key="key"
                   v-bind:class="{'btn':true,'btn-secondary':true,'active':index==0}">
                <input :id="key" @click="buttonHandler($event)" aria-expanded="false" type="radio" name="options"
                       data-toggle="collapse" autocomplete="off" checked> {{key}}
            </label>
        </div>
        <br/>
    </section>
</template>

<script>
    import {mapActions} from 'vuex';
    import {mapGetters} from 'vuex'
    import {store} from '../vuex/store';
    import * as types from '../vuex/types';
    export default {
        name: "GamesHeader",
        data: function () {
            return {
            };
        },
        computed: {
            ...mapGetters({
                gameKeys: types.DATA_KEYS_GETTER
            })
        },
        methods: {
            buttonHandler: function (e) {
                let els = this.$refs.btnGroup.querySelectorAll('button');
                for (let i = 0; i < els.length; i++) {
                    console.log(els[i].getAttribute('id'));
                }
                store.dispatch(types.ACTION_GAMES_DATA_CHANGE, e.target.getAttribute("id"));
            }
        },
        created: function () {
            store.dispatch(types.ACTION_GAMES_INIT_KEYS);
        }
    }
</script>

<style scoped>

</style>
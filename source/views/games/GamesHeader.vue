<template>
    <section>
        <div ref="btnGroup" class="btn-group btn-group-toggle" data-toggle="buttons">
            <label v-for="(key,index) in gameKeys" @click="gameSiteChangeHandle(key)"
                   v-bind:class="{'btn':true,'btn-secondary':true,'active':index==0}">
                <input :id="key" aria-expanded="false" type="radio" name="options"
                       data-toggle="collapse" autocomplete="off" :checked="index==0" :key="key"/> {{key}}
            </label>
        </div>
        <br/>
    </section>
</template>

<script>
    import {mapGetters} from 'vuex';
    import {store} from '../../vuex/store';
    import * as types from '../../vuex/types';

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
            gameSiteChangeHandle(siteName) {
                let payload = {
                    key: siteName,
                    interval: 7
                };
                store.commit(types.MUTATE_SITE_CHANGE, siteName);
                store.dispatch(types.ACTION_GAMES_DATA_CHANGE, payload);
            }
        },
        created: function () {
            store.dispatch(types.ACTION_GAMES_INIT_KEYS);
            let siteName = "3dm";
            let payload = {
                key: siteName,
                interval: 7
            };
            store.commit(types.MUTATE_SITE_CHANGE, siteName);
            store.dispatch(types.ACTION_GAMES_DATA_CHANGE, payload);
        }
    }
</script>

<style scoped>

</style>
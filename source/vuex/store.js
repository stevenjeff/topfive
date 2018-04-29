import Vue from 'vue';
import Vuex from 'vuex';
import ali213 from './modules/ali213';

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        ali213
    }
});
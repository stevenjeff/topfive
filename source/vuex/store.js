import Vue from 'vue';
import Vuex from 'vuex';
import games from './modules/games';
import share from './modules/share';

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        games,
        share
    }
});
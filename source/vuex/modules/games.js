import * as types from '../types';

const state = {
    pageData: [],
    dateRange: []
};

const getters = {
    [types.PAGE_DATE_GETTER]: state => {
        return state.pageData;
    },
    [types.MUTATE_DATA_GAMES]: state => {
        return state.dateRange;
    }
};

const mutations = {
    [types.MUTATE_DATA_GAMES]: (state, payload) => {
        if (payload.dateRange) {
            state.dateRange = payload.dateRange;
        }
        state.pageData = payload.pageData;
    }
};

const actions = {
    [types.ACTION_GAMES_INIT_KEYS]: ({commit}, payload) => {
        this.$axios.get("/games/keys").then(res => {
            commit(types.MUTATE_KEYS_GAMES, res.data)
        }).catch(error => console.log(error));
    },
    [types.ACTION_GAMES_DATA_CHANGE]: ({commit}, payload) => {
        let gameSite = payload.key;
        let interval = payload.interval;
        this.$axios.get("/games/" + gameSite + "/" + interval).then(res => {
            commit(types.MUTATE_DATA_GAMES, res.data)
        }).catch(error => console.log(error));
    }
};

export default {
    state,
    mutations,
    actions,
    getters
}
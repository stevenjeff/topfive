import * as types from '../types';

const state = {
    pageData: [],
    dateRange: []
};

const getters = {
    [types.DOUBLE_ALI213]: state => {
        return state.counter * 2;
    },
    [types.CLICK_ALI213]: state => {
        return state.counter + ' Clicks';
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
    [types.ACTION_GAMES_DATA_CHANGE]: ({commit}, payload) => {
        this.$axios.get("/games/" + payload).then(res => {
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
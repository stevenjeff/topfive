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
        state.pageData = payload.pageData;
        state.dateRange = payload.dateRange;
    }
};

const actions = {
    [types.ACTION_GAMES_DATA_CHANGE]: ({commit}, payload) => {
        commit(types.MUTATE_DATA_GAMES, payload);
    }
};

export default {
    state,
    mutations,
    actions,
    getters
}
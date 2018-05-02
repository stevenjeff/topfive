import * as types from '../types';

const state = {
    counter: 0
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
    [types.MUTATE_INCREMENT_ALI213]: (state, payload) => {
        state.counter += payload;
    },
    [types.MUTATE_DECREMENT_ALI213]: (state, payload) => {
        state.counter -= payload;
    }
};

const actions = {
    [types.ALI213_INCREMENT]: ({commit}, payload) => {
        commit(types.MUTATE_INCREMENT_ALI213, payload);
    },
    [types.ALI213_DECREMENT]: ({commit}, payload) => {
        commit(types.MUTATE_DECREMENT_ALI213, payload);
    },
    [types.ALI213_INCREMENT_ASYNC]: ({commit}, payload) => {
        setTimeout(() => {
            commit(types.MUTATE_INCREMENT_ALI213, payload.by);
        }, payload.duration);
    },
    [types.ALI213_DECREMENT_ASYNC]: ({commit}, payload) => {
        setTimeout(() => {
            commit(types.MUTATE_DECREMENT_ALI213, payload.by);
        }, payload.duration);
    }
};

export default {
    state,
    mutations,
    actions,
    getters
}
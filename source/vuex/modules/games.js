import * as types from '../types';
import {axiosCon} from '../../config/axiosConfig';
const state = {
    pageData: [],
    dateRange: [],
    keys: []
};

const getters = {
    [types.PAGE_DATA_GETTER]: state => {
        return state.pageData;
    },
    [types.DATE_RANGE_GETTER]: state => {
        return state.dateRange;
    },
    [types.DATA_KEYS_GETTER]: state => {
        return state.keys;
    }
};

const mutations = {
    [types.MUTATE_DATA_GAMES]: (state, payload) => {
        if (payload.intervals) {
            state.dateRange = payload.intervals;
        }
        state.pageData = payload.data;
    },
    [types.MUTATE_KEYS_GAMES]: (state, payload) => {
        state.keys = payload;
    }
};

const actions = {
    [types.ACTION_GAMES_INIT_KEYS]: ({commit}, payload) => {
        axiosCon.get("/games/keys").then(res => {
            commit(types.MUTATE_KEYS_GAMES, res.data)
        }).catch(error => console.log(error));
    },
    [types.ACTION_GAMES_DATA_CHANGE]: ({commit}, payload) => {
        let gameSite = payload.key;
        let interval = payload.interval;
        if (!interval) {
            interval = 7;
        }
        if (!gameSite) {
            gameSite = "ali213";
        }
        axiosCon.get("/games/" + gameSite + "/" + interval).then(res => {
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
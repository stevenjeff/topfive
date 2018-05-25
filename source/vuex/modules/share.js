import * as types from '../types';
import {axiosCon} from '../../config/axiosConfig';

const state = {
    resourcePage: {},
    resourceObj: null,
    showAddForm: false
};

const getters = {
    [types.RESOURCE_LIST_GETTER]: state => {
        return state.resourcePage;
    },
    [types.RESOURCE_SHOW_PAGE_GETTER]: state => {
        return state.showAddForm;
    }
};

const mutations = {
    [types.MUTATE_LIST_RESOURCE]: (state, payload) => {
        state.resourcePage = payload;
    },
    [types.MUTATE_SHOW_PAGE_RESOURCE]: (state, payload) => {
        state.showAddForm = payload;
    }
};

const actions = {
    [types.ACTION_LIST_RESOURCE]: ({commit}, payload) => {
        axiosCon.get("/resourcePage").then(res => {
            commit(types.MUTATE_LIST_RESOURCE, res.data)
        }).catch(error => console.log(error));
    },
    [types.ACTION_ADD_RESOURCE]: ({commit}, payload) => {
        axiosCon.get("/resourceAdd").then(res => {
            commit(types.MUTATE_ADD_RESOURCE, res.data);
        }).catch(error => console.log(error));
    }
};

export default {
    state,
    mutations,
    actions,
    getters
}
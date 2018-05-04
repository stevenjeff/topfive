import Vue from 'vue'
import {store} from './vuex/store';
import VueRouter from 'vue-router';
import App from './App'
import {routes} from './router/routes'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
//import store from '@/vuex/store'
axios.defaults.baseURL = 'https://vue-update.firebaseio.com'
axios.defaults.headers.get['Accepts'] = 'application/json'
Vue.config.productionTip = false;
//开启debug模式
Vue.config.debug = true

Vue.use(VueRouter);

Vue.prototype.$axios = axios;

Vue.filter('currency', (value) => {
    return '$' + value.toLocaleString();
});

const router = new VueRouter({
    routes,
    mode: 'history'
});

new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App)
})

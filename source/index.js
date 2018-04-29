import Vue from 'vue'
import {store} from './vuex/store';
import VueRouter from 'vue-router';
import App from './App'
import {routes} from './router/routes'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
//import store from '@/vuex/store'

Vue.use(VueRouter);

const router = new VueRouter({
    routes,
    store,
    mode: 'history'
});
Vue.config.productionTip = false;
//开启debug模式
Vue.config.debug = true

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})

import Vue from 'vue'
import {store} from './vuex/store';
import VueRouter from 'vue-router';
import App from './App'
import {routes} from './router/routes'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import {axiosCon} from './config/axiosConfig';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.prototype.$axios = axiosCon;
Vue.config.productionTip = false;
//开启debug模式
Vue.config.debug = true;

Vue.use(ElementUI);
Vue.use(VueRouter);

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
});

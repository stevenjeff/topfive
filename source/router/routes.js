import Home from '../common/Home.vue';

export const routes = [
    {
        path: '', name: 'home', components: {
            default: Home,
        }
    },
    {
        path: '/user', components: {
            default: Home,
        }
    },
    {path: '/redirect-me', redirect: {name: 'home'}},
    {path: '*', redirect: '/'}
];
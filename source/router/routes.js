import Home from '../views/Games.vue';

export const routes = [
    {
        path: '', name: 'games', components: {
            default: Home,
        }
    },
    {
        path: '/user', components: {
            default: Home,
        }
    },
    {path: '/redirect-me', redirect: {name: 'games'}},
    {path: '*', redirect: '/'}
];
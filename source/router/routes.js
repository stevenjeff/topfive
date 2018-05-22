import Game from '../views/games/GamesPage';
import Share from '../views/share/SharePage';

export const routes = [
    {
        path: '', name: 'games', components: {
            default: Game,
        }
    },
    {
        path: '/games', name: 'games', components: {
            default: Game,
        }
    },
    {
        path: '/share', components: {
            default: Share,
        }
    },
    {path: '/redirect-me', redirect: {name: 'games'}},
    {path: '*', redirect: '/'}
];
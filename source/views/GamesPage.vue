<template>
    <div class="row">
        <app-games-header></app-games-header>
        <app-games-content></app-games-content>
    </div>
</template>

<script>
    import GamesHeader from './GamesHeader';
    import GamesContent from './GamesContent';

    export default {
        name: "GamePage",
        components: {
            appGamesHeader: GamesHeader,
            appGamesContent: GamesContent
        }
    }
</script>

<style scoped>

</style>
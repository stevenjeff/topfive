<template>
    <div class="container">
        <app-header></app-header>
        <div class="tab-content" id="pills-tabContent">
            <transition name="slide" mode="out-in">
                <router-view></router-view>
            </transition>
        </div>
        <!--<div class="row">-->
        <!--<div class="col-xs-12">-->
        <!--<transition name="slide" mode="out-in">-->
        <!--<router-view></router-view>-->
        <!--</transition>-->
        <!--</div>-->
        <!--</div>-->
        <app-footer></app-footer>
    </div>
</template>

<script>
    import Header from './common/Header';
    import Footer from './common/Footer';
    export default {
        name: "App",
        components: {
            appHeader: Header,
            appFooter: Footer
        }
    }
</script>

<style scoped>
    body {
        padding: 30px;
    }

    .slide-enter-active {
        animation: slide-in 200ms ease-out forwards;
    }

    .slide-leave-active {
        animation: slide-out 200ms ease-out forwards;
    }

    @keyframes slide-in {
        from {
            transform: translateY(-30px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    @keyframes slide-out {
        from {
            transform: translateY(0);
            opacity: 1;
        }
        to {
            transform: translateY(-30px);
            opacity: 0;
        }
    }
</style>
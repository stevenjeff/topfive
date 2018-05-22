<template>
    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
        <li class="nav-item">
            <router-link to="/" tag="a" class="nav-link active" data-toggle="pill" href="#pills-home" role="tab"
                         active-class="active" aria-controls="pills-home" aria-selected="true" exact><a>游戏 GAMES</a>
            </router-link>
        </li>
        <li class="nav-item">
            <router-link to="/movies" tag="a" class="nav-link" data-toggle="pill" href="#pills-home" role="tab"
                         active-class="active" aria-controls="pills-home" aria-selected="true" exact><a>视频 VIDEOS</a>
            </router-link>
        </li>
        <li class="nav-item">
            <router-link to="/share" tag="a" class="nav-link" data-toggle="pill" href="#pills-home" role="tab"
                         active-class="active" aria-controls="pills-home" aria-selected="true" exact><a>分享 SHARE</a>
            </router-link>
        </li>
    </ul>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>
<template>
    <section class="recommend">
        <div class="top">
            <h2>推荐歌单</h2>

        </div>
        <div class="bottom">
                <div class="list">
                    <PlayListCardComponent></PlayListCardComponent>
                </div>      
        </div>
    </section>
    

</template>

<script setup>
    import PlayListCardComponent from './PlayListCardComponent.vue';
    
    

</script>

<style lang="scss" scoped>
    @import url(./Recommend.module.scss); 



</style>
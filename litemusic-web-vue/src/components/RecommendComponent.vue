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

<script setup lang="ts">
    import PlayListCardComponent from './PlayListCardComponent.vue';
    
</script>

<style lang="scss" scoped>
.recommend {
    margin-top: 60px;

    .top {
        display: flex;
        align-items: end;
        margin-bottom: 24px;

        h2 {
            margin-right: 40px;
            font-size: 28px;
            font-weight: 600;
            color: #333;
            letter-spacing: 1px;
        }
    }

    .bottom {
        display: flex;
        justify-content: space-between;

    .list {
      display: grid;
      grid-template-columns: repeat(5, 1fr);
      grid-gap: 20px;
    }
  }

}




</style>
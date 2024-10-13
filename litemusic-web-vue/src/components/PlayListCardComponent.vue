<template>
    <div class="item" v-for="item in PlayListCard " :key="item.id">
        <router-link :to="`/playlistinfo/${item.id}`"><img :src="item.url" referrerpolicy="no-referrer" alt="" class="pic"/></router-link>
        <p class="name">{{ item.name }}</p>
    </div>
    
</template>

<script setup lang="ts">
    import { getPlayListCard } from "../utils/request"
    import { ref, computed } from "vue";

    const PlayListCard = ref([{
        id:"",
        name:"",
        url:"",
        create_at:"",
        info:""
   
    }]);

    const fetchPlayListCard = async () => {
    try {
        const response = await getPlayListCard();
        PlayListCard.value = response.data.playlistcard;
        console.log(PlayListCard.value)
    } catch (error) {
        console.error('请求异常！:', error);
    }
    };

    fetchPlayListCard(); // 直接在 setup 中调用函数
   // 洗牌算法（Fisher-Yates shuffle）
    function shuffleArray(array: any[]) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
    }

    const shuffledPlayListCard = computed(() => shuffleArray([...PlayListCard.value]));
    const randomFiveCards = computed(() => shuffledPlayListCard.value.slice(0, 5));



</script>

<style lang="scss" scoped>
.item {
    width: 100%;
    .pic {
      position: relative;
      width: 100%;
      overflow: hidden;
  
      img {
        display: block;
        width: 100%;
        object-fit: cover;
        transition: transform 0.75s cubic-bezier(0, 1, 0.75, 1);
      }
    }  
    .name {
      margin-top: 16px;
      font-size: 16px;
      font-weight: 400;
    }
}
  
</style>
<template>
    <div class="container">
        
        <section class="wrapper">

            <div class="list">
                <div class="item" v-for="item in PlayListCard " :key="item.id">
                    <router-link :to="`/playlistinfo/${item.id}`"><img :src="item.url" referrerpolicy="no-referrer" alt="" class="pic"/></router-link>
                    <p class="name">{{ item.name }}</p>
                </div>
                
            </div>
           
        </section>
    </div>
</template>

<script setup lang="ts">
    import router from "@/router";
    import { getPlayListCard } from "../utils/request"
    import { ref } from "vue";

    const PlayListCard = ref([{
        id:"",
        name:"",
        url:"",
        create_at:""
   
    }])

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



</script>

<style lang="scss" scoped>
@import url(./Recommend.module.scss);
@import url(./PlayListCardComponent.module.scss);
.wrapper {
  margin-top: 300px;

  .list {
    display: flex;
    flex-wrap: wrap;
    gap: 26px 1.41%;
  }

  .paginate {
    display: flex;
    justify-content: center;
    margin-top: 48px;
  }
}
</style>
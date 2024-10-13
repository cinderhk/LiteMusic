<template>
    <section class="banner">
        <div class="top">
        <Swiper
            :slides-per-view="1"
            :space-between="0"
            :loop="true"
            :pagination="{ clickable: true }"
            :autoplay="{ delay: 3000, disableOnInteraction: false }"
            :navigation="false"
            :modules="[Pagination, Navigation, Autoplay]"
        >
            <SwiperSlide v-for="item in BannerList" :key="item.id">
            <img :src="item.pic" referrerpolicy="no-referrer" alt=""/>
            </SwiperSlide>
        </Swiper>
        </div>
    </section>
</template>

<script setup lang="ts">
    import { ref } from 'vue';
    import { Swiper, SwiperSlide } from 'swiper/vue';
    import { Pagination, Navigation, Autoplay } from 'swiper/modules';
    import { getBannerList } from '../utils/request';
    import 'swiper/css'
    import 'swiper/css/pagination'
    import 'swiper/css/navigation'

    const BannerList =ref([{
    id: "",
    pic: "",
    url: "",
    }])


    const fetchBannerList = async () => {
    try {
        const response = await getBannerList();
        BannerList.value = response.data.Banner;
    } catch (error) {
        console.error('请求异常！:', error);
    }
    };

    fetchBannerList(); // 直接在 setup 中调用函数

</script>

<style lang="scss" scoped>

.banner {
  width: 100%;
  margin-top: 20px;

  .top {
    position: relative;
    max-height: 400px;
  }
}

       


</style>
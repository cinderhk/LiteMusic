<template>
    <div class="item" v-for="item in PlayListCard " :key="item.id">
        <div class="itempic">
            <i class="icon_play"><PlayIcon @click="Start_PlayListCard(parseInt(item.id))"/></i>
            <img :src="item.url" referrerpolicy="no-referrer" alt=""/>
        </div>
        <p class="name" @click="toPlayInfo(item.id)">{{ item.name }}</p>
        
    </div>
</template>

<script setup lang="ts">
    import { getPlayListCard,getPlayListInfoById,getMusic_UrlById } from "../utils/request"
    import { ref, computed } from "vue";
    import { PlayIcon } from '@heroicons/vue/24/solid'
    import router from "@/router";


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
    // function shuffleArray(array: any[]) {
    // for (let i = array.length - 1; i > 0; i--) {
    //     const j = Math.floor(Math.random() * (i + 1));
    //     [array[i], array[j]] = [array[j], array[i]];
    // }
    // return array;
    // }

    // const shuffledPlayListCard = computed(() => shuffleArray([...PlayListCard.value]));
    // const randomFiveCards = computed(() => shuffledPlayListCard.value.slice(0, 5));

    function toPlayInfo(id:string) {
        router.push(`/playlistinfo/${id}`);
    }

 
    const playlistinfo = ref([{
        id:"",
        musicrid:""
   
    }]);
    const musicURL = ref([{
        "musicrid":"",
        "type":"",
        "url":""
    }])
    async function Start_PlayListCard(id: number) {
    try {
        const response = await getPlayListInfoById(id);
        const playlistinfo = response.data.playlistinfo;
        console.log(playlistinfo);
        const url_response = await getMusic_UrlById(playlistinfo[0].musicrid,1);
        musicURL.value =url_response.data.musicURL.url;
        console.log(musicURL.value)
       
    } catch (error) {
        console.error('请求播放列表信息异常！:', error);
    }
}

</script>

<style lang="scss" scoped>
.item {
    width: 100%;
    .itempic {
        position: relative;
        width: 100%;
        overflow: hidden;
        img {
            display: block;
            width: 100%;
            object-fit: cover;
            transition: transform 0.75s cubic-bezier(0, 1, 0.75, 1);
        }
        &:hover {
        cursor: pointer;
        .icon_play {
            opacity: 1;
            visibility: visible;
            }
        }
        .icon_play {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: rgba(255, 255, 255, 0.8); // 背景颜色可以调整
            padding: 10px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            width: 30px;
            height: 30px;
            opacity: 0;
            visibility: hidden;
            transition: opacity 0.3s, visibility 0.3s;
        }
        

    }

    .name {
        margin-top: 16px;
        font-size: 16px;
        font-weight: 400;
        cursor: default;
        &:hover {
            font-weight: bold;
            cursor: pointer;
        }
    }
}
  
</style>
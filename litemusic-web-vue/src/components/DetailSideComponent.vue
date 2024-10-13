<template>
    
    <div class="box">
        <div class="cover">
            <img :src="PlayListInfo.url" referrerpolicy="no-referrer" alt="" class="pic"/>
        </div>
        <h4>歌单介绍</h4>
        <p class="p">{{ PlayListInfo.info }}</p>
    </div>
    <!-- <div class="right">
        哈哈哈
        {{ PlayListInfo.name }}
    </div> -->

        
    
    
</template>

<script setup lang="ts">
    import { ref } from "vue";
    import { getPlayListCardById } from "../utils/request"
    import { useRoute } from 'vue-router';
    const PlayListInfo = ref({
            id:"",
            name:"",
            url:"",
            create_at:"",
            info:""
    
        })
    const route = useRoute();
    const path = route.path;
    const parts = path.split('/');
    let id = parseInt(parts[parts.length - 1]);
    


    const PlayListCardById = async () => {
    try {
        const response = await getPlayListCardById(id);
        PlayListInfo.value = response.data.playlistcard;
        console.log(PlayListInfo.value)
    } catch (error) {
        console.error('请求异常！:', error);
    }
    };

    PlayListCardById(); // 直接在 setup 中调用函数

</script>

<style lang="scss" scoped>
   .box {
  margin-top: 40px;
  width: 21.2%;

  .cover {
    margin-bottom: 40px;

    img {
      width: 100%;
      object-fit: cover;
    }
  }

  h4 {
    height: 30px;
    margin-bottom: 10px;
    font-size: 22px;
    font-weight: 600;
    line-height: 30px;
  }

  p {
    width: 100%;
    font-size: 14px;
    line-height: 21px;
    color: #666;
    word-break: break-all;
  }

  .code {
    margin: 36px 0;
    text-align: center;
    border-top: 1px solid #efefef;

    img {
      width: 168px;
      height: 168px;
      margin: 36px 0 18px;
    }

    p {
      font-size: 16px;
      font-weight: 300;
      line-height: 21px;
      color: #666;
    }
  }
}

</style>
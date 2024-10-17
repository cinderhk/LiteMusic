<template>
    <div class="playControl">
        <div class="play_content">
            <div class="control">
                <div class="left">
                    <a><img :src="songImage" class="song_img"></a>
                    <div class="info_cn">
                        <div class="info">
                            <span class="song_name">{{ songName }}</span>
                            <span class="artist">{{ artist }}</span>
                            <span class="time">{{ currentTime }}/{{ duration }}</span>
                        </div>
                        <div class="process">
                            <div class="progress-bar">
                                <div :style="{ width: progressBarWidth + '%' }" class="progress-fill"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="play_centre">
                    
                    <Icon icon="si:play-previous-duotone" class="play_pre" />
                    <Icon icon="prime:play-circle" class="play-circle"/>
                    <!-- <Icon icon="prime:pause-circle" class="play-circle"/> -->
                    <Icon icon="si:play-next-duotone" class="play_next"/>
                
                         
                </div> 
                <div class="play_right">
                    
                    <Icon icon="material-symbols-light:playlist-play-rounded" class="playlist"/>
                    <Icon icon="iconoir:download" class="download"/>
                    <!-- <Icon icon="iconoir:sound-off" class="sound-off"/> -->
                    <div class="volume-control">
                        <Icon icon="iconoir:sound-high" class="sound-high"/>
                        <input type="range" min="0" max="1" step="0.05" v-model="volumeLevel" @change="setVolume" />
                    </div>
                </div>                    
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
    import { ref, onMounted, watchEffect } from 'vue';
    import { Icon } from '@iconify/vue';

// 示例音频文件路径
const audioSrc = 'path/to/audio.mp3';

// 歌曲信息
const songImage = 'https://img1.kuwo.cn/star/albumcover/500/96/23/672081720.jpg';
const songName = '一路生花';
const artist = '哈哈哈';
const duration = '04:16';

// 音频播放相关变量
const audioElement = new Audio(audioSrc);
const currentTime = ref('00:00');
const progressBarWidth = ref(0);

// 更新当前时间和进度条
function updateTimeAndProgress() {
    const currentSecs = Math.floor(audioElement.currentTime);
    const totalSecs = Math.floor(audioElement.duration);
    const currentMin = Math.floor(currentSecs / 60);
    const currentSec = currentSecs % 60;
    const totalMin = Math.floor(totalSecs / 60);
    const totalSec = totalSecs % 60;
    
    currentTime.value = `${currentMin}:${currentSec < 10 ? '0' + currentSec : currentSec}`;
    progressBarWidth.value = (currentSecs / totalSecs) * 100;
}

// 初始化音频播放
onMounted(() => {
    audioElement.addEventListener('timeupdate', updateTimeAndProgress);
    audioElement.addEventListener('loadedmetadata', () => {
        audioElement.play();
    });

    // 清理事件监听器
    return () => {
        audioElement.removeEventListener('timeupdate', updateTimeAndProgress);
        audioElement.removeEventListener('loadedmetadata', () => {});
    };
});

// 音量控制相关变量
const volumeLevel = ref(0.5); // 默认音量为50%

// 设置音量的方法
function setVolume() {
    audioElement.volume = volumeLevel.value;
}
</script>

<style scoped>
.playControl {
    background: #fff;
    margin: 0 auto;
    max-width: 1640px;
    padding: 0 120px;
    position: relative;
}
.play_content {
    position: relative
}
.playControl .control {
    display: flex;
    align-items: center;
    justify-content: space-between;
    position: relative;
}
.playControl .play_content .control .left {
    display: flex;
    justify-content: space-between;
    position: relative;
    width: 460px;
}
.playControl .play_content .control .left .info_cn {
    justify-content: space-between;
    align-items: center;
    margin-bottom: 11px;
    width: 370px;
}
.playControl .play_content .control .left .info_cn .info {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 300px;
}
.playControl .play_content .control .left .song_img {
    height: 70px;
    margin-right: 20px;
    width: 70px;
}
.playControl .play_content .control .left .info_cn .info .song_name {
    line-height: 22px;
    max-width: 53.67%;
}
.playControl .play_content .control .left .info_cn .info .artist {
    color: #666;
    cursor: pointer;
    max-width: 31.63%;
}
.playControl .play_content .control .left .info_cn .info .time {
    color: #999;
}
.playControl .play_content .control .left .info_cn .process {
    width: 80%;
    height: 5px;
    margin-top: 5%;
    background-color: #ddd;
}
.playControl .play_content .control .left .info_cn .process .progress-bar {
    position: relative;
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.playControl .play_content .control .left .info_cn .process .progress-fill {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    background-color: #f00;
    width: 0%;
}
.playControl .play_content .control .play_centre {
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: relative;
    width: 300px;
}
.playControl .play_content .control .play_centre .play_pre {
    width: 24px;
    height: 24px;
}
.playControl .play_content .control .play_centre .play-circle {
    width: 40px;
    height: 40px;
}
.playControl .play_content .control .play_centre .play_next {
    width: 24px;
    height: 24px;
}
.playControl .play_content .control .play_right {
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: relative;
    width: 300px;
}
.playControl .play_content .control .play_right .download {
    width: 24px;
    height: 24px;
}
.playControl .play_content .control .play_right .playlist {
    width: 24px;
    height: 24px;
}
.playControl .play_content .control .play_right .sound-high {
    width: 24px;
    height: 24px;
}
.playControl .play_content .control .play_right .sound-off {
    width: 24px;
    height: 24px;
}
/* 添加到你的 .play_right 样式后面 */
.playControl .play_content .control .play_right .volume-control {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.playControl .play_content .control .play_right .volume-control input[type=range] {
    -moz-appearance: none; /* 移除默认样式 */
    height: 3px;
    margin-left: 10px;
    width: 100px; /* 调整滑块长度 */
    cursor: pointer;
}
.playControl .play_content .control .play_right .volume-control input[type=range]::-moz-range-track {
    background: #ffdf1f; /* 轨道颜色 */
    border: none; /* 边框 */
    border-radius: 5px; /* 圆角 */
}


</style>
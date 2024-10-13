import axios from 'axios';

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

const BASE_URL = import.meta.env.VITE_APP_BASE_API


const service = axios.create({
    // axios中请求配置有baseURL选项，表示请求URL公共部分
    baseURL: BASE_URL,
    // 超时

    timeout: 10000
  })

export const getBannerList = async () => {
    try {
        const response = await service.post('/banner/list');
        return response.data;
    } catch (error) {
        throw error;
    }
};

export const getPlayListCard = async () => {
    try {
        const response = await service.post('/playlistcard/list');
        return response.data;
    } catch (error) {
        throw error;
    }
};

export const getPlayListCardById = async (id: number) => {
  try {
    const response = await axios.post(`/api/playlistcard/ById?id=`+ id );
    return response.data;
  } catch (error) {
    throw error;
  }
};
  





export default {
    getBannerList,
    getPlayListCard,
    getPlayListCardById
};
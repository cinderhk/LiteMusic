import axios from 'axios';

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

const service = axios.create({
    timeout: 10000
  })

export const getBannerList = async () => {
    try {
        const response = await service.post('/api/banner/list');
        return response.data;
    } catch (error) {
        throw error;
    }
};

export const getPlayListCard = async () => {
    try {
        const response = await service.post('/api/playlistcard/list');
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
import axios from 'axios'
import qs from 'qs'
import router from '../router'

const instance = axios.create({
    baseURL: "http://localhost:8888/yyzx",
})

export default instance;
import axios from 'axios'
import qs from 'qs'
import router from '../router'

const instance = axios.create({
    baseURL: "http://localhost:9999/yyzx",
})
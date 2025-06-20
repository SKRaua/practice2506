import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/Login.vue'
import store from '../store'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/',
    redirect: '/login'
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

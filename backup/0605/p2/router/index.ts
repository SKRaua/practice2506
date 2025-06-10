import { createRouter, createWebHistory } from "vue-router";
import Home from "@/components/Home.vue"
import News from "@/components/News.vue"
import About from "@/components/About.vue"
//@到src那一级
// @/等同于../
const router=createRouter({
    //路由器的工作模式
    history:createWebHistory(),
    routes:[
        //路由规则
        {
            path:'/home',
            component:Home
        },

        {
            path:'/news',
            component:News
        },
        {
            path:"/about",
            component:About
        }
    ]
})

//暴露路由对象
export default router
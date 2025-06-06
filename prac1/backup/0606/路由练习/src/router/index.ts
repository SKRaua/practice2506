import { createRouter, createWebHashHistory, createWebHistory } from "vue-router";
import Home from "@/pages/Home.vue"
import News from "@/pages/News.vue"
import About from "@/pages/About.vue"
import Detail from "@/pages/Detail.vue"

const router=createRouter({
    history:createWebHistory(),  //history模式
    //history:createWebHashHistory(), //Hash模式
    routes:[
        //路由规则
        {
            name:'one', //路由规则的别名
            path:'/home',
            component:Home
        },

        {
            name:'two',
            path:'/news',
            component:News,
            children:[
                {
                    name:'four',
                    path:'detail', //query形式子路由不写斜杠
                    //path:'detail/:id/:title/:content', //params形式子路由 事先定义模式字符串，否则会当成路径
                    component:Detail,
                    //params传参 只能传params参数
                    //props:true //开启路由间组件的通信

                    //对象方式能传query参数,也能传params参数
                    props(router){
                        //return router.params
                        return router.query
                    }

                }
            ]
        },
        {
            name:'three',
            path:"/about",
            component:About
        }
    ]
})

//暴露路由对象
export default router



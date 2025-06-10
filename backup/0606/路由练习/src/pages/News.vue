<template>
  <div class="news">
    <!--导航区-->
    <ul>
      <li v-for="news in newsList" :key="news.id">
        <!--第一种传值的方式:模板字符串 "`{内容}`" 对数据进行动态绑定-->
        <!--第二种传值的方式:对象-->
        <!--replace模式进行页面替换,无法回退到历史记录，默认方式是push-->
        <RouterLink
          replace
          :to="{
            name: 'four',
            query: {
              id: news.id,
              title: news.title,
              content: news.content,
            },
          }"
          >{{ news.title }}</RouterLink
        >

        <button @click="showNews(news)">点击查看内容</button>
        <!--编程式路由导航 此处传递for循环定义的对象news-->
      </li>
    </ul>

    <!--展示区-->
    <div class="main-content">
      <!-- 展示的内容 路由的出口 -->
      <RouterView></RouterView>
    </div>
  </div>
</template>

<script setup lang="ts" name="News">
import { reactive } from "vue";
import { RouterLink, RouterView, useRouter } from "vue-router";
const newsList = reactive([
  { id: "aaa111", title: "喜讯1", content: "重庆邮电大学荣升新一批双一流高校" },
  {
    id: "aaa222",
    title: "喜讯2",
    content: "我校新建立计算机学院(示范性软件学院)",
  },
  { id: "aaa333", title: "喜讯3", content: "我校新增博士点5个" },
  { id: "aaa444", title: "喜讯4", content: "我校国际学院设立国家重点3个" },
]);

//获取路由器信息
const router = useRouter();

//推到目标页面并显示内容
function showNews(news: any) {
  console.log("router----->", router);
  router.push({
    //push形式替换页面
    name: "four",
    query: {
      id: news.id,
      title: news.title,
      content: news.content,
    },
  });
}
</script>

<style scoped>
.news {
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  height: 100%;
}

.news ul {
  margin-top: 30px;
  list-style: none;
  padding-left: 10px;
}

.news li > a {
  text-decoration: none;
  font-size: 18px;
  line-height: 40px;
  color: black;
  text-shadow: 0 0 1px rgb(45, 132, 45);
}

.main-content {
  border: 1px solid;
  margin-top: 20px;
  border-radius: 10px;
  width: 80%;
  height: 90%;
}

button {
  margin-left: 2px;
}
</style>

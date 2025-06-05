<template>
   
   <div class="app">
        <!-- 导航区-->
        <div class="navigate">
            <!--<a herf=''>是普通的超链接的形式-->
            <RouterLink to="/home" class="activated">首页</RouterLink>
            <RouterLink to="/news" class="activated">新闻</RouterLink>
            <RouterLink to="/about" class="activated">关于</RouterLink>
        </div>

        <!--展示区-->
        <div class="main-content">
            <!--路由器视图-->
            <RouterView></RouterView>
        </div>
        
    </div>

</template>

<script lang="ts" setup name="App">
import { RouterView,RouterLink } from 'vue-router';


</script>

<style scoped>

  .navigate{  /* 设置整体的样式 */
      display:flex;
      justify-content:space-around ;
      margin:0,100px ;
  }

  .navigate a{  /* 设置单体的样式 */
      display: block;
      text-align: center;
      width:90px;
      height:40px;
      line-height:40px;
      border-radius:10px;
      background-color:gray;
      text-decoration: none;
      color:aliceblue;
      font-size: 20px;
      letter-spacing:5px ;
  }

  .navigate a.activated{   /* 设置激活后的样式 */
      background-color: green;
      color:white;
      font-weight: 900;
      text-shadow: 0,0,1px black;
      font-family: 微软雅黑;
  }

  .main-content{  /*调整展示区内容样式*/
      border:1px solid;
      margin:0 auto;
      margin-top:30px;
      border-radius: 10px;
      width:90%;
      height:400px;
      
  }
</style>
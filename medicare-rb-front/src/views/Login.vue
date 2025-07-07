<template>
  <div class="login-bg">
    <div class="login">
      <div class="message">医保报销管理</div>
      <div id="darkbannerwrap"></div>
      <form>
        <input name="username" v-model="loginForm.username" type="text" placeholder="用户名" />
        <hr class="hr15" />
        <input name="password" v-model="loginForm.password" type="password" placeholder="密码" />
        <hr class="hr15" />
        <input type="button" value="登录" @click="login" style="width: 100%" />
        <hr class="hr20" />
      </form>
    </div>
  </div>
</template>

<script>
import { login } from "../api/userApi.js";
import { setSessionStorage } from "@/utils/common.js";
export default {
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login() {
      login(this.loginForm).then((res) => {
        console.log(res);
        if (res.flag) {
          sessionStorage.setItem("token", res.message);
          setSessionStorage("user", res.data);
          this.$store.commit("addMenus", res.data.menuList);

          // const firstPath = res.data.menuList[0].children[0].path;
          // this.$router.push(firstPath);
        } else {
          this.$message.error(res.message);
        }
      });
    },
  },
};
</script>

<style scoped>
.login-bg {
  width: 100%;
  height: 100%;
  background: url(../assets/logbg.jpg) no-repeat center;
  background-size: cover;
  /* 裁剪超出边框内容，不显示滚动条 */
  overflow: hidden;
}

.login {
  margin: 200px auto 0 auto;
  min-height: 420px;
  max-width: 420px;
  padding: 40px;
  background-color: #fff;
  border-radius: 4px;
  box-sizing: border-box;
}

.login .message {
  margin: 10px 0 0 -58px;
  padding: 18px 10px 18px 60px;
  background: #44aff0;
  position: relative;
  color: #fff;
  font-size: 20px;
  font-weight: bolder;
}

.login #darkbannerwrap {
  width: 18px;
  height: 10px;
  margin: 0 0 20px -58px;
  position: relative;
}

.login input[type="email"],
.login input[type="file"],
.login input[type="password"],
.login input[type="text"],
select {
  width: 100%;
  height: 30px;
  border: 1px solid #ddd;
  border-radius: 3px;
  padding: 0 10px;
  box-sizing: border-box;
}

/* 鼠标点击或者tab获得焦点时，蓝框 */
.login input[type="email"]:focus,
.login input[type="file"]:focus,
.login input[type="password"]:focus,
.login input[type="text"]:focus,
select:focus {
  border: 1px solid #44aff0;
}

/* 按钮样式 */
.login input[type="submit"],
.login input[type="button"] {
  display: inline-block;
  vertical-align: middle;
  padding: 12px, 24px;
  margin: 0;
  font-size: 18px;
  line-height: 24px;
  text-align: center;
  white-space: nowrap;
  cursor: pointer;
  color: #fff;
  background-color: #44aff0;
  border-radius: 3px;
  border: none;
  appearance: none;
  -webkit-appearance: none;
  outline: 0;
  width: 100%;
}

.login hr {
  background: #fff;
}

.login hr .hr15 {
  height: 15px;
  border: none;
  margin: 0;
  padding: 0;
  width: 100%;
}

.login hr .hr20 {
  height: 20px;
  border: none;
  margin: 0;
  padding: 0;
  width: 100%;
}
</style>

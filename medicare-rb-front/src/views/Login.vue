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
          //   this.$router.push("res.data.menuList[0].children[0].path");

          const firstPath = res.data.menuList[0].children[0].path;
          this.$router.push(firstPath);
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
  width: 100vw;
  height: 100vh;
  background: linear-gradient(135deg, #fce4ec 0%, #f8bbd0 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  overflow: hidden;
}

.login {
  min-height: 420px;
  max-width: 420px;
  width: 100%;
  padding: 40px 36px 32px 36px;
  background: #fff;
  border-radius: 16px;
  box-shadow: 0 8px 32px 0 rgba(236, 64, 122, 0.12), 0 1.5px 6px 0 rgba(0, 0, 0, 0.06);
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.login .message {
  margin-bottom: 24px;
  padding: 18px 0;
  width: 100%;
  background: linear-gradient(90deg, #ec407a 60%, #f06292 100%);
  color: #fff;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  border-radius: 8px 8px 0 0;
  letter-spacing: 2px;
  box-shadow: 0 2px 8px 0 rgba(236, 64, 122, 0.08);
}

.login form {
  width: 100%;
}

.login input[type="text"],
.login input[type="password"] {
  width: 100%;
  height: 40px;
  border: 1.5px solid #f8bbd0;
  border-radius: 6px;
  padding: 0 12px;
  margin-bottom: 18px;
  font-size: 16px;
  transition: border-color 0.2s;
  background: #fdf6fa;
  box-sizing: border-box;
}

.login input[type="text"]:focus,
.login input[type="password"]:focus {
  border-color: #ec407a;
  outline: none;
  background: #fff;
}

.login input[type="button"] {
  padding: 12px 0;
  font-size: 18px;
  color: #fff;
  background: linear-gradient(90deg, #ec407a 60%, #f06292 100%);
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-weight: bold;
  box-shadow: 0 2px 8px 0 rgba(236, 64, 122, 0.10);
  transition: background 0.2s, box-shadow 0.2s;
}

.login input[type="button"]:hover {
  background: linear-gradient(90deg, #f06292 60%, #ec407a 100%);
  box-shadow: 0 4px 16px 0 rgba(236, 64, 122, 0.18);
}

.hr15,
.hr20 {
  border: none;
  background: transparent;
  margin: 0;
  padding: 0;
  width: 100%;
  height: 0;
}

.hr15 {
  height: 15px;
}

.hr20 {
  height: 20px;
}
</style>

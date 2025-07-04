<template>
  <div class="main">
    <div class="query">
      <table class="query-table">
        <tr>
          <!-- 楼层选择表单列 -->
          <td>
            <div class="query-form">
              <!-- Element Plus 的行内表单 -->
              <el-form :inline="true">
                <el-form-item label="楼层：">
                  <!-- 下拉选择器，绑定 form.floor 变量，change 事件触发 findBedUsage 方法 -->
                  <el-select style="width: 120px;" v-model="form.floor" @change="findBedUsage">
                    <el-option label="一楼" value="一楼" />
                    <el-option label="二楼" value="二楼" />
                  </el-select>
                </el-form-item>
              </el-form>
            </div>
          </td>
          <!-- 总床数统计列 -->
          <td style="width: 120px">
            <div>
              <img src="@/assets/bed/all.png" />
              <span class="pic-text">总床数:</span>{{ count.totalNum }}
            </div>
          </td>
          <!-- 空闲床数统计列 -->
          <td style="width: 120px">
            <div>
              <img src="@/assets/bed/kx.png" />
              <span class="pic-text">空闲:</span>{{ count.availableNum }}
            </div>
          </td>
          <!-- 有人床数统计列 -->
          <td style="width: 120px">
            <div>
              <img src="@/assets/bed/yr.png" />
              <span class="pic-text">有人:</span>{{ count.occupiedNum }}
            </div>
          </td>
          <!-- 外出床数统计列 -->
          <td style="width: 120px">
            <div>
              <img src="@/assets/bed/wc.png" />
              <span class="pic-text">外出:</span>{{ count.outwardNum }}
            </div>
          </td>
        </tr>
      </table>
    </div>
    <div class="map">
      <table border="1px" cellspacing="20px" style="border-collapse: collapse; width: 1200px">
        <tbody>
          <tr class="cwsyt_thead">
            <!-- 房间号循环展示（1001 相关） -->
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index < 1">
              {{ item.roomNo }}
            </td>
            <!-- 固定内容单元格（电梯厅等） -->
            <td class="room_id" rowspan="2" style="background-color: #aaeeee">
              电梯厅
            </td>
            <td class="room_id" rowspan="2" colspan="2" style="background-color: #9ac0cd">
              洗衣房
            </td>
            <td class="room_id" rowspan="2" colspan="2" style="background-color: #4eee94">
              活动中心
            </td>
            <!-- 房间号循环展示（1002、1003、1004 相关） -->
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index > 0 && index < 4">
              {{ item.roomNo }}
            </td>
            <!-- 固定内容单元格（走道） -->
            <td class="room_id" rowspan="2" style="background-color: #cdaa70">
              走道
            </td>
            <!-- 房间号循环展示（1005、1006 相关） -->
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 4 && index < 6">
              {{ item.roomNo }}
            </td>
          </tr>
          <tr class="cwsyt_tbody">
            <!-- 遍历房间列表，仅显示索引小于6的房间 -->
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index < 6">
              <!-- 遍历房间内的床位列表，href 为伪链接 -->
              <a href="javascript:void(0)" v-for="bedItem in item.bedList" :key="bedItem.bedNo">
                <div>
                  <!-- 根据床位状态显示对应图标 -->
                  <img v-if="bedItem.bedStatus == 1" src="@/assets/bed/kx.png" />
                  <img v-if="bedItem.bedStatus == 2" src="@/assets/bed/yr.png" />
                  <img v-if="bedItem.bedStatus == 3" src="@/assets/bed/wc.png" />
                  <!-- 显示床位号 -->
                  {{ bedItem.bedNo }}
                </div>
              </a>

            </td>
          </tr>
          <tr class="cwsyt_thead">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 6">{{ item.roomNo }}</td>
          </tr>
          <tr class="cwsyt_tbody">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 6">
              <a href="javascript:void(0)" v-for="bedItem in item.bedList" :key="bedItem.bedNo">
                <div>
                  <img v-if="bedItem.bedStatus == 1" src="@/assets/bed/kx.png" />
                  <img v-if="bedItem.bedStatus == 2" src="@/assets/bed/yr.png" />
                  <img v-if="bedItem.bedStatus == 3" src="@/assets/bed/wc.png" />
                  {{ bedItem.bedNo }}
                </div>
              </a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
// 从项目 api 目录下的 bedApi.js 文件中，导入 findBedUsage 接口方法
import { findBedUsage } from "@/api/bedApi.js";

export default {
  // 组件的 data 选项，返回响应式数据
  data() {
    return {
      // 查询条件数据，这里默认楼层为“一楼”
      form: {
        floor: "一楼",
      },
      // 统计数据，存储总床数、空闲床数、有人床数、外出床数，初始值为空
      count: {
        totalNum: "",
        availableNum: "",
        occupiedNum: "",
        outwardNum: "",
      },
      // 房间列表数据，初始为空数组，用于存储接口返回的房间信息
      listRoom: [],
    };
  },
  // 组件挂载完成后执行的钩子函数
  mounted() {
    // 初始化调用查询方法，加载床位相关数据
    this.findBedUsage();
  },
  // 组件的方法集合
  methods: {
    // 查询房间和床位信息列表、床位统计信息的方法
    findBedUsage() {
      // 调用导入的接口方法，传入查询条件 form
      findBedUsage(this.form).then((res) => {
        // 接口返回成功后，更新 count 里的总床数
        this.count.totalNum = res.data.totalNum;
        // 更新 count 里的空闲床数
        this.count.availableNum = res.data.availableNum;
        // 更新 count 里的有人床数
        this.count.occupiedNum = res.data.occupiedNum;
        // 更新 count 里的外出床数
        this.count.outwardNum = res.data.outwardNum;
        // 更新房间列表数据
        this.listRoom = res.data.roomList;
      });
    },
  },
};
</script>

<style scope>
.main .query {
  height: 60px;
}

.main .query .query-table {
  height: 60px;
}

.main .query .query-table .query-form {
  margin-top: 12px;
}

.main .query .query-table img {
  width: 25px;
  height: 13px;
}

.main .query .query-table .pic-text {
  margin-left: 5px;
  margin-right: 5px;
  font-weight: 700;
}

.main .map {
  margin-top: 3px;
}

.main .map .cwsyt_thead {
  background-color: #0168b7;
  color: white;
  text-align: center;
}

.main .map .cwsyt_tbody {
  height: 140px;
  text-align: center;
}

.main .map .cwsyt_tbody div {
  width: 50px;
  margin-top: 5px;
}

.main .map .cwsyt_tbody div>img {
  width: 100%;
  height: 100%;
  margin-left: 35%;
}

.main .map table>tbody>tr>td {
  border: 1px solid #ddd;
}

a {
  color: #333;
}
</style>

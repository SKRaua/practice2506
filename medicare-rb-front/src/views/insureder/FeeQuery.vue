<template>
    <div class="common-layout">
        <el-container>
            <!-- 头部搜索 -->
            <el-header>
                <div>
                    <el-row :gutter="30">
                        <el-col :span="7">
                            <el-input placeholder="请输入姓名查询" v-model="queryParams.customerName" @clear="query" clearable
                                size="large" @keyup.enter="query">
                                <template #append>
                                    <el-button type="info" @click="query" style="color: black">查询</el-button>
                                </template>
                            </el-input>
                        </el-col>
                    </el-row>
                </div>
            </el-header>

            <!-- 主体：参保人列表 + 费用详情 -->
            <el-main>
                <el-row :gutter="20">
                    <!-- 左侧：参保人表格（占16列） -->
                    <el-col :span="16">
                        <div class="table-main">
                            <div class="table-main-header">参保人信息</div>
                            <!-- 参保人表格（新增 @row-click 事件） -->
                            <el-table :data="customerInfoList" highlight-current-row size="small"
                                style="width: 100%; color: black" stripe @row-click="handleRowClick">
                                <!-- 原有列保持不变 -->
                                <el-table-column type="index" label="序号" width="60" />
                                <el-table-column prop="name" label="姓名" width="60" />
                                <el-table-column align="center" prop="inpatientNo" label="住院号" width="120" />
                                <el-table-column align="center" prop="idCard" label="身份证号" width="180" />
                                <el-table-column align="center" prop="gender" label="性别" width="40">
                                    <template #default="scope">
                                        {{
                                            scope.row.gender === 0
                                                ? "女"
                                                : scope.row.gender === 1
                                                    ? "男"
                                                    : "未知"
                                        }}
                                    </template>
                                </el-table-column>=
                            </el-table>
                            <!-- 分页 -->
                            <div style="margin-top: 15px">
                                <el-pagination :page-size="page.pageSize" :current-page="page.currentPage"
                                    :total="page.total" layout="prev, pager, next, total"
                                    @current-change="handleCurrentChange" />
                            </div>
                        </div>
                    </el-col>

                    <!-- 右侧：费用详情（占8列） -->
                    <el-col :span="8">
                        <div class="cost-panel">
                            <div class="cost-title">费用详情</div>

                            <!-- 1. 药品信息表 -->
                            <div class="cost-table">
                                <h3>药品信息</h3>
                                <el-table :data="drugList" size="small" stripe empty-text="暂无药品数据">
                                    <!-- <el-table-column prop="drugName" label="通用名称" />
                                    <el-table-column prop="specification" label="规格" />
                                    <el-table-column prop="unit" label="计价单位" />
                                    <el-table-column prop="manufacturer" label="生产企业" />
                                    <el-table-column prop="price" label="单价" width="80" /> -->
                                </el-table>
                                <el-pagination v-model:current-page="drugPage.currentPage"
                                    :page-size="drugPage.pageSize" :total="drugPage.total"
                                    layout="prev, pager, next, total" @current-change="loadDrugList"
                                    style="margin-top: 10px" />
                            </div>

                            <!-- 2. 医疗服务表 -->
                            <div class="cost-table">
                                <h3>医疗服务</h3>
                                <el-table :data="medicalServiceList" size="small" stripe empty-text="暂无医疗服务数据">
                                    <!-- <el-table-column prop="itemName" label="项目名称" />
                                    <el-table-column prop="itemCode" label="项目编码" width="120" />
                                    <el-table-column prop="unit" label="计价单位" />
                                    <el-table-column prop="price" label="单价" width="80" /> -->
                                </el-table>
                                <el-pagination v-model:current-page="medicalServicePage.currentPage"
                                    :page-size="medicalServicePage.pageSize" :total="medicalServicePage.total"
                                    layout="prev, pager, next, total" @current-change="loadMedicalServiceList"
                                    style="margin-top: 10px" />
                            </div>

                            <!-- 3. 诊疗项目表 -->
                            <div class="cost-table">
                                <h3>诊疗项目</h3>
                                <el-table :data="treatmentItemList" size="small" stripe empty-text="暂无诊疗项目数据">
                                    <!-- <el-table-column prop="itemName" label="项目名称" />
                                    <el-table-column prop="itemCode" label="项目编码" width="120" />
                                    <el-table-column prop="unit" label="计价单位" />
                                    <el-table-column prop="price" label="单价" width="80" /> -->
                                </el-table>
                                <el-pagination v-model:current-page="treatmentItemPage.currentPage"
                                    :page-size="treatmentItemPage.pageSize" :total="treatmentItemPage.total"
                                    layout="prev, pager, next, total" @current-change="loadTreatmentItemList"
                                    style="margin-top: 10px" />
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-main>
        </el-container>
    </div>
</template>


<script setup>
import { ref, reactive, onMounted, watch } from "vue";
// import { ElMessage, ElMessageBox } from "element-plus";
// import { Plus } from "@element-plus/icons-vue";
// 假设后端接口：根据参保人ID查询三表数据
import {
    selectInsurederPage,
    // getDrugByInsurederId,     // 药品表接口
    // getMedicalServiceByInsurederId, // 医疗服务表接口
    // getTreatmentItemByInsurederId,  // 诊疗项目表接口
} from "@/api/insurederApi.js";

// 原有变量保持不变...

// 查询参数
const queryParams = reactive({
    customerName: "",
});

// 分页和条件
const page = reactive({
    total: 0,
    pageSize: 6,
    currentPage: 1,
});
const condition = reactive({
    name: "",//客户名
    page: 1,
});

// 数据列表
const customerInfoList = ref([]);

// // 弹窗表单（新增InsurederVo的属性）
// const form = reactive({
//     id: null,
//     name: "",
//     idCard: "",
//     gender: 2,
//     birthDate: "",
//     age: null, // 年龄通常由出生日期计算，前端可留空或后端返回
//     inpatientNo: "", // 新增：住院号
//     settlementType: "", // 新增：结算类型
//     admissionTime: "", // 新增：入院时间
//     dischargeTime: "", // 新增：出院时间
//     emergencyContact: "", // 新增：紧急联系人
//     address: "",
//     workStatus: "",
//     contactPhone: "",
// });

// 加载数据
const loadCustomerList = async () => {
    condition.name = queryParams.customerName;
    condition.page = page.currentPage;
    try {
        const res = await selectInsurederPage(condition);
        if (res.flag) {
            customerInfoList.value = res.data.records;
            page.total = res.data.total;
            page.pageSize = res.data.size;
            page.currentPage = res.data.current;
        } else {
            ElMessage.error(res.message || "查询失败");
        }
    } catch (err) {
        ElMessage.error("网络错误，请重试");
    }
};

// 查询
const query = () => {
    page.currentPage = 1;
    loadCustomerList();
};

// 分页
const handleCurrentChange = (curPage) => {
    page.currentPage = curPage;
    loadCustomerList();
};


// 初始化
onMounted(() => {
    loadCustomerList();
});


// // ========== 新增：费用表数据 & 分页 ==========
// const drugList = ref([]);
// const drugPage = reactive({
//     total: 0,
//     pageSize: 5,  // 每页5条，可调整
//     currentPage: 1
// });

// const medicalServiceList = ref([]);
// const medicalServicePage = reactive({
//     total: 0,
//     pageSize: 5,
//     currentPage: 1
// });

// const treatmentItemList = ref([]);
// const treatmentItemPage = reactive({
//     total: 0,
//     pageSize: 5,
//     currentPage: 1
// });

// // 当前选中的参保人ID（点击表格行时赋值）
// const currentInsurederId = ref(null);

// // ========== 新增：加载费用表的方法 ==========
// /** 加载药品列表 */
// const loadDrugList = async (page = drugPage.currentPage) => {
//     if (!currentInsurederId.value) return; // 未选中参保人，不加载
//     drugPage.currentPage = page;
//     try {
//         const res = await getDrugByInsurederId({
//             insurederId: currentInsurederId.value,
//             page: drugPage.currentPage,
//             pageSize: drugPage.pageSize
//         });
//         if (res.flag) {
//             drugList.value = res.data.records;
//             drugPage.total = res.data.total;
//         } else {
//             ElMessage.error(res.message || "药品数据加载失败");
//         }
//     } catch (err) {
//         ElMessage.error("网络错误，请重试");
//     }
// };

// /** 加载医疗服务列表 */
// const loadMedicalServiceList = async (page = medicalServicePage.currentPage) => {
//     if (!currentInsurederId.value) return;
//     medicalServicePage.currentPage = page;
//     try {
//         const res = await getMedicalServiceByInsurederId({
//             insurederId: currentInsurederId.value,
//             page: medicalServicePage.currentPage,
//             pageSize: medicalServicePage.pageSize
//         });
//         if (res.flag) {
//             medicalServiceList.value = res.data.records;
//             medicalServicePage.total = res.data.total;
//         } else {
//             ElMessage.error(res.message || "医疗服务数据加载失败");
//         }
//     } catch (err) {
//         ElMessage.error("网络错误，请重试");
//     }
// };

// /** 加载诊疗项目列表 */
// const loadTreatmentItemList = async (page = treatmentItemPage.currentPage) => {
//     if (!currentInsurederId.value) return;
//     treatmentItemPage.currentPage = page;
//     try {
//         const res = await getTreatmentItemByInsurederId({
//             insurederId: currentInsurederId.value,
//             page: treatmentItemPage.currentPage,
//             pageSize: treatmentItemPage.pageSize
//         });
//         if (res.flag) {
//             treatmentItemList.value = res.data.records;
//             treatmentItemPage.total = res.data.total;
//         } else {
//             ElMessage.error(res.message || "诊疗项目数据加载失败");
//         }
//     } catch (err) {
//         ElMessage.error("网络错误，请重试");
//     }
// };

// // ========== 新增：参保人表格行点击事件 ==========
// const handleRowClick = (row) => {
//     currentInsurederId.value = row.id;
//     // 切换参保人时，重置分页为第1页
//     loadDrugList(1);
//     loadMedicalServiceList(1);
//     loadTreatmentItemList(1);
// };

// // ========== 初始化优化：默认选中第一行 ==========
// onMounted(() => {
//     loadCustomerList().then(() => {
//         if (customerInfoList.value.length > 0) {
//             currentInsurederId.value = customerInfoList.value[0].id;
//             loadDrugList(1);
//             loadMedicalServiceList(1);
//             loadTreatmentItemList(1);
//         }
//     });
// });

// 原有方法（查询、分页、增删改）保持不变...
</script>
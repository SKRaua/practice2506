import http from "@/request/request.js";

// 分页查询
export function listPage(data) {
    return http.get("/customerNurseItem/listPage", { params: data });
}

//用户是否配置某个项目
export function isIncludesItemCustomer(data) {
    return http.get("/customerNurseItem/isIncludesItemCustomer", { params: data });
}

// 为客户批量添加护理项目
export function addItemToCustomer(data) {
    return http.post("/customerNurseItem/addItemToCustomer", data);
}

// 删除
export function del(data) {
    return http.post("/customerNurseItem/delete", data);
}

// 删除客户护理级别和级别下项目
export function delLevelAndItem(data) {
    return http.post("/customerNurseItem/delLevelAndItem", data);
}

// 客户续费
export function enewNurseItem(data) {
    return http.post("/customerNurseItem/enewNurseItem", data);
}

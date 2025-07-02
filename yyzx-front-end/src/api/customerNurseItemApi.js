import http from "@/request/request.js";

// 分页查询
export function listPage() {
    return http.get("/customerNurseItem/listPage", { params: data });
}

//用户是否配置某个项目
export function isIncludesItemCustomer() {
    return http.get("/customerNurseItem/isIncludesItemCustomer", { params: data });
}

// 为客户批量添加护理项目
export function addItemToCustomer() {
    return http.post("/customerNurseItem/addItemToCustomer", data);
}

// 删除
export function del() {
    return http.post("/customerNurseItem/delete", data);
}

// 删除客户护理级别和级别下项目
export function delLevelAndItem() {
    return http.post("/customerNurseItem/delLevelAndItem", data);
}

// 客户续费
export function enewNurseItem() {
    return http.post("/customerNurseItem/enewNurseItem", data);
}

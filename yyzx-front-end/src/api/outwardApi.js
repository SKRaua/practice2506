import http from "@/request/request.js";

// 分页查询
export function listOutwardPage(data) {
    return http.get("/outward/listPage", { params: data });
}

// 添加请求
export function addOutward(data) {
    return http.post("/outward/add", data);
}

// 删除请求 
export function delOutward(data) {
    return http.post("/outward/delete", data);
}

// 审批外出
export function examineOutward(data) {
    return http.post("/outward/examineOutward", data);
}

// 登记回院时间
export function updateBackTime(data) {
    return http.post("/outward/updateBackTime", data);
}

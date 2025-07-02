import http from "@/request/request.js";

// 分页查询
export function listPage() {
    return http.get("/outward/listPage", { params: data });
}

// 添加请求
export function add() {
    return http.post("/outward/add", data);
}

// 删除请求
export function del() {
    return http.post("/outward/delete", data);
}

// 审批外出
export function examineOutward() {
    return http.post("/outward/examineOutward", data);
}

// 登记回院时间
export function updateBackTime() {
    return http.post("/outward/updateBackTime", data);
}

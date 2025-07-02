import http from "@/request/request.js";

// 分页查询
export function listPage() {
    return http.get("/customerPreference/listPage", { params: data });
}

// 添加
export function add() {
    return http.post("/customerPreference/add", data);
}

// 移除
export function remove() {
    return http.post("/customerPreference/remove", data);
}

// 更新
export function update() {
    return http.post("/customerPreference/update", data);
}


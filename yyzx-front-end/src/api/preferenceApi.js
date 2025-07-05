import http from "@/request/request.js";

// 分页查询
export function listPreferencePage(data) {
    return http.get("/customerPreference/listPage", { params: data });
}

// 添加
export function addPreference(data) {
    return http.post("/customerPreference/add", data);
}

// 移除
export function removePreference(data) {
    return http.post("/customerPreference/remove", data);
}

// 更新
export function updatePreference(data) {
    return http.post("/customerPreference/update", data);
}


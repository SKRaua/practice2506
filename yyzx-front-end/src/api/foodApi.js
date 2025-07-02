import http from "@/request/request.js";

// 查询
export function listFood() {
    return http.get("/food/listFood", { params: data });
}
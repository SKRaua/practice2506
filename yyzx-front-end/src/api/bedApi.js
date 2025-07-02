import http from "@/request/request.js";

// 查询
export function findBed() {
    return http.get("/bed/findBed", { params: data });
}
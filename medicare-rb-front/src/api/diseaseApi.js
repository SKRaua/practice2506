import http from "@/request/request.js";

// 分页查询疾病
export function getDiseasePage(data) {
    return http.get("/disease/info", { params: data });
}
import http from "@/request/request.js";

// 药品分页查询
export function getDrugPage(data) {
    return http.get("/drug/info", { params: data });
}
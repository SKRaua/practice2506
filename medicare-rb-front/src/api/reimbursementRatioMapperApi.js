import http from "@/request/request.js";

// 分页查询药品订单
export function getReimbursementRatioPage(data) {
    return http.get("/reimbursementRatio/info", { params: data });
}
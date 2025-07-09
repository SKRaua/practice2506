import http from "@/request/request.js";

// 分页查询药品订单
export function getDrugOrderPage(data) {
    return http.get("/drugOrder/info", { params: data });
}
import http from "@/request/request.js";

// 分页查询诊疗项目订单
export function getTreatmentItemOrderPage(data) {
    return http.get("/treatmentItemOrder/info", { params: data });
}
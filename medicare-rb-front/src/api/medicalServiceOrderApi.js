import http from "@/request/request.js";

// 分页查询医疗服务订单
export function getMedicalServiceOrderPage(data) {
    return http.get("/medicalServiceOrder/info", { params: data });
}
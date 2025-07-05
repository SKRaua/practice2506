import http from "@/request/request.js";

// 分页查询
export function listCustomerInfoPage(data) {
    return http.get("/customer/listCustomerInfoPage", { params: data });
}


//入住登记
export function checkIn(data) {
    return http.post('/customer/checkIn', data)
}

//修改
export function updateCustomer(data) {
    return http.post('/customer/update', data)
}

//删除
export function delCustomer(data) {
    return http.post('/customer/delete', data)
}



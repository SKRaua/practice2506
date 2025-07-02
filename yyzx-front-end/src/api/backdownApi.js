import http from "@/request/request.js";

// 分页查询
export function listPage() {
    return http.get("/backdown/listPage", { params: data });
}


//添加
export function add(data) {
    return http.post('/backdown/add', data)
}

//审批退住申请
export function examineBackdown(data) {
    return http.post('/backdown/examineBackdown', data)
}

//删除
export function del(data) {
    return http.post('/backdown/delete', data)
}



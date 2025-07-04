import http from "@/request/request.js";

// 分页查询
export function listNurseRecordsVo(data) {
    return http.get("/nurseRecord/listPage", { params: data });
}

// 查询外出记录
export function queryOutwardVo(data) {
    return http.get("/nurseRecord/queryOutwardVo", { params: data });
}

//添加
export function add(data) {
    return http.post('/nurseRecord/add', data)
}


//移除
export function del(data) {
    return http.post('/nurseRecord/delete', data)
}



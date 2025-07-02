import http from "@/request/request.js";


//添加
export function add(data) {
    return http.post('/nurseLevel/add', data)
}

//修改
export function update(data) {
    return http.post('/nurseLevel/update', data)
}

//移除
export function remove(data) {
    return http.post('/nurseLevel/remove', data)
}



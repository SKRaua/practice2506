import http from "@/request/request.js";


//添加
export function listByLevel(data) {
    return http.get('/nurseContent/listByLevel', { params: data })
}

//修改
export function update(data) {
    return http.post('/nurseContent/update', data)
}

//删除
export function del(data) {
    return http.post('/nurseLevel/delete', data)
}



import http from "@/request/request.js";


//添加
export function listNurseContentByLevel(data) {
    return http.get('/nurseContent/listByLevel', { params: data })
}

//修改
export function updateNurseContent(data) {
    return http.post('/nurseContent/update', data)
}

//删除
export function delNurseContent(data) {
    return http.post('/nurseLevel/delete', data)
}



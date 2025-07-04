import http from "@/request/request.js";

// 分页查询
export function listPage(data) {
    return http.get("/bedDetails/listPage", { params: data });
}


//床位调换
export function exchangeBed(data) {
    return http.post('/bedDetails/exchangeBed', data)
}

//修改
export function update(data) {
    return http.post('/bedDetails/update', data)
}

//移除
export function remove(data) {
    return http.post('/bedDetails/remove', data)
}



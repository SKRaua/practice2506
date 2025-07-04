import http from "@/request/request.js";

// 分页查询
export function listPage(data) {
    return http.get("/meal/listPage", { params: data });
}


//添加
export function add(data) {
    return http.post('/meal/add', data)
}

//修改
export function update(data) {
    return http.post('/meal/update', data)
}

//移除
export function remove(data) {
    return http.post('/meal/remove', data)
}



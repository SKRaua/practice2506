import http from "@/request/request.js";

// 分页查询
export function listPage(data) {
    return http.get("/meal/listPage", { params: data });
}


//添加
export function addMeal(data) {
    return http.post('/meal/add', data)
}

//修改
export function updateMeal(data) {
    return http.post('/meal/update', data)
}

//移除
export function removeMeal(data) {
    return http.post('/meal/remove', data)
}



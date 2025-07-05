import http from "@/request/request.js";

// 查询
export function findBed(data) {
    return http.get("/bed/findBed", { params: data });
}

//获取床位示意图数据
export function findBedUsage(data) {
    return http.get('/room/findBedUsage', { params: data })
}

// 分页查询
export function listBedDetailsPage(data) {
    return http.get("/bedDetails/listPage", { params: data });
}


//床位调换
export function exchangeBed(data) {
    return http.post('/bedDetails/exchangeBed', data)
}

//修改
export function updateBedDetails(data) {
    return http.post('/bedDetails/update', data)
}

//移除
export function removeBedDetails(data) {
    return http.post('/bedDetails/remove', data)
}


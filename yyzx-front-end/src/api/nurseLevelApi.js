import http from "@/request/request.js";


//添加
export function addNurseLevel(data) {
    return http.post('/nurseLevel/add', data)
}

//修改
export function updateNurseLevel(data) {
    return http.post('/nurseLevel/update', data)
}

//移除
export function removeNurseLevel(data) {
    return http.post('/nurseLevel/remove', data)
}


//根据护理级别查询护理项目
export function listNurseLevel(data) {
    return http.get("/nurseLevel/listNurseLevel", { params: data })
}
export function queryNurseItemByLevel(data) {
    return http.get("/nurseLevel/listItemToLevel", { params: data })
}

//护理项目配置
export function addItemToLevel(data) {
    return http.post("/nurseLevel/addItemToLevel", data)
}

export function removeNurseLevelItem(data) {
    return http.post("/nurseLevel/removeNurseLevelItem", data)
}



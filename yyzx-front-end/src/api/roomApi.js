import http from "@/request/request.js";

// 查询房间列表
export function listRoom(data) {
    return http.get("/room/listRoom", { params: data });
}

// 查询床位示意视图数据
export function lisfindBedUsagetRoom(data) {
    return http.get("/room/findBedUsage", { params: data });
}





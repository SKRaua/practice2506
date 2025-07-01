//导入封装号的axios @等价于/src
import http from '@/request.request.js'

//用户登录
export function loogin(data) {
    return http.get('/user/login', { params: data })
}

//查询系统用户信息
export function findUserPage(data) {
    return http.get('/user/findUserPage', { params: data })
}

//添加系统用户信息
export function add(data) {
    return http.post('/user/add', data)
}

//修改系统用户信息
export function update(data) {
    return http.post('/user/update', data)
}

//删除系统用户信息
export function remove(data) {
    return http.post('/user/remove', data)
}

// 查询所有用户
export function listPage() {
    return http.get('/user/listPage', { params: data })
}


package org.example.controller;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
 * @author Zhou Xinyang
 */

@RestController
@RequestMapping("/user") // Restful风格
public class UserController2 {

    @Autowired
    private UserMapper userMapper;

    // 查询所有的用户 HTTP GET请求
    @GetMapping("/findAll")
    public String findAll() {
        List<User> list = userMapper.findAll();
        System.out.println("查询所有用户:" + list);
        return "查询所有用户:" + list;
    }

    // 按名字查询用户
    @GetMapping("/findByName/{name}")
    // 通过路径变量参数拿到名字 前端直接发送http://localhost:8080/user/findByName/<name>
    // @PathVariable 功能是将url中的模板变量的参数绑定到控制器参数中
    public String findByName(@PathVariable String name) {
        User user = userMapper.findByName(name);
        System.out.println("查询到用户:" + user);
        return "查询到用户:" + user;
    }

    // 删除指定名字的用户
    // http://localhost:8080/user/deleteByName/<name>
    @DeleteMapping("/deleteByName/{name}")
    public String deleteByName(@PathVariable String name) {
        User user = userMapper.findByName(name);
        userMapper.deleteByName(name);
        System.out.println("已删除用户" + name);
        return "已删除用户" + user;
    }

    // 根据id修改用户
    @PutMapping("/updateById/{id}")
    public String updateById(@RequestBody User user, @PathVariable int id) {
        System.out.println("修改用户" + user);
        userMapper.updateById(user, id);
        return "操作完成！";
    }

    // 插入用户
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println("添加用户:" + user);
        userMapper.addUser(user);
        return "添加完成！";
    }
}

package org.example.controller;

import org.example.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @author Zhou Xinyang 
 */

//@Controller
//@ResponseBody
//@RestController
public class UserController {

    @RequestMapping("/add")
    public String add() {
        return "添加成功";
    }

    // 接收基本类型的参数
    // http://localhost:8080/addParams?id=1&&name=zhang&&age=18
    @RequestMapping("/addParams")
    public String addParams(Integer id, String name, Integer age) {
        System.out.println("获取到参数: id=" + id + ", name=" + name + ", age=" + age);
        return "添加成功: id=" + id + ", name=" + name + ", age=" + age;
    }

    // 接收对象类型的参数
    // http://localhost:8080/addUser?id=1&&name=zhang&&age=18
    // @RequestMapping("/addUser")
    // public String addUser(User user) {
    // System.out.println("获取到user:" + user.toString());
    // return "用户添加成功:"+user.toString();
    // }

    // 接收一个JSON类型的数据
    // @RequestBody将HTTP请求体中的json对象转为Java对象
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println("获取到user: " + user.toString());
        return "用户添加成功: " + user.toString();
    }
}

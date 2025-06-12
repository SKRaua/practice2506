package org.example;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@SpringBootTest
class SpMyBatisApplicationTests {

    @Autowired // 加上Autowired注解,自动加载userMapper
    private UserMapper userMapper;

    @Test // 查询所有的用户
    void userTest1() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test // 查找年龄是25岁的人
    void userTest2() {
        List<User> users = userMapper.findByAge(25);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test // 查询自定义id的用户
    void userTest3() {
        List<User> users = userMapper.findById(1);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test // 在没有MyBatis的情况下使用JDBC连接数据库
    public void testJDBC() throws Exception {
        // 注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/cqupt";
        // 用户名
        String username = "root";
        // 密码
        String password = "12345678";
        // 获取数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);
        // 创建SQL语句
        String sql = "select * from cqupt_user";
        // 操作SQL语句的对象
        Statement statement = connection.createStatement();
        // 执行SQL语句,拿到结果的集合
        ResultSet result = statement.executeQuery(sql);
        // 使用List拿到查询的所有结果
        List<User> userList = new ArrayList<>();
        while (result.next()) {
            // 取出一行中的所有字段的值
            int id = result.getInt("id");
            String username1 = result.getString("username");
            String name1 = result.getString("name");
            int age = result.getInt("age");
            String gender = result.getString("gender");
            // 将获取的资源存储到list中
            User user = new User(id, username1, name1, age, gender);
            userList.add(user); // 存储user
        }
        // 释放资源
        statement.close();
        connection.close();
        result.close();

        // 遍历users
        for (User user : userList) {
            System.out.println(user.toString());
        }

    }

    @Test // 使用xml文件访问数据库
    void userTestXML() {
        List<User> userList = userMapper.findUser();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test // 查询id为3的用户
    void userTestXML1() {
        List<User> userList = userMapper.findUserById(3);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test // 添加一个用户
    void userTestXML2() {
        User user = new User(7, "lisi", "李四", 20, "M");
        int i = userMapper.insertUser(user);
        userTest1(); // 调用userTest1查询所有用户以验证结果
        System.out.println("添加已完成,影响" + i + "行");
    }

    @Test // 将李华的年龄改为18
    void userTestXML3() {
        int i = userMapper.updateUserAge("李华", 18);
        userTest1(); // 调用userTest1查询所有用户以验证结果
        System.out.println("修改已完成,影响" + i + "行");
    }

    @Test // 删除id为3的用户
    void userTestXML4() {
        int i = userMapper.deleteUserById(7);
        userTest1(); // 调用userTest1查询所有用户以验证结果
        System.out.println("删除已完成,影响" + i + "行");
    }
}

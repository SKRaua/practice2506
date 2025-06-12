package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

import java.util.*;

//自动创建实现类,继承了Spring的容器
@Mapper
public interface UserMapper {

    //查询所有用户 @Select查询语句
    @Select("select * from cqupt_user")
    public List<User> findAll();

    //作业1:查询年龄等于25岁的人
    @Select("select * from cqupt_user where age=25")
    public List<User> findByAge(int age);

    //作业2:根据id查询用户 插值语法
    @Select("select * from cqupt_user where id=#{id}")
    public List<User> findById(int id);

    public List<User> findUser();

    public List<User> findUserById(int id);

    public int insertUser(User user);

    public int updateUserAge(String name,int age);

    public int deleteUserById(int id);

}

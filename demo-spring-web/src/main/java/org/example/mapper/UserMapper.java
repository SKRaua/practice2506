package org.example.mapper;

import org.example.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    // 按照name查询
    @Select("select * from user where name=#{name}")
    User findByName(String name);

    // 查询所有用户
    @Select("select * from user")
    List<User> findAll();

    // 添加用户
    @Insert("insert into user(name,age) values(#{name},#{age})")
    int addUser(User user);

    // 根据ID修改用户
    @Update("update user set name=#{user.name},age=#{user.age} where id=#{id}")
    int updateById(User user, int id);

    // 根据name删除用户
    @Delete("delete from user where name=#{name}")
    int deleteByName(String name);
}

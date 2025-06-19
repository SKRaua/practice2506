package org.skraua.dao.impl;

import org.skraua.dao.UserDAO;

/*
 * @author Zhou Xinyang
 */
public class UserDAOImplement implements UserDAO {

    private String name;
    private int age;

    public UserDAOImplement(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void getName() {
        System.out.println("UserDAO——— 我的名字是" + name + "，我今年" + age + "岁。");
    }

    /*
     * public void setName(String name){
     * this.name = name;
     * }
     * 
     * public void setAge(int age){
     * this.age = age;
     * }
     */
}

package com.cqupt.pojo;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class Person {
    private String name = "Zhang san";
    private int age;
    private String sex;

    public Person() {
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    public void eat() {
        System.out.println("I'm eating.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}

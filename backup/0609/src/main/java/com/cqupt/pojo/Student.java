package com.cqupt.pojo;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class Student extends Person {
    private String name;
    private int age;
    private String sex;

    public Student() {
        super();
    }

    public Student(String name, int age, String sex) {
        super(name, age, sex);
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void learn() {
        System.out.println("Be keen on learning.");
    }

    @Override
    public void sleep() {
        System.out.println("Don't need sleeping,be keen on learning.");
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

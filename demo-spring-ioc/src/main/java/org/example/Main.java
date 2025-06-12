package org.example;

import org.example.dao.UserDAO;
import org.example.dao.impl.PersonDAOImplement;
import org.example.service.BookService;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * @author Zhou Xinyang
 */
public class Main {
    public static void main(String[] args) {
        // UserDAOImplement userDAOImplement = new UserDAOImplement();
        // userDAOImplement.getName();

        // 使用IoC方式获取Bean对象
        @SuppressWarnings("resource")
        ApplicationContext act = new ClassPathXmlApplicationContext("application.xml");// 获取IOC容器
        // 获取bean
        // spring管理的bean默认是单例的 默认只建立一个对象
        UserDAO userDAO1 = (UserDAO) act.getBean("userDAO");
        UserDAO userDAO2 = (UserDAO) act.getBean("userDAO");
        userDAO1.getName();
        System.out.println("bean为单例：" + (userDAO1 == userDAO2));

        // 使用IoC方式获取Bean对象 完成Service层操作
        UserService userService = (UserService) act.getBean("userService");
        userService.knowName();

        BookService bookService = (BookService) act.getBean("bookService");
        bookService.writeBook();

        PersonDAOImplement person1 = new PersonDAOImplement();
        person1.setName("周日");
        person1.setAge(21);
        person1.setGender("男");
        person1.setAddress("重庆市南岸区");
        person1.setPhone("0721-1234567");
        System.out.println(person1);

        PersonDAOImplement person2 = new PersonDAOImplement("周昕", 21, "男", "提瓦特", "5533544");
        System.out.println(person2);

    }
}

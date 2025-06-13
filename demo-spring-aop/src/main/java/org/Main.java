package org;

import org.example.config.SpringConfig;
import org.example.dao.BookDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * @author Zhou Xinyang
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDAO bookDAO = context.getBean(BookDAO.class);

        // bookDAO.save();
        // bookDAO.select();
        Integer v = bookDAO.delete();
        System.out.println("value:" + v);
        // bookDAO.update();

        // bookDAO.testEffciency("select");

    }
}

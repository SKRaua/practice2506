package org.example.dao.impl;

import org.example.dao.BookDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/*
 * @author Zhou Xinyang
 */
@Repository
public class BookDAOImpl implements BookDAO {

    @Value("${name}")
    private String name;

    @Value("${author}")
    private String author;

    @Override
    public void save() {
        // System.out.println("书名："+name+"，作者："+author);
        System.out.println("save...");
    }

    @Override
    public void select() {
        System.out.println("select...");
    }

    @Override
    public Integer delete() {
        System.out.println("delete...");
        return 100;
    }

    @Override
    public void update() {
        System.out.println("update...");
    }

    // 记录执行万次操作的时间
    @Override
    public void testEffciency(String functionName) {
        long start = System.currentTimeMillis(); // 记录开始的时间
        for (int i = 0; i < 100000; i++) { // 计算业务执行万次的时间
            if (functionName.equals("save")) {
                save();
            } else if (functionName.equals("select")) {
                select();
            } else if (functionName.equals("delete")) {
                delete();
            } else if (functionName.equals("update")) {
                update();
            }
        }
        long end = System.currentTimeMillis(); // 记录结束的时间
        System.out.println("万次执行的时间:" + (end - start) + "ms");
    }

}

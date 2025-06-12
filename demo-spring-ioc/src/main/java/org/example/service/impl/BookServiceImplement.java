package org.example.service.impl;

import org.example.dao.BookDAO;
import org.example.service.BookService;

/*
 * @author Zhou Xinyang
 */
public class BookServiceImplement implements BookService {

    private BookDAO bookDAO;

    public BookServiceImplement() {
    };

    public BookServiceImplement(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void writeBook() {
        System.out.println("BookService: 拿到bookDAO,开始写书。。。");
        bookDAO.readBook();
    }

    // public void setBookDAO(BookDAO bookDAO) {
    // this.bookDAO = bookDAO;
    // }

}

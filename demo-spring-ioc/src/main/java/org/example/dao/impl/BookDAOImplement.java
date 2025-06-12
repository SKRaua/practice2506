package org.example.dao.impl;

import org.example.dao.BookDAO;

/*
 * @author Zhou Xinyang
 */
public class BookDAOImplement implements BookDAO {

    private String bookName;
    private String author;

    public BookDAOImplement(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public void readBook() {
        System.out.println("BookDAO——— 书名：" + bookName + "，作者：" + author);
    }

    // public void setBookName(String bookName) {
    // this.bookName = bookName;
    // }
    //
    // public void setAuthor(String author) {
    // this.author = author;
    // }
}

package com.cqupt.pojo;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class Book {
    private String title="数据结构";
    private String author="严蔚敏";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override //注解
    public String toString() {
        return "我的书是:"+getTitle()+",该书的作者是:"+getAuthor();
    }

    public void printBook(){
        System.out.println("书名: "+title+", 作者: "+author);
    }

    //重载函数 有参printBook
    public void printBook(String title1,String author1){
        System.out.println("书名: "+title1+", 作者: "+author1);
    }



}

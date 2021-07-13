package com.virgonia.spring5.bean;

public class Library {
    private Book book;

/*    public Library(Book book) {
        this.book = book;
    }*/

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void toLibarary(){
        System.out.println("此书："+book.getbName()+"已存入图书馆中");
        System.out.println(book);
    }
}

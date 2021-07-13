package com.virgonia.spring5.jdbctemp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 6:07
 */
@Component
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    public void updateBook(Book book){
        bookDao.update(book);
    }

    public void deleteBook(String id){
        bookDao.delete(id);
    }

    public int selectCount(){
        return bookDao.count();
    }

    public Book findBookInfo(String id){
        return bookDao.book(id);
    }

    public List<Book> findAllBook(){
        return bookDao.books();
    }

    public void addBatch(List<Object[]> batch){
        bookDao.addbatch(batch);
    }

    public void updateBatch(List<Object[]> batch){
        bookDao.updatebatch(batch);
    }

    public void deleteBatch(List<Object[]> batch){
        bookDao.deletebatch(batch);
    }




}

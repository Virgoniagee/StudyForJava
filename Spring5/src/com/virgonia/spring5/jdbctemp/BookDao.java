package com.virgonia.spring5.jdbctemp;

import java.util.List;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 6:07
 */
public interface BookDao {
    void add(Book book);//添加接口

    void update(Book book);

    void delete(String id);

    int count();

    Book book(String id);

    List<Book> books();

    void updatebatch(List<Object[]> batch);

    void addbatch(List<Object[]> batch);

    void deletebatch(List<Object[]> batch);
}

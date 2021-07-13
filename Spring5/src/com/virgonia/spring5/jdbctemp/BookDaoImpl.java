package com.virgonia.spring5.jdbctemp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 6:07
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        String sql = "insert into t_user value (?,?,?)";
        Object[] args = {book.getUserId(),book.getUserName(),book.getUserStatus()};
        int update = jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Book book) {
        String sql = "update t_user set user_Name=?,user_Status=? where user_Id=?";
        Object[] args = {book.getUserName(),book.getUserStatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_user where user_Id=?";
        //Object[] args = {book.getUserId()};
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    @Override
    public int count(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book book(String id) {
        String sql = "select * from t_user where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> books() {
        String sql = "select * from t_user";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public void addbatch(List<Object[]> batch) {
        String sql = "insert into t_user value (?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batch);
        System.out.println(ints);

    }

    @Override
    public void deletebatch(List<Object[]> batch) {
        String sql = "delete from t_user where user_Id=?";
        jdbcTemplate.batchUpdate(sql,batch);
    }

    @Override
    public void updatebatch(List<Object[]> batch) {
        String sql = "update t_user set user_Name=?,user_Status=? where user_Id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batch);
        System.out.println(ints);
    }
}

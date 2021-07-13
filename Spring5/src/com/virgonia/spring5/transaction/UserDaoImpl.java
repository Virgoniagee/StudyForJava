package com.virgonia.spring5.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/11 16:51
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void upmoney(int id) {
        String sql = "update user set u_money=u_money+500 where u_id =?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void demoney(int id) {
        String sql = "update user set u_money=u_money-500 where u_id =?";
        jdbcTemplate.update(sql,id);
    }


}

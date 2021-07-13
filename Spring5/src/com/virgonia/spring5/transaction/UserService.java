package com.virgonia.spring5.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/11 16:51
 */
@Service

public class UserService {

    @Autowired
    UserDao userDao;

    public void upMoney(int id){
        userDao.upmoney(id);
    }

    public void deMoney(int id){
        userDao.demoney(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.REPEATABLE_READ,rollbackFor = Exception.class)
    public void change(){

            deMoney(12);
            System.out.println(5/0);
            upMoney(13);


    }

}

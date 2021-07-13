package com.virgonia.spring5.service;

import com.virgonia.spring5.dao.UserDao;
import com.virgonia.spring5.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 2:18
 */
@Service(value = "userService") //等价于<bean id="userService"

public class UserService {
    //不需要set方法 注解内封装了
    //@Autowired
    //@Qualifier(value = "userDaoImpl")//名称是别名 是实现类里配置的id
    //@Resource 可以是按名字也可以是按类型
    @Value("value")
    private String elem;

    @Autowired
    private UserDao userDao;
    public void method(){
        System.out.println("@Component得到的userService……");
        System.out.println(elem);
        userDao.method();
    }
}

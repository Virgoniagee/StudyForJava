package com.virgonia.spring5.test;

import com.virgonia.spring5.transaction.TransactionConfig;
import com.virgonia.spring5.transaction.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/11 17:13
 */
public class TransactionTest {
    /*程序出错时避免回滚*/
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.change();
        System.out.println(userService);
    }
}

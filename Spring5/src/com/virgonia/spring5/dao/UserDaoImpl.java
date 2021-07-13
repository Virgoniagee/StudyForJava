package com.virgonia.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 3:06
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void method() {
        System.out.println("实现类实现了UserDao并重写了方法……");
    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update() {
        return "已更新方法";

    }
}

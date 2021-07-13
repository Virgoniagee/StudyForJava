package com.virgonia.spring5.aop;

import org.springframework.stereotype.Component;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 4:12
 */
@Component
public class Aop {

    public void add() {

        System.out.println("实现类add……"/*+1/0*/);
    }
}

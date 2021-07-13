package com.virgonia.spring5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 4:12
 */
@Component
@Aspect//生成代理对象

public class AopProxy {

    //切入点提取 减少切入点中指定位置的繁琐工作 同时解耦
    @Pointcut(value = "execution(* com.virgonia.spring5.aop.Aop.add(..))")
    public void point(){

    }

    @Before(value = "point()")
    public void before(){
        System.out.println("before……");
    }

    @After(value = "execution(* com.virgonia.spring5.aop.Aop.add(..))")
    public void after(){
        System.out.println("after……");
    }


    @AfterReturning(value = "execution(* com.virgonia.spring5.aop.Aop.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning……");
    }


    //异常通知 被增强方法中出现异常才会出现
    @AfterThrowing(value = "execution(* com.virgonia.spring5.aop.Aop.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing……");
    }

    @Around(value = "execution(* com.virgonia.spring5.aop.Aop.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("around前……");
        proceedingJoinPoint.proceed();
        System.out.println("around后……");
    }

}




package com.virgonia.spring5.test;

import com.virgonia.spring5.aop.Aop;
import com.virgonia.spring5.aop.AopConfig;
import com.virgonia.spring5.dao.UserDao;
import com.virgonia.spring5.dao.UserDaoImpl;
import com.virgonia.spring5.aop.Things;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/9 3:37
 */
public class AOPTest {
    @Test
    public void JDKProxy(){

        //2 需要一个接口
        Class[] interfaces = {UserDao.class};
        //3 invocationHandler接口的实现类 可以new匿名内部类 或 创建实现invocationHandler的类 调用invoke方法写增强逻辑
        UserDaoImpl userDao = new UserDaoImpl();
        //1 创建接口实现类对象 用反射 代理
        //根据创建的接口获得代理对象
        UserDao proxy = (UserDao) Proxy.newProxyInstance(AOPTest.class.getClassLoader(), interfaces, new UserDaoHandler(userDao));
        System.out.println(proxy.add(4, 6));
        System.out.println(proxy.update());
    }

    /*
    * 要创建的对象是被代理对象 随机被Aspect创建被代理对象 并由切入点通知切入
    * 使用Aspect创建代理类必须是没有接口的情况
    * 如果@Around没有写入ProceedingJoinPoint proceedingJoinPoint作为形参并throws出异常 则不会实现原有的被增强方法
    * AfterThrowing只有在出现异常时运行 运行机制类似于try-catch中 try出现异常(method中断)后其后的都不执行 然后catch(AfterThrowing)到异常并finally(After)
    * 同一个被增强类有多个增强方法 用@Order(越小越前) 放在相同切入点的增强类上
    *
    * 全注解开发 在IOC基础上
    * @EnableAspectJAutoProxy(proxyTargetClass = ture)
    * */
    @Test
    public void testAspectAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        //ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Aop aop = context.getBean("aop", Aop.class);
        aop.add();
    }

    @Test
    public void testAspectXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Things things = context.getBean("things", Things.class);
        things.things();
    }
}

class UserDaoHandler implements InvocationHandler{
    //有参构造器将被代理对象作为参数传入
    private Object obj;
    public UserDaoHandler(Object obj){//实际上应该传入被代理对象的实现类
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke方法前的增强部分……\t"+method.getName()+"::"+Arrays.toString(args));
        Object res = method.invoke(obj, args);

        System.out.println("invoke方法后的增强部分……\t"+obj);
        return res;
    }
}

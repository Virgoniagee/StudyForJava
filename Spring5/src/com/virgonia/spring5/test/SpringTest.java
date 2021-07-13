package com.virgonia.spring5.test;

import com.virgonia.spring5.ioc.Orders;
import com.virgonia.spring5.ioc.User;
import com.virgonia.spring5.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test(){
        //获取Spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //反射获取id的对象
        User user = context.getBean("user", User.class);
        //使用对象
        System.out.println(user);
        //使用对象方法
        user.add();
    }

    @Test
    public void testSet(){
        //获取Spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //反射获取id的对象
        Book book = context.getBean("book", Book.class);

        //使用对象
        System.out.println(book);

    }

    @Test
    public void testConstructor(){
        //获取Spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //反射获取id的对象
        Book book = context.getBean("book", Book.class);
        //使用对象
        System.out.println(book);

    }

    /*
    * 当library中有构造器时 使用外部bean注入会找不到library并不能实例化 value改ref
    * 把类中的构造器删除后即可 此时 不像基本数据的构造器一样 在.xml中会报错
    *
    * 内部bean注入就是把引用对象属性先看作是基本属性 用property包起来 在其内在用bean创建一个对象
    *
    * 级联赋值 就是实际实例化的对象中引用了别的对象 需要对被引用的对象赋值 在外部bean注入时 可以在bean创建时就初始化被引入对象的值
    *         或在外部bean时 创建对象中创建被引用对象的get方法 再由property中用 被引用对象id.属性 进行赋值
    *          在引入外部bean 使用get方法之前 先要在实例化对象内把被引用对象的ref创建好 不然找不到
    * */
    @Test
    public void testRef(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Library library = context.getBean("library", Library.class);
        System.out.println(library);
        library.toLibarary();
    }

    /*
    * 集合的赋值
    * 能用array能用list 里面包上value
    * map需要用map 再用entry包
    * ref只能包在list里 而且此时list和array不能混用
    * 使用util名称工具 将需要注入的内容用util:list 取个别名 写入value 再在需要被注入的地方用property的ref引入别名
    * */
    @Test
    public void testArray(){
        ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
        Stu stu = context.getBean("stu", Stu.class);
        Course course1 = context.getBean("course1", Course.class);
        System.out.println(course1);
        System.out.println(stu);
    }

    /*
    * 通过工厂bean来获得对象 主要是用重写的getObject()方法 返回一个需要创建的对象
    * */
    @Test
    public void testFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
        Course course = context.getBean("myfactorybean", Course.class);
        System.out.println(course);
    }

    /*
    * 默认的是单例模式 相同的对象使用getBean创建的就是同一个 加载.xml时就创建对象
    * com.virgonia.spring5.User@481a15ff
    * com.virgonia.spring5.User@481a15ff
    *
    * bean中添加属性scope="prototype"设置为多例模式 调用getBean时才创建对象
    * com.virgonia.spring5.User@78186a70
    * com.virgonia.spring5.User@306279ee
    * */
    @Test
    public void testSingleton(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1);
        System.out.println(user2);

        User user3 = context.getBean("usermul", User.class);
        User user4 = context.getBean("usermul", User.class);
        System.out.println(user3);
        System.out.println(user4);
    }

    /*
    * ApplicationContext中没有context的close方法 需要使用的话 创建context实例时使用其实现类ClassPathXmlApplicationContext
    *
    * 如果需要在初始化前和后执行某些代码 则需要BeanPostProcessor是实现类 里面两个postProcessBeforeInitialization和
    * postProcessAfterInitialization就是实例化前后执行的代码
    * 然后就可以配置到.xml文件中
    * 值得注意的是 用bean创建好这一个对象后 将会在当前的.xml中创建的每一个bean前后都执行 所以 如果需要单独为某一个对象处理初始化前后的工作
    * 则需要单独的一个.xml文件
    * 一个有意思的现象是 并不是.xml文件中总共有多少的bean对象 就执行多少次初始化前后的操作 其执行的顺序还是与.xml中的bean有关
    * */
    @Test
    public void testOrders(){
        System.out.println("bean的创建过程");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("获取getBean实例对象");
        System.out.println(orders);
        context.close();

    }

    @Test
    public void testAutowire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Course course = context.getBean("course", Course.class);
        System.out.println(course);

    }




}

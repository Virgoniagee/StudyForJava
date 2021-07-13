package com.virgonia.spring5.test;

import com.virgonia.spring5.jdbctemp.Book;
import com.virgonia.spring5.jdbctemp.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/10 0:29
 */
public class JDBCTest {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();

      /*  book.setUserId("54");
        book.setUserName("新对象");
        book.setUserStatus("下班");
        bookService.addBook(book);*/

        /*book.setUserId("23");
        book.setUserName("天渊");
        book.setUserStatus("上班");
        bookService.updateBook(book);*/


        /*bookService.deleteBook("23");*/

        /*System.out.println(bookService.selectCount());*/

       /* System.out.println(bookService.findBookInfo("54"));*/


        //System.out.println(bookService.findAllBook().toString());
        List<Object[]> batchArry = new ArrayList<>();
/*        batchArry.add(new Object[]{"44","修改1","操作"});
        batchArry.add(new Object[]{"32","批量34","操作"});
        batchArry.add(new Object[]{"64","批量12","操作"});*/
        //bookService.updateBatch(batchArry);
/*        batchArry.add(new Object[]{"修改1","操作","44"});
        batchArry.add(new Object[]{"批量34","操作","32"});
        batchArry.add(new Object[]{"批量12","操作","64"});*/

        //bookService.updateBatch(batchArry);

        batchArry.add(new Object[]{"44"});
        batchArry.add(new Object[]{"32"});
        batchArry.add(new Object[]{"64"});

        bookService.deleteBatch(batchArry);


    }
}

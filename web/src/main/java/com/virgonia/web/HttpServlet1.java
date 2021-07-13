package com.virgonia.web; /**
 * @Description TODO
 * @Date 2021/7/2 1:01
 * @author by virgonia
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "HttpServlet1", value = "/HttpServlet1")
public class HttpServlet1 extends HttpServlet {
    private ServletConfig config = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("2 init 初始化方法");
// 1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("HelloServlet 程序的别名是:" + config.getServletName());
// 2、获取初始化参数 init-param
        System.out.println("初始化参数 username 的值是;" + config.getInitParameter("hiservlet"));

// 3、获取 ServletContext 对象
        System.out.println(config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
//获取context-param参数

        String username = context.getInitParameter("name");//value
        System.out.println( "当前工程路径:" + context.getContextPath() );
        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
        System.out.println("工程下 css 目录的绝对路径是:" + context.getRealPath("/css"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

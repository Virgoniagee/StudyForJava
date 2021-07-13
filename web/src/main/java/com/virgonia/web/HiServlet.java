package com.virgonia.web;

import sun.net.httpserver.HttpServerImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author by virgonia
 * @Description TODO
 * @Date 2021/7/1 1:11
 */
public class HiServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @method service
     * @description 功能描述:
     *  service专门处理了请求并相应
     *  设置后运行servlet时会运行service代码
     * @date: 2021/7/1 1:15
     * @author: virgonia
    [servletRequest, servletResponse]
     * @return void
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hiServlet运行了！！！在service中");
        //转化为子类
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //用getMethod方法获取action动作
        String method = httpServletRequest.getMethod();
        //处理
        if ("GET".equals(method)){
            System.out.println("对GET表单的处理");
        } else if ("POST".equals(method)){
            System.out.println("对POST表单的处理");
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

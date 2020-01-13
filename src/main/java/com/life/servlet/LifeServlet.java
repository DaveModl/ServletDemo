//package com.life.servlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 注解方式配置
// */
//@WebServlet(name = "MethodServlet",urlPatterns = "/life",loadOnStartup = 1)
//public class LifeServlet extends HttpServlet {
//    /**
//     * 初始化
//     * @throws ServletException
//     */
//    @Override
//    public void init() throws ServletException {
//        System.out.println("service init");
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("life servlet");
//        System.out.println("servlet life");
//    }
//
//    /**
//     * 处理post请求
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    /**
//     * 处理get请求
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    /**
//     * 服务器关闭时调用
//     */
//    @Override
//    public void destroy() {
//        System.out.println("service destroy");
//    }
//
//    /**
//     * 简单的说，http请求被委派给servlet容器，在调用service()前init()加载servlet,可能有多线程产生多个
//     * 请求。每一个单独的线程执行一个service()
//     */
//}

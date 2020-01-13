package com.request.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestServlet",urlPatterns = "/req")
public class RequestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request获取当前请求的所有数据
        //获取请求头
        //请求方式，url,uri,协议
        String method = req.getMethod();
        System.out.println(method);

        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        String uri = req.getRequestURI();
        System.out.println(uri);

        String scheme = req.getScheme();
        System.out.println(scheme);

        //获取请求行，根据指定的键获取值
        String header = req.getHeader("User-Agent");
        System.out.println(header);

        System.out.println();

        //获取所有
        Enumeration<String> names = req.getHeaderNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String reqHeader = req.getHeader(name);
            System.out.println(name + ":" + reqHeader);
        }

//        用户数据
        //TODO 当编码是GBK时中文用户名需要转码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //获取checkbox类型的数据
        String[] checks = req.getParameterValues("check");
        if (checks != null){
            for (String check : checks){
                System.out.println(check);
            }
        }

        System.out.println(username + ":" + password);
    }
}

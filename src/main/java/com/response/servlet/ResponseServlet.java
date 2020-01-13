package com.response.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseServlet",urlPatterns = "/resp")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据到客户端
        //设置响应头
        //覆盖相同键
        resp.setHeader("test","my-header");
        //不会覆盖
        resp.addHeader("test02","my-head02");
        resp.addHeader("test02","my-head03");

        //设置响应状态码
        //resp.sendError(405,"my error...");

        //设置响应体
        //中文需进行编码处理
//        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("张三");
    }
}

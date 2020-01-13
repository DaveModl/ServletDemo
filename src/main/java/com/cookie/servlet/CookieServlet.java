package com.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet",urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /**
         * cookie服务器生成，浏览器存储
         * 不同用户发送同一请求的数据共享(相同数据)
         * 一个Cookie存储一个k-v
         * 默认关闭客户端清除
         * 不设置有效路径的情况下每次都会覆盖
         */
        //创建cookie
        Cookie cookie = new Cookie("test","my-cookie");
        //设置cookie存活时间
        cookie.setMaxAge(60*60*24*7);
        //设置有效路径（只有这个路径才会携带cookie信息数据）
        cookie.setPath("/cookie/get");
        //响应cookie
        resp.addCookie(cookie);


    }
}

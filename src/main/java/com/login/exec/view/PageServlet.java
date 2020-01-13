package com.login.exec.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        //响应结果处理
        /**
         * jsp ---> 原生页面
         */
        //获取request作用域数据
        /**
         * 在同一次请求中，不同Servlet的数据共享问题
         * 基于请求转发，一次请求中的所有servlet共享
         * 由服务器创建，每次请求创建，生命周期一次请求
         */
        String msg = (String) req.getAttribute("msg");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write((msg != null) ? "<font color ='red' size='3px'>"+ msg +"</font>":"");
        resp.getWriter().write("<form action='login' method='post'>");
        resp.getWriter().write("用户名:<input type='text' name='username' value=''/><br/>");
        resp.getWriter().write("密码:<input type='password' name='password' value=''/><br/>");
        resp.getWriter().write("<input type='submit'  value='登录'/><br/>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }

}

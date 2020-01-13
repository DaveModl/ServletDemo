package com.login.exec.view;

import com.login.exec.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");

        //获取session
        User user = (User) req.getSession().getAttribute("user");

        int counts = (int) this.getServletContext().getAttribute("counts");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>欢迎"+ user.getName() +"来到首页</h3>");
        resp.getWriter().write("当前网页访问次数："+ counts);
        resp.getWriter().write("<hr>");
        resp.getWriter().write("<form action='showuser' method='post'>");
        resp.getWriter().write("<input type='submit' value='查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }

}

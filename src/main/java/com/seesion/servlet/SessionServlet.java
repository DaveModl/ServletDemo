package com.seesion.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * session 服务其创建,保存在服务器,保存客户端请求形象
         * JsseionID 以Cookie形式存到客户端
         * 下次访问时通过JseesionID找到对应session
         * 服务器默认存储时间30分钟
         * 如果session失效也会重新创建session对象
         * 作用域：一次会话/在JsessionID和Session不失效的项目内
         */
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //模拟获取请求信息
        String name = "Dave";
        //创建Seesion对象
        HttpSession session = req.getSession();
        //设置session有效时间
//        session.setMaxInactiveInterval(5);
        //强制失效
//        session.invalidate();
        //存储session
        session.setAttribute("my-session",name);


        System.out.println(session.getId());

        resp.getWriter().write("get session..");
    }
}

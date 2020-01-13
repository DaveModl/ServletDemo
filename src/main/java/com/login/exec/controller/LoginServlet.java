package com.login.exec.controller;

import com.login.exec.model.User;
import com.login.exec.service.LoginService;
import com.login.exec.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");
        //获取请求数据
        String username = request.getParameter("username");
        //处理中文乱码
        username = new String(username.getBytes("iso8859-1"),"utf-8");
        //post
//        request.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        System.out.println(username + " : " + password);
        //处理请求信息
        //获取业务层数据
        LoginService loginService = new LoginServiceImpl();
        User user = loginService.selectUser(username,password);
//        System.out.println(user.toString());
        //简易的判断逻辑
        if (user != null){
//            response.getWriter().write("登录成功");
            /**
             * 请求转发容易重复提交
             * 重定向
             * 两次请求，地址栏会发生变化
             * 默认不会保留上一次数据
             */
            //存储用户cookie
            Cookie cookie = new Cookie("user-id",user.getId()+"");
            cookie.setMaxAge(3*24*3600);
            cookie.setPath("cookiecheck");
            response.addCookie(cookie);
            /**
             * session,同一用户的不同请求，数据共享
             * 重定向，两次请求
             */
            //存储用户数据到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            /**
             * 当前登录人数
             */
            ServletContext context = this.getServletContext();
            if (context.getAttribute("counts") != null) {
                int counts =Integer.parseInt ((String) context.getAttribute("counts"));
                counts++;
                context.setAttribute("counts", counts);
            }else {
                //首次登录
                context.setAttribute("counts",1);
            }
            response.sendRedirect("main");
            return;
        }else {
//            response.getWriter().write("登陆失败");
            //请求转发
            /**
             * 同一次请求，地址栏不变，保留第一次请求的数据
             * request携带数据
             */
            request.setAttribute("msg","用户信息错误");
            request.getRequestDispatcher("page").forward(request,response);
            return;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

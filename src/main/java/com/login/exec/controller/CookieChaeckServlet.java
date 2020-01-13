package com.login.exec.controller;

import com.login.exec.model.User;
import com.login.exec.service.LoginService;
import com.login.exec.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CookieChaeckServlet",urlPatterns = "/cookiecheck")
public class CookieChaeckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        cookie检验
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            String userId = "";
            for (Cookie cookie : cookies) {
                if ("user-id".equals(cookie.getName())){
                    userId = cookie.getValue();
                }
            }
              if ("".equals(userId)){
                request.getRequestDispatcher("page").forward(request,response);
                return;
              }else {
                LoginService loginService = new LoginServiceImpl();
                User user= loginService.checkUserById(Integer.parseInt(userId));
                System.out.println(user.toString());
                if (user != null){
                    //将用户数据存储到session
                     request.getSession().setAttribute("user",user);
                    /**
                     * 计数器自增
                     */
                    int counts = (int) this.getServletContext().getAttribute("counts");
                    counts++;
                    this.getServletContext().setAttribute("counts",counts);
                    response.sendRedirect("main");
                    return;
                }
            }
        }else {
            request.getRequestDispatcher("page").forward(request,response);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

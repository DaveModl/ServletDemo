package com.filter.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ActionFilter",urlPatterns = "/*")
public class ActionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //统一编码配置
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //session管理
//        HttpSession session = ((HttpServletRequest) req).getSession();
//        if (session.getAttribute("user") == null){
//            ((HttpServletResponse) resp).sendRedirect("xxx");
//        }else {
//        chain.doFilter(req, resp);
//        }
        chain.doFilter(req,resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

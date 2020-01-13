package com.config.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfigServlet",urlPatterns = "/config",initParams ={
        @WebInitParam(name = "config",value = "utf-8")})
public class ConfigServlet extends HttpServlet {
    /**
     * 获取Servlet的专属属性
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        String value = config.getInitParameter("config");
        System.out.println(value);
    }
}

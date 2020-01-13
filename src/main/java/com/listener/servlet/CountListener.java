package com.listener.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 统计在线人数
 */
@WebListener()
public class CountListener implements ServletContextListener,
        HttpSessionListener {

    // Public constructor is required by servlet spec
    public CountListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      //初始化人数
        ServletContext context = sce.getServletContext();
        context.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        //自增人数
        ServletContext context = se.getSession().getServletContext();
        int count = (int) context.getAttribute("count");
        context.setAttribute("count",++count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        //减少人数
        ServletContext context = se.getSession().getServletContext();
        int count = (int) context.getAttribute("count");
        context.setAttribute("count",--count);
    }




}

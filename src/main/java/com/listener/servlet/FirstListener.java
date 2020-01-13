package com.listener.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听作用域对象
 * 监听request对象,request作用域数据,session,session数据变更,application与数据的变更
 * 和监听对象生命周期一致
 */
@WebListener()
public class FirstListener implements ServletRequestListener, ServletRequestAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener, ServletContextListener
,ServletContextAttributeListener{

    public FirstListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("监听器销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听器创建");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("add data");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session create");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroy");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("add session");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application destroy");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("servletContext add");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }
}

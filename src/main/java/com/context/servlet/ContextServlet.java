package com.context.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ContextServlet",urlPatterns = "/context")
public class ContextServlet extends HttpServlet {
/**
 * 不同用户之间共享相同数据,服务器创建.和服务器生命周期一致
 * 不同用户可以给ServletContext对象进行数据存取
 */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = this.getServletContext();

//        ServletContext context2 = this.getServletConfig().getServletContext();
//
//        ServletContext context3 = req.getSession().getServletContext();

        //数据存储---数据共享
        context.setAttribute("str","my-context");
        //获取web.xml的全局配置,将静态数据和代码解耦
        //根据key --- 返回value
        String initParameter = context.getInitParameter("name");
        System.out.println(initParameter);

        //获取webapp(项目根目录)下资源的绝对路径
        String path = context.getRealPath("/doc/1.txt");
        System.out.println(path);
        //获取webapp(项目根目录)下资源的流对象
        //class文件的对象的获取需要类加载器
        InputStream in = context.getResourceAsStream("/doc/1.txt");

    }
}

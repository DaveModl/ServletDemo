package com.filter.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 统一处理，过滤数据,资源管理,保护servlet
 * 生命周期，服务器启动到服务器关闭
 * 服务器执行调用
 */
@WebFilter(filterName = "FirstFilter")
public class FirstFilter implements Filter {
    /**
     * 服务器关闭时销毁
     */
    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do filter");
        //放行，责任链
        chain.doFilter(req, resp);
        System.out.println("After do filter");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter init");
    }

}

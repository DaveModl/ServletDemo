package com.listener.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TestServlet2",urlPatterns = "/test2")
public class TestServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test2","content");
        HttpSession session = req.getSession();
        session.setAttribute("sessiontest","content");
        session.invalidate();

        ServletContext context = this.getServletContext();
        context.setAttribute("application","test");
    }
}

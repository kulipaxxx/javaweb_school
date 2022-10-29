package com.cheng.onlineUser;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class OnlineUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getSession().getServletContext();//调用此方法创建Session
        resp.setContentType("text/html;charset=utf-8");

        Integer user = (Integer) context.getAttribute("user");
        resp.getWriter().println("<h1>在线人数：" + user + "</h1>");
        resp.getWriter().println("</br><a href=\"/logout\">登录注销");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

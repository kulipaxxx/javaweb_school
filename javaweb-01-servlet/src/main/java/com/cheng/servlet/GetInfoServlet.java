package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class GetInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        req.setAttribute("name", name);
        req.setAttribute("pwd", pwd);
        System.out.println(name + "====" + pwd);
        if ("admin".equals(name) && "123456".equals(pwd)) {
            //转发
//            req.getRequestDispatcher("/loginS").forward(req,resp);
            //请求包含
//            req.getRequestDispatcher("/loginS").include(req,resp);
            //重定向
            resp.sendRedirect("/loginS?name=" + URLEncoder.encode(name, "UTF-8") + "&pwd=" + pwd);
//            req.getRequestDispatcher("/loginS?name=" +URLEncoder.encode(name+"橙子","UTF-8") + "&pwd=" + pwd).forward(req,resp);
        } else {
            //转发
//            req.getRequestDispatcher("/loginF").forward(req,resp);
            //重定向
            resp.sendRedirect("/loginF");
        }
        System.out.println("回来了");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

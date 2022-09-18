package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        req.setAttribute("name",name);
        req.setAttribute("pwd",pwd);
        System.out.println(name + "====" + pwd);
        if ("admin".equals(name) && "123456".equals(pwd)){
            req.getRequestDispatcher("/loginS").forward(req,resp);
            req.getRequestDispatcher("/loginS").include(req,resp);
        }else {
            req.getRequestDispatcher("/loginF").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

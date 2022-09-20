package com.cheng.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Referer extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
getServletConfig();
        //设置浏览器禁止缓存
        resp.setHeader("Cache-control", "no-cache");
        resp.setHeader("pragma", "no-cache");
        resp.setDateHeader("expires", -1);


        //获取referer表示请求来源
        String referer = req.getHeader("referer");

        PrintWriter writer = resp.getWriter();
        if (referer == null || !referer.contains("http://localhost:8080/index.jsp")){
            writer.println("非法倒链，已返回原页面访问");

            resp.sendRedirect("index.jsp");
        }
        else {
            writer.println("正常访问");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");
        //防止未登录访问页面
       if (user == null){
           writer.println("非法访问");

           writer.println("<a href=\"/showL\">返回原登录页面</a>");
        }
        else {//正常访问
           writer.println("商品页面");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}

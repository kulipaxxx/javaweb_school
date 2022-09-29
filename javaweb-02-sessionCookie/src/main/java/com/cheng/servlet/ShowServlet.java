package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");//获取user

        PrintWriter writer = resp.getWriter();

        if (user == null){
            //打印登录页面
            writer.println("<form action=\"/loginV\" method=\"post\">\n" +
                    "    <p>userName:<input type=\"text\" name=\"userName\" required=\"required\"></p>\n" +
                    "    <p>30秒免登录：<input type=\"radio\" name=\"pass\"></p>\n" +
                    "    <p><input type=\"submit\" value=\"提交\"></p>\n" +
                    "</form>");
        }else {//免登录
            req.getRequestDispatcher("/loginV").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

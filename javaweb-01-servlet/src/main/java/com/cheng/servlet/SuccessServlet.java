package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 成功servlet
 *
 * @author Administrator
 * @date 2022/09/18
 */
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("登录成功<br/>");
        //转发获取信息
        writer.println("用户名：" + req.getAttribute("name") + "<br/>");
        writer.println("密码：" + req.getAttribute("pwd") + "<br/>");

        //重定向获取信息
        writer.println("用户名：" + req.getParameter("name") + "<br/>");
        writer.println("密码：" + req.getParameter("pwd") + "<br/>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

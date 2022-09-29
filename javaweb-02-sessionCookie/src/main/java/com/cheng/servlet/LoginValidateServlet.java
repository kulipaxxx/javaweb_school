package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("userName");
        String pass = req.getParameter("pass");//null未选中，on选中
        HttpSession session = req.getSession();//获取session

        if (pass == null && user != null){//如果未选中或者免登陆
            session.setAttribute("user",user);//存入session
            session.setMaxInactiveInterval(1);//设置过期时间1s
            resp.sendRedirect("/shopping.html");
        }else {
            if (user != null){//如果不为空
                session.setAttribute("user",user);//存入session
                session.setMaxInactiveInterval(30);//设置过期时间30s
            }else {//如果为空，存入上次的session
                session.setAttribute("user",session.getAttribute("user"));
            }

            resp.sendRedirect("/shopping.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        String result="";
        if(name!=null && age!=null){
            result = "<font color='red' size='18'>姓名为：" + name +"<br>"+
                    "年龄为：" + age + "</font>";
        }else{
            String kp = "";
            for (String hobby : hobbies) {
                    kp += hobby + " ";
            }
            result = "<font color='red' size='18'>用户名为：" + username +
                    "<br>"+"密码为：" + password + "<br>"+
                    "爱好有：" + kp + "</font>";
        }

        resp.getOutputStream().write(result.getBytes());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

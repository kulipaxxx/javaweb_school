package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//解决页面乱码
        req.setCharacterEncoding("UTF-8");
        //获取get方式传参
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        //获取前端传参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(name +"  " + age);

        String[] hobbies = req.getParameterValues("hobby");
        Map<String, String[]> map = req.getParameterMap();
        String result="";
//        System.out.println("啦啦啦啦啦");
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

package com.cheng.servlet;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

public class servletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//解决页面乱码
        ServletContext context = this.getServletContext();
        //获取参数
        String names = context.getInitParameter("hobby");
        System.out.println(names);

        //获取全局属性值
        Integer count = (Integer) context.getAttribute("count");
        if (count == null) {
            context.setAttribute("count", 1);
        } else {
            context.setAttribute("count", ++count);
        }
        count = (Integer) context.getAttribute("count");
        String result = "<font color='red' size='18'>当前站点被点击了"
                + count + "次</font><br></br>";
        resp.getOutputStream().write(result.getBytes());

        //读取配置文件
        InputStream is = context.getResourceAsStream("data.properties");
        Properties properties = new Properties();
        properties.load(is);
        String s = properties.getProperty("user");
        System.out.println(s);
        resp.getOutputStream().write(s.getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package com.cheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String lastAccessTime = null;
        //获取cookies
        Cookie[] cookies = req.getCookies();
        if (cookies!=null) {
            //遍历cookies
            for (Cookie cookie : cookies) {
                if ("lastAccess".equals(cookie.getName())){

                    //获取值
                    lastAccessTime = cookie.getValue();
                    break;
                }
            }
        }
        if (lastAccessTime == null){
            resp.getWriter().println("首次访问");
        }else{
            resp.getWriter().println("您上次访问的时间是：" + lastAccessTime);
        }
        //创建cookie，将当前时间作为cookie的值传给客服端
        String format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());

        Cookie cookie = new Cookie("lastAccess", format);

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

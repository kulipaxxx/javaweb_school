package com.cheng.servlet;

import com.cheng.utils.BaseCookie;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");//乱码
        Cookie[] cookies = req.getCookies();//获取cookies

        PrintWriter writer = resp.getWriter();//获取out
        String loginTime= null;
        if (cookies != null){//如果不为空，遍历
            for (Cookie cookie : cookies) {
                if ("lastaccTime".equals(cookie.getName())){//获取上次登录时间
                    loginTime = cookie.getValue();
                    break;
                }
            }
        }
        if (loginTime != null){
            writer.println("欢迎回来，你上次登录时间为：" + loginTime);
        }else {//第一次登录
            writer.println("欢迎，你是首次访问本站");
        }
        //获取这次访问时间
        String s = new SimpleDateFormat("yyyy-MM--dd:hh:mm:ss").format(new Date());
        Cookie cookie = new Cookie("lastaccTime",s);
        //加入cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

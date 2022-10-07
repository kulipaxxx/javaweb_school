package com.cheng.onlineUser;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {
    private ServletContext context;
    public void setAttribute(Integer count,boolean flag){
        if (count != null){
            if (flag)//加
                context.setAttribute("user", ++count);
            else//减
                context.setAttribute("user", --count);
        }else {
            context.setAttribute("user", 1);
        }
    }

    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        context = session.getServletContext();
        System.out.println("创建Session");
        Integer count = (Integer)context.getAttribute("user");
        System.out.println("变前" + count);
        setAttribute(count,true);
        count = (Integer)context.getAttribute("user");
        System.out.println("变后" + count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        context = se.getSession().getServletContext();
        System.out.println("session关闭");
        Integer count = (Integer)context.getAttribute("user");
        setAttribute(count,false);
    }
}

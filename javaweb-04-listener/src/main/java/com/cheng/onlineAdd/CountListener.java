package com.cheng.onlineAdd;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class CountListener implements HttpSessionListener, ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        AtomicInteger integer = new AtomicInteger();
        sce.getServletContext().setAttribute("user",integer);
        System.out.println("context:" + integer);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {
        AtomicInteger user = getAtomicInteger(se);
        user.incrementAndGet();
        System.out.println("context:" + user);
        ServletContext context = se.getSession().getServletContext();
        AtomicInteger user1 = (AtomicInteger) context.getAttribute("user");
        System.out.println("contextaaaa:" + user1);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger user = getAtomicInteger(se);
        user.decrementAndGet();
        System.out.println(user);
        ServletContext context = se.getSession().getServletContext();
        AtomicInteger user1 = (AtomicInteger) context.getAttribute("user");
        System.out.println(user1);
    }

    private AtomicInteger getAtomicInteger(HttpSessionEvent se){
        ServletContext context = se.getSession().getServletContext();
        AtomicInteger user = (AtomicInteger) context.getAttribute("user");
        return user;
    }

}

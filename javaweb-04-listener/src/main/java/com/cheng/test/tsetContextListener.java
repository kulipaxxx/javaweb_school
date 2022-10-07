package com.cheng.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//web应用启动时Servlet容器创建，关闭时销毁
public class tsetContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context创建了");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context销毁了");
    }
}

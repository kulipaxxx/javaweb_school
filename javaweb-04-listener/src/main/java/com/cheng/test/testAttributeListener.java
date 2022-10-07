package com.cheng.test;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class testAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println(event.getName() + "值为：" + event.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("移除" + event.getName());
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("更改" + event.getName());
    }
}

package com.cheng.test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class testRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request创建了");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request销毁了");
    }
}

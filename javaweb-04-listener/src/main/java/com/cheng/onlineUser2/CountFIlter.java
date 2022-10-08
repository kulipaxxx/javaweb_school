package com.cheng.onlineUser2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class CountFIlter implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        CountList.sessionId.add(se.getSession().getId());
        System.out.println("sessionId:" + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        CountList.sessionId.remove(se.getSession().getId());
    }
}

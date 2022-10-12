package com.cheng.Session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

//@WebListener
public class User implements Serializable, HttpSessionActivationListener {
    private String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("钝化成功");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("活化成功");
        System.out.println(se.getSession().getAttribute("userInfo"));
    }
}

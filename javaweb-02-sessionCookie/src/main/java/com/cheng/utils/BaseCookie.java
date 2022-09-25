package com.cheng.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 1）创建Cookie，发送给客户端：void createCookie(String cookieName,String cookieValue,int maxAge),即cookie的名字、值和存活时间；
2）获取Cookie的值：String getValue(String cookieName),得到所有Cookie并遍历，根据参数cookieName返回它的值；
3）删除Cookie：void deleteCookie(String cookieName),可通过设置maxAge=0来删除Cookie。
* */
public class BaseCookie {
    private HttpServletResponse response;
    private HttpServletRequest request;

    public BaseCookie(){}

    public BaseCookie(HttpServletRequest req,HttpServletResponse resp){
        this.request = req;
        this.response = resp;
    }

    //创建cookie
    public void createCookie(String cookieName,String cookieValue,int maxAge){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(maxAge);

        response.addCookie(cookie);
    }

    //获取cookie值
    public String getValue(String cookieName){
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }
        return cookieValue;
    }

    //删除cookie,可通过设置maxAge=0来删除Cookie。
    public void deleteCookie(String cookieName){
        Cookie[] cookies = request.getCookies();

        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())){
                    cookie.setMaxAge(0);//删除cookie
                    break;
                }
            }
        }
    }
}

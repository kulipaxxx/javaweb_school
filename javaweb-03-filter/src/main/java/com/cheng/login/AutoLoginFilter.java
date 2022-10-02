package com.cheng.login;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        String result = "root-123456";
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userInfo")){
                    if (cookie.getValue().equals(result)){
                        session.setAttribute("user", new User("root","123456"));
                        req.getRequestDispatcher("/login/success").forward(req,resp);
                    }
                }
            }
        }

        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}

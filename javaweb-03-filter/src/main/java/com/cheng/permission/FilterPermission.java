package com.cheng.permission;

import com.cheng.login.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterPermission implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String user = req.getParameter("user");
        boolean flag = true;
        if (user != null) {
            if (user.equals("cqut")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", new User(user, req.getParameter("pwd")));
            } else {
//                req.getRequestDispatcher("/permission/unauthorized.html").forward(req,resp);
                resp.sendRedirect("/permission/unauthorized.html");
                flag = false;
            }
        }
        if (flag)
            chain.doFilter(request, response);
    }

    public void destroy() {

    }
}

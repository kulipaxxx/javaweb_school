package com.cheng;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterEncoding implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("过滤器执行了");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}

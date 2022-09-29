package com.cheng.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class codingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器---------start---------------");

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        System.out.println(uri);
        System.out.println("过滤器---------end---------------");

        filterChain.doFilter(request,response);
    }


    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}

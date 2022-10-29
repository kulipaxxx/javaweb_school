package com.cheng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class staticFilter implements Filter {
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取存活时间
        String liveTimeP = filterConfig.getInitParameter("liveTimeP");
        String liveTimeJC = filterConfig.getInitParameter("liveTimeJC");
        //获取uri
        String uri = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(liveTimeP + " " + liveTimeJC + " " + uri + " " + requestURL);
        if (uri.endsWith(".jpg") || uri.endsWith(".png"))
            resp.setDateHeader("expires", (System.currentTimeMillis() + 60 * 60 * 1000 * Long.valueOf(liveTimeP)));//缓存
        else if (uri.endsWith(".css") || uri.endsWith(".js"))
            resp.setDateHeader("expires", (System.currentTimeMillis() + 60 * 60 * 1000 * Long.valueOf(liveTimeJC)));//缓存
        //放行
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}

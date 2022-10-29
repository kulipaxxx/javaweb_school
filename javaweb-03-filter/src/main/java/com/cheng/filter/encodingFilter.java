package com.cheng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class encodingFilter implements Filter {
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //获取参数
        String encoding = filterConfig.getInitParameter("enReq");
        String content = filterConfig.getInitParameter("enResp");
        //配置编码
        req.setCharacterEncoding(encoding);
        resp.setContentType(content);

        if (encoding.equals("UTF-8")) {
            chain.doFilter(request, response);
        } else {
            resp.getWriter().println("encoding is not utf-8");
        }
    }

    public void destroy() {

    }
}

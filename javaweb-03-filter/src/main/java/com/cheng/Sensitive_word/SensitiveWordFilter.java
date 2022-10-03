package com.cheng.Sensitive_word;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SensitiveWordFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;

        chain.doFilter(new NewRequest(req),response);
    }

    public void destroy() {

    }
}


class NewRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private String[] sensitves = {"狗屁","傻逼","傻帽","你妹"};

    @Override
    public String getParameter(String name) {
        if (name.equals("text")){
            String info = request.getParameter("text");
            for (int i = 0; i < sensitves.length; i++) {
                if (info.contains(sensitves[i])){
                    String words = sensitves[i];
                    info = info.replace(words, "**");
                }
            }
            return info;
        }
        return super.getParameter(name);
    }

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public NewRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }
}

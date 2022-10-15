package com.cheng;

import com.cheng.thyUtil.ViewBaseServlet;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class test extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name","cqut");
        req.setAttribute("cn","重理工");
        req.setAttribute("com","<a href=\"https://www.baidu.com/\">点击跳转</a>");
        WebContext context = new WebContext(req, resp, this.getServletContext(), req.getLocale());
        templateEngine.pr

        req.setAttribute("description","网状描述");
        req.setAttribute("keyword","关键词");


        super.processTemplate("hello",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

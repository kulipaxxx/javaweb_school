package com.cheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class testContextAttritubute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        PrintWriter writer = resp.getWriter();
        Integer count = 1;
        Integer t1 = (Integer)context.getAttribute("count");
        if (t1 != null){
            count = t1;
            writer.println("<h1>"+ count +"</h1>");
            context.setAttribute("count", ++count);
        }else {
            context.setAttribute("count", count);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

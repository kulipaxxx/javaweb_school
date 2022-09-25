package com.cheng.shopping.servlet;

import com.cheng.shopping.pojo.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CartServlet extends HttpServlet {
    String[] selctItmes;//选取的物品
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");
        //获取session
        HttpSession session = req.getSession(true);
        Cart cart = (Cart) session.getAttribute("cart");

        PrintWriter writer = resp.getWriter();
        //获取前端数据
        String[] items = req.getParameterValues("items");

        //如果为空
        if (cart == null){
            Cart cart1 = new Cart();
            session.setAttribute("cart",cart1);
            cart = (Cart)session.getAttribute("cart");
        }
        if (items == null){
            writer.println("error,你没有加入商品");
            writer.println("<a href=\"/shopping.html\">点击返回页面</a>");
        }else {
            for (String item : items) {
                cart.add(item);
            }
        }
        session.setAttribute("cart",cart);
        writer.println("<h1>您的购物车有"+ cart.getNumbers() + "样商品</h1>");
        Map books = cart.getBooks();

        for (Object o : books.keySet()) {
            writer.println(o + "的数量有：" + books.get(o) + "</br>");
        }

        writer.println("<a href=\"/shopping.html\">继续购物</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

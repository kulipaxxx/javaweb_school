package com.cheng.login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AutoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        System.out.println(userName + pwd);
        HttpSession session = req.getSession();
        String[] times = req.getParameterValues("time");
        String kp = null;
        if (times != null) {
            for (String time : times) {
                kp = time;
            }
        }
        if (userName != null && pwd != null) {
            if (userName.equals("root") && pwd.equals("123456")) {
                User user = new User(userName, pwd);
                String result = userName + "-" + pwd;
                Cookie info = new Cookie("userInfo", result);
                if (kp != null) {
                    switch (Integer.valueOf(kp)) {
                        case 1:
                            info.setMaxAge(60);
                            break;
                        case 2:
                            info.setMaxAge(60 * 2);
                            break;
                        case 3:
                            info.setMaxAge(60 * 3);
                            break;
                        default:
                            break;
                    }
                }
                session.setAttribute("user", user);
                resp.addCookie(info);
                resp.sendRedirect("/login/success");
            } else
                resp.sendRedirect("/login/unSuccess");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

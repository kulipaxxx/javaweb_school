import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//验证
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String code = req.getParameter("code");
        StringBuilder code1 = (StringBuilder) session.getAttribute("code");
        String s = code1.toString();
        System.out.println(code + "  " + session.getAttribute("code"));
        if (code.equals(s)){
            resp.sendRedirect("/main.html");
            System.out.println("1111");
        }else
            resp.sendRedirect("/form.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

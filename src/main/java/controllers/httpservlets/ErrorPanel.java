package controllers.httpservlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error_panel")
public class ErrorPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("backButton") != null) {
            resp.sendRedirect("/registration_panel");
        }
        if (req.getParameter("signButton") != null) {
            resp.sendRedirect("/sign_in_panel");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(
                "<html>\n" +
                "<head>\n" +
                "    <title>Register Error</title>\n" +
                "</head>\n" +
                "<body align=\"center\">\n" +
                "    " + req.getAttribute("message") + "<br>\n" +
                "<form method=\"get\" action=\"error_panel\">\n" +
                "    Please, use <label> <input type=\"submit\" value=\"Back\" name=\"backButton\"/> </label> to back on registration <br>\n" +
                "    Or <label> <input type=\"submit\" value=\"Sign in\" name=\"signButton\"/> </label> to login in your account\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}

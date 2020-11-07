package controllers.httpservlets;

import models.utils.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration_panel")
public class RegistrationPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/unauthorized/registration_panel.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (req.getParameter("registerButton") != null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            Registration reg = new Registration();
            int code = reg.userRegistration(login, password);

            req.setAttribute("message", reg.getMessageByCode(code));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error_panel");
            dispatcher.forward(req, resp);
        }

        if (req.getParameter("signInButton") != null) {
            resp.sendRedirect("/sign_in_panel");
        }

    }

}
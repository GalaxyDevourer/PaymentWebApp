package controllers.httpservlets;

import models.utils.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sign_in_panel")
public class SignInPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/unauthorized/sign_in_panel.html");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logInButton") != null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            if (!login.equals("") && !password.equals("")) {
                Registration reg = new Registration();
                String role = reg.userSignIn(login, password);

                if (!role.equals("")) {
                    HttpSession session = req.getSession();
                    session.setMaxInactiveInterval(1200);

                    Cookie cookieRole = new Cookie("role", role);
                    cookieRole.setMaxAge(3600);
                    Cookie loginRole = new Cookie("login", login);
                    loginRole.setMaxAge(3600);

                    session.setAttribute("role", cookieRole);
                    session.setAttribute("login", loginRole);

                    req.setAttribute("message", "Successful login, press the button to go to the control panel!");
                    req.getRequestDispatcher("/panels/success_panel.xhtml").forward(req, resp);
                }
                else {
                    req.setAttribute("message", "Login denied, please enter correct data!");
                    req.getRequestDispatcher("/panels/denied_panel.xhtml").forward(req, resp);
                }
            }
            else {
                req.setAttribute("message", "Login denied, login and password must not be empty!");
                req.getRequestDispatcher("/panels/denied_panel.xhtml").forward(req, resp);
            }

        }
        //else {
        //    RequestDispatcher dispatcher = req.getRequestDispatcher("/unauthorized/registration_panel.html");
        //    dispatcher.forward(req, resp);
        //}
    }
}
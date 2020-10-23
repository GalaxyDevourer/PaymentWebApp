package controllers.httpservlets;

import entities.UserEntity;
import models.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            Registration reg = new Registration();
            UserEntity user = reg.userSignIn(login, password);

            if (user != null) {

            }
            //else
        }
        //else {
        //    RequestDispatcher dispatcher = req.getRequestDispatcher("/unauthorized/registration_panel.html");
        //    dispatcher.forward(req, resp);
        //}
    }
}
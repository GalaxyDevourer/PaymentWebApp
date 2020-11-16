package models.cdi;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    @Inject
    Customer customer;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("customer doPost");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("customer doGet");
        customer.shopping();
    }
}

package models.beans.events;

import models.utils.CookieHelper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named("logOutBean")
@RequestScoped
public class LogOutBean {
    public void logOut() {
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();

        HttpSession session = (HttpSession) ex.getSession(true);
        session.removeAttribute("role");
        session.removeAttribute("login");

        HttpServletResponse resp = (HttpServletResponse) ex.getResponse();
        HttpServletRequest req = (HttpServletRequest) ex.getRequest();

        new CookieHelper().eraseCookie(req, resp);

        try {
            ex.redirect("/sign_in_panel");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

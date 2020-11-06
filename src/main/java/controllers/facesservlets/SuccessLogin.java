package controllers.facesservlets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named("successLogin")
@SessionScoped
public class SuccessLogin implements Serializable {

    private String message;
    private HttpSession session;

    @PostConstruct
    public void init () {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        message = (String) request.getAttribute("message");

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        session = (HttpSession) ec.getSession(true);
    }

    public void goToPanels () throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        Cookie cookieRole = (Cookie) session.getAttribute("role");
        Cookie loginRole = (Cookie) session.getAttribute("login");

        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        response.addCookie(cookieRole);
        response.addCookie(loginRole);

        if (cookieRole.getValue().equals("User")) {
            ec.redirect("/panels/user_panel.xhtml");
        }
        else ec.redirect( "/panels/admin_panel.xhtml");

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

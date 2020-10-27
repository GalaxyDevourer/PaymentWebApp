package controllers.facesservlets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named("successLogin")
@SessionScoped
public class SuccessLogin implements Serializable {

    private String message;

    private ExternalContext externalContext;
    private HttpSession session;

    public SuccessLogin () {
        externalContext = FacesContext.getCurrentInstance().getExternalContext();
        session = (HttpSession) externalContext.getSession(true);
    }

    @PostConstruct
    public void init () {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        message = (String) request.getAttribute("message");
    }

    public void goToPanels () throws IOException {
        if (session.getAttribute("role").equals("User")) {
            externalContext.redirect(externalContext.getRequestContextPath() + "/panels/user_panel.xhtml");
        }
        else externalContext.redirect(externalContext.getRequestContextPath() +"/panels/admin_panel.xhtml");

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

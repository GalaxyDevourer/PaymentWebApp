package controllers.facesservlets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;

@Named("deniedLogin")
@RequestScoped
public class DeniedLoginPanel implements Serializable {

    private String errorMessage;

    @PostConstruct
    public void init () {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        errorMessage = (String) request.getAttribute("message");
    }

    public void backToSignIn () throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/sign_in_panel");
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
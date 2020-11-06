package controllers.facesservlets;

import models.CookieHelper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Optional;

@Named("adminPanel")
@SessionScoped
public class AdminPanel implements Serializable {
    private String login;
    private String role;

    @PostConstruct
    public void init () {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();

        Optional<String> cookieRole = CookieHelper.readCookie("role", request);
        Optional<String> cookieLogin = CookieHelper.readCookie("login", request);

        if (cookieLogin.isPresent() && cookieRole.isPresent()) {
            login = cookieLogin.get();
            role = cookieRole.get();
        }
        else {
            login = "Undefined";
            role = "User";
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

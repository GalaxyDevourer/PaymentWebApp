package models.utils;

import javax.faces.context.FacesContext;
import java.io.IOException;

public interface Refresh {
    default void refresh () {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/panels/admin_panel.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

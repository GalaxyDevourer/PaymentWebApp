package models.beans.crud.admin;

import dao.impementation.ServiceDAO;
import models.utils.Refresh;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("deleteServiceBean")
@SessionScoped
public class DeleteServiceBean implements Serializable, Refresh {
    private Integer id;

    public void delete() {
        new ServiceDAO().delete(id);

        refresh();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

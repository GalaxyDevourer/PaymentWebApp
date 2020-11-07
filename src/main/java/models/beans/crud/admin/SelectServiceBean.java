package models.beans.crud.admin;

import dao.impementation.ServiceDAO;
import entities.ServiceEntity;
import models.utils.Refresh;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("selectServiceBean")
@SessionScoped
public class SelectServiceBean implements Serializable, Refresh {
    public List<ServiceEntity> getServiceTable () {
        return new ServiceDAO().getAll();
    }

}

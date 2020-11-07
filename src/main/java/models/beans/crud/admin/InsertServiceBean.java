package models.beans.crud.admin;

import dao.impementation.ServiceDAO;
import entities.ServiceEntity;
import models.utils.Refresh;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("insertServiceBean")
@SessionScoped
public class InsertServiceBean implements Serializable, Refresh {
    private String servicename;
    private String amount;
    private String worth;

    public void insert() {
        ServiceEntity entity = new ServiceEntity(servicename, amount, worth);
        new ServiceDAO().insert(entity);

        refresh();
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }
}

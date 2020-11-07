package models.beans.crud.user;

import dao.impementation.MergedPaymentEntityDAO;
import entities.MergedPaymentEntity;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named("selectMergedTableBean")
@SessionScoped
public class SelectMergedTableBean implements Serializable {

    private Integer clientID;
    private String city;
    private String serviceName;

    public List<MergedPaymentEntity> getCustomMergedTable () {
        return new MergedPaymentEntityDAO().getCustomData(clientID, city, serviceName);
    }

    public void refreshTable () {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/panels/user_panel.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID_) {
        this.clientID = clientID_;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city_) {
        if (city_.equals("")) this.city = null;
        else this.city = city_;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName_) {
        if (serviceName_.equals("")) this.serviceName = null;
        else this.serviceName = serviceName_;
    }
}

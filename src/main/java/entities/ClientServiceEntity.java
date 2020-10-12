package entities;

import java.util.Date;

public class ClientServiceEntity {
    private int idclient;
    private int idservice;
    private float monthlyamount;
    private Date date;

    public ClientServiceEntity () {}

    public ClientServiceEntity(int idclient, int idservice, float monthlyamount, Date date) {
        this.idclient = idclient;
        this.idservice = idservice;
        this.monthlyamount = monthlyamount;
        this.date = date;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public float getMonthlyamount() {
        return monthlyamount;
    }

    public void setMonthlyamount(float monthlyamount) {
        this.monthlyamount = monthlyamount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

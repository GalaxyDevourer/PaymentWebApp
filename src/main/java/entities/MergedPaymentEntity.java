package entities;

import java.sql.Date;

public class MergedPaymentEntity {
    private String name;
    private String surname;
    private String city;
    private String servicename;
    private float monthamount;
    private Date date;
    private float payment;

    MergedPaymentEntity () {}

    public MergedPaymentEntity(String name, String surname, String city, String servicename, float monthamount, Date date, float payment) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.servicename = servicename;
        this.monthamount = monthamount;
        this.date = date;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public float getMonthamount() {
        return monthamount;
    }

    public void setMonthamount(float monthamount) {
        this.monthamount = monthamount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }
}
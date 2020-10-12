package entities;

public class PaymentEntity {
    private int idclientservice;
    private float payment;

    public PaymentEntity () {}

    public PaymentEntity(int idclientservice, float payment) {
        this.idclientservice = idclientservice;
        this.payment = payment;
    }

    public int getIdclientservice() {
        return idclientservice;
    }

    public void setIdclientservice(int idclientservice) {
        this.idclientservice = idclientservice;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }
}

package entities;

public class ServiceEntity {
    private int id;
    private String servicename;
    private String amount;
    private String worth;

    public ServiceEntity(String servicename, String amount, String worth) {
        this.servicename = servicename;
        this.amount = amount;
        this.worth = worth;
    }

    public ServiceEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

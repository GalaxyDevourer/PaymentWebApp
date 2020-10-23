package entities;

public class ClientEntity {
    private int id;
    private String name;
    private String surname;
    private String city;
    private String street;
    private String home;
    private String flat;

    public ClientEntity () {}

    public ClientEntity(String name, String surname, String city, String street, String home, String flat) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.home = home;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}

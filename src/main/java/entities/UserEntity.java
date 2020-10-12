package entities;

public class UserEntity {
    private String login;
    private String password;
    private String role;
    private Integer idclient;

    public UserEntity () {}

    public UserEntity(String login, String password, String role, Integer idclient) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.idclient = idclient;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }
}

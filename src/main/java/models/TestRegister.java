package models;

import dao.impementation.UserDAO;
import entities.UserEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("register")
@RequestScoped
public class TestRegister implements Serializable {
    private UserEntity user;
    private String status;

    private UserDAO userDAO = new UserDAO();

    public TestRegister () {
        this.user = new UserEntity();
    }

    public void register () {
        user.setRole("User");
        user.setIdclient(null);

        if (userDAO.isUserExist(user.getLogin())) status = "This user already exist!";
        else {
            new UserDAO().insert(user);
            status = "Registered successfully!";
        }

    }

    public String usersInDataBase () {
        String users = "";
        List<UserEntity> usersList = userDAO.getAll();

        return users = Arrays.toString(usersList.toArray());
    }

    public String getStatus() {
        return status;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
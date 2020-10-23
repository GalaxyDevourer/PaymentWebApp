package models;

import dao.impementation.UserDAO;
import entities.UserEntity;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Registration {
    private UserDAO userDAO = new UserDAO();

    public UserEntity userSignIn (String login, String password) {
        UserEntity user = userDAO.getUserByLogin(login);

        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            return user;
        }
        else return null;
    }

    public int userRegistration(String login, String password) {
        // user already exist
        if (userDAO.isUserExist(login)) return 1;
            // user successfully registered
        else if (!login.equals("") && !password.equals("")) {
            userDAO.insert(new UserEntity(login, password, "User", null));
            return 2;
        }
        // data not correct
        else return 3;
    }

    public String getMessageByCode(int code) {
        switch (code) {
            case 1:
                return "Error, this user already registered, please, use another login!";
            case 2:
                return "Congratulations! You are successfully registered!";
            default:
                return "Error, note, that your login and password must not be empty!";
        }
    }
}

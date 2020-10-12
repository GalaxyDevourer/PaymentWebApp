package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.UserEntity;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CustomConnection, FactoryCRUD <UserEntity> {

    private final String FIND_ALL_QUERY = "SELECT * FROM users";

    private final String UPDATE_ROLE_QUERY = "UPDATE users SET role=? WHERE login=?";

    private final String INSERT_QUERY = "INSERT INTO users (login, password," +
            " role) VALUES(?,?,?)";

    private final String DELETE_QUERY = "DELETE FROM user WHERE login=?";

    private final String GET_USER_BY_LOGIN_QUERY = "SELECT * FROM users WHERE login=?";

    @Override
    public List<UserEntity> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<UserEntity> list = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserEntity user = new UserEntity();

                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                list.add(user);
            }
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return list;
    }

    @Override
    @Deprecated
    public boolean update(UserEntity obj) {
        return false;
    }

    @Override
    public boolean insert(UserEntity user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            return rs.next();
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return false;
    }

    @Override
    public boolean delete(UserEntity user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setString(1, user.getLogin());

            stmt.executeUpdate();

            return true;
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return false;
    }

    public UserEntity getUserByLogin (String login) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(GET_USER_BY_LOGIN_QUERY);
            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserEntity user = new UserEntity();

                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                return user;
            }
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return null;
    }

    public boolean isUserExist (String login) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(GET_USER_BY_LOGIN_QUERY);
            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            return rs.next();
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return false;
    }

    public boolean updateRole (UserEntity user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE_ROLE_QUERY);
            stmt.setString(1, user.getRole());
            stmt.setString(2, user.getLogin());

            stmt.executeUpdate();

            return true;
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeSt(stmt);
            closeCon(conn);
        }

        return false;
    }

}
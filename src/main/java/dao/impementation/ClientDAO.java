package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.ClientEntity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements CustomConnection, FactoryCRUD<ClientEntity> {

    private final String FIND_ALL_QUERY = "SELECT * FROM client";

    private final String UPDATE_QUERY = "UPDATE client SET name=?, surname=?," +
            " city=?, street=?, home=?, flat=? WHERE id=?";

    private final String INSERT_QUERY = "INSERT INTO client (name, surname," +
            " city, street, home, flat) VALUES(?,?,?,?,?,?)";

    private final String DELETE_QUERY = "DELETE FROM client WHERE id=?";

    @Override
    public List<ClientEntity> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<ClientEntity> list = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClientEntity client = new ClientEntity();

                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setCity(rs.getString("city"));
                client.setStreet(rs.getString("street"));
                client.setHome(rs.getString("home"));
                client.setFlat(rs.getString("flat"));

                list.add(client);
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
    public boolean update(ClientEntity client) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getSurname());
            stmt.setString(3, client.getCity());
            stmt.setString(4, client.getStreet());
            stmt.setString(5, client.getHome());
            stmt.setString(6, client.getFlat());
            stmt.setInt(7, client.getId());

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

    @Override
    public boolean insert(ClientEntity client) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getSurname());
            stmt.setString(3, client.getCity());
            stmt.setString(4, client.getStreet());
            stmt.setString(5, client.getHome());
            stmt.setString(6, client.getFlat());

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
    public boolean delete(ClientEntity client) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, client.getId());

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
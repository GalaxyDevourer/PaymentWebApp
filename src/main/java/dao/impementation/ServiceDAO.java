package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.ServiceEntity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements CustomConnection, FactoryCRUD<ServiceEntity> {

    private final String FIND_ALL_QUERY = "SELECT * FROM service";

    private final String UPDATE_QUERY = "UPDATE service SET servicename=?, amount=?, worth=? WHERE servicename=?";

    private final String INSERT_QUERY = "INSERT INTO service (servicename, amount," +
            " worth) VALUES(?,?,?)";

    private final String DELETE_QUERY = "DELETE FROM service WHERE servicename=?";

    private final String GET_SERVICE_BY_NAME_QUERY = "SELECT * FROM service WHERE servicename=?";

    @Override
    public List<ServiceEntity> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<ServiceEntity> list = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ServiceEntity service = new ServiceEntity();

                service.setServicename(rs.getString("servicename"));
                service.setAmount(rs.getString("amount"));
                service.setWorth(rs.getString("worth"));

                list.add(service);
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
    public boolean update(ServiceEntity service) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, service.getServicename());
            stmt.setString(2, service.getAmount());
            stmt.setString(3, service.getWorth());
            stmt.setString(4, service.getServicename());

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
    public boolean insert(ServiceEntity service) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, service.getServicename());
            stmt.setString(2, service.getAmount());
            stmt.setString(3, service.getWorth());

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
    public boolean delete(ServiceEntity service) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE_QUERY);
            stmt.setString(1, service.getServicename());

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

    public ServiceEntity getServiceByName() {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ServiceEntity service = new ServiceEntity();

                service.setServicename(rs.getString("servicename"));
                service.setAmount(rs.getString("amount"));
                service.setWorth(rs.getString("worth"));

                return service;
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
}

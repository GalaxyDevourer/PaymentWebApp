package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.ClientServiceEntity;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ClientServiceDAO implements CustomConnection, FactoryCRUD<ClientServiceEntity> {

    private final String INSERT_QUERY = "INSERT INTO clientservice (idclient, idservice, monthlyamount, date) VALUES(?,?,?,?)";

    @Override
    @Deprecated
    public List<ClientServiceEntity> getAll() {
        return null;
    }

    @Override
    @Deprecated
    public boolean update(ClientServiceEntity clientservice) {
        return false;
    }

    @Override
    public boolean insert(ClientServiceEntity clientservice) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, clientservice.getIdclient());
            stmt.setInt(2, clientservice.getIdservice());
            stmt.setFloat(3, clientservice.getMonthlyamount());
            stmt.setDate(4, (Date) clientservice.getDate());

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
    @Deprecated
    public boolean delete(Integer id) {
        return false;
    }

}

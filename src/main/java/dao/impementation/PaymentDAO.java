package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.PaymentEntity;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class PaymentDAO implements CustomConnection, FactoryCRUD<PaymentEntity> {

    private final String INSERT_QUERY = "INSERT INTO payment (idclientservice, payment) VALUES(?,?)";

    @Override
    @Deprecated
    public List<PaymentEntity> getAll() {
        return null;
    }

    @Override
    @Deprecated
    public boolean update(PaymentEntity payment) {

        return false;
    }

    @Override
    public boolean insert(PaymentEntity payment) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            assert conn != null;
            stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, payment.getIdclientservice());
            stmt.setFloat(2, payment.getPayment());

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

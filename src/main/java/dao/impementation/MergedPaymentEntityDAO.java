package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.MergedPaymentEntity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MergedPaymentEntityDAO implements CustomConnection, FactoryCRUD<MergedPaymentEntity> {

    private final String FIND_ALL_QUERY =
            "SELECT paymentservice.c.name, paymentservice.c.surname, paymentservice.c.city, paymentservice.s.servicename,\n" +
            "       paymentservice.cs.monthlyamount, paymentservice.cs.date, paymentservice.p.payment\n" +
            "FROM paymentservice.payment p\n" +
            "  INNER JOIN paymentservice.clientservice cs ON p.idclientservice = cs.id\n" +
            "  INNER JOIN paymentservice.client c ON cs.idclient = c.id\n" +
            "  INNER JOIN paymentservice.service s ON cs.idservice = s.id\n";

    private final String BY_CLIENT_ID = "WHERE cs.idclient = ?;";
    private final String BY_CITY = "WHERE c.city = ?;";
    private final String BY_SERVICE_NAME = "WHERE s.servicename = ?;";

    @Override
    public List<MergedPaymentEntity> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<MergedPaymentEntity> list = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MergedPaymentEntity payment = new MergedPaymentEntity();

                payment.setName(rs.getString("name"));
                payment.setSurname(rs.getString("surname"));
                payment.setCity(rs.getString("city"));
                payment.setServicename(rs.getString("servicename"));
                payment.setMonthamount(rs.getFloat("monthlyamount"));
                payment.setDate(rs.getDate("date"));
                payment.setPayment(rs.getFloat("payment"));

                list.add(payment);
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
    public boolean update(MergedPaymentEntity obj) {
        return false;
    }

    @Override
    @Deprecated
    public boolean insert(MergedPaymentEntity ojb) {
        return false;
    }

    @Override
    @Deprecated
    public boolean delete(Integer id) {
        return false;
    }

    public List<MergedPaymentEntity> getCustomData (Integer clientID, String city, String serviceName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        List<MergedPaymentEntity> list = new ArrayList<>();

        try {
            conn = getConnection();

            if (clientID != null) {
                stmt = conn.prepareStatement(FIND_ALL_QUERY + BY_CLIENT_ID);
                stmt.setInt(1, clientID);
            }
            else if (city != null) {
                stmt = conn.prepareStatement(FIND_ALL_QUERY + BY_CITY);
                stmt.setString(1, city);
            }
            else if (serviceName != null) {
                stmt = conn.prepareStatement(FIND_ALL_QUERY + BY_SERVICE_NAME);
                stmt.setString(1, serviceName);
            }
            else stmt = conn.prepareStatement(FIND_ALL_QUERY);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MergedPaymentEntity payment = new MergedPaymentEntity();

                payment.setName(rs.getString("name"));
                payment.setSurname(rs.getString("surname"));
                payment.setCity(rs.getString("city"));
                payment.setServicename(rs.getString("servicename"));
                payment.setMonthamount(rs.getFloat("monthlyamount"));
                payment.setDate(rs.getDate("date"));
                payment.setPayment(rs.getFloat("payment"));

                list.add(payment);
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
}

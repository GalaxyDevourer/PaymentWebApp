package dao.impementation;

import dao.interfaces.CustomConnection;

import java.util.List;

public class MergedPaymentDAO implements CustomConnection {

    private final String GET_ALL_BY_CLIENT_ID_QUERY = "SELECT * FROM service";

    public List<MergedPaymentDAO> getAllByClientId (String client) {
        return null;
    }

}

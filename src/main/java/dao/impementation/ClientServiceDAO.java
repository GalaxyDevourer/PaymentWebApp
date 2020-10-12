package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.ClientServiceEntity;

import java.util.List;

public class ClientServiceDAO implements CustomConnection, FactoryCRUD<ClientServiceEntity> {
    @Override
    public List<ClientServiceEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(ClientServiceEntity obj) {
        return false;
    }

    @Override
    public boolean insert(ClientServiceEntity ojb) {
        return false;
    }

    @Override
    public boolean delete(ClientServiceEntity obj) {
        return false;
    }

}

package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.ClientEntity;

import java.util.List;

public class ClientDAO implements CustomConnection, FactoryCRUD<ClientEntity> {
    @Override
    public List<ClientEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(ClientEntity obj) {
        return false;
    }

    @Override
    public boolean insert(ClientEntity ojb) {
        return false;
    }

    @Override
    public boolean delete(ClientEntity obj) {
        return false;
    }

}

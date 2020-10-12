package dao.impementation;

import dao.interfaces.CustomConnection;
import dao.interfaces.FactoryCRUD;
import entities.PaymentEntity;

import java.util.List;

public class PaymentDAO implements CustomConnection, FactoryCRUD<PaymentEntity> {
    @Override
    public List<PaymentEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(PaymentEntity obj) {
        return false;
    }

    @Override
    public boolean insert(PaymentEntity ojb) {
        return false;
    }

    @Override
    public boolean delete(PaymentEntity obj) {
        return false;
    }

}

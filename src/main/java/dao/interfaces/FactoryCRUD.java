package dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FactoryCRUD<T>{
    List<T> getAll () throws SQLException, IOException, ClassNotFoundException;
    boolean update (T obj) throws SQLException, IOException, ClassNotFoundException;
    boolean insert (T ojb) throws SQLException, IOException, ClassNotFoundException;
    boolean delete (T obj) throws SQLException, IOException, ClassNotFoundException;
}

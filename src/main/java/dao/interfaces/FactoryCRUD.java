package dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FactoryCRUD<T>{
    List<T> getAll ();
    boolean update (T obj);
    boolean insert (T ojb);
    boolean delete (T obj);
}

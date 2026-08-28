package Digitalers.clase25.daos.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO <K, T>{

    K buscarPorId(T id);

    List<K> buscarTodos();

    boolean insertar(K entidad) throws SQLException;

    boolean eleminar (K entidad);

    boolean eleminarPorId (T id);

    boolean actualizar (K entidad);

}

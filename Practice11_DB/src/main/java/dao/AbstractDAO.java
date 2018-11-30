package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static dao.LogDAO.logger;

public abstract class AbstractDAO<K, T, Z> {

    Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll() throws SQLException;
    public abstract List<T> findById(K id);
    public abstract void addById(K id, Z task);

    public void close(Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Error: the connection tries to close: "+e.getMessage());
            }
        }
    }
}

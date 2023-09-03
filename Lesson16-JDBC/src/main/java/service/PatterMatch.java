package service;

import config.DataBaseConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class PatterMatch<T, G> {
    protected Connection connection;
    protected Statement statement;

    public PatterMatch() {
        try {
            connection = DataBaseConfig.connection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(T toSave) throws SQLException {
        connection = DataBaseConfig.connection();
        statement = connection.createStatement();

        saveLogic(toSave, statement);

        connection.close();
    }

    abstract protected void saveLogic(T obj, Statement statement) throws SQLException;

    public void delete(G id) throws SQLException {
        connection = DataBaseConfig.connection();
        statement = connection.createStatement();

        deleteLogic(id, statement);

        connection.close();
    }

    abstract protected void deleteLogic(G id, Statement statement) throws SQLException;

    public List<T> findAll() throws SQLException {
        connection = DataBaseConfig.connection();
        statement = connection.createStatement();

        List<T> result = findAllLogic(statement);

        connection.close();

        return result;

    }

    abstract protected List<T> findAllLogic(Statement statement) throws SQLException;
}

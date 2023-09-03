package service;

import config.DataBaseConfig;
import domain.Town;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TownService extends PatterMatch<Town, Integer> {
    @Override
    public void saveLogic(Town toSave, Statement statement) {
        if (townExistsByName(toSave.getName())) {
            return;
        }
        try (ResultSet resultSet = statement.executeQuery("SELECT max(towns.towns_id) + 1 FROM towns")) {
            resultSet.next();

            int idNext = resultSet.getInt(1);

            var preparedStatement = connection.prepareStatement("INSERT INTO towns (towns_id, name) VALUES (?,?)");

            preparedStatement.setInt(1, idNext);
            preparedStatement.setString(2, toSave.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Cannot save this town");
        }
    }

    @Override
    public void deleteLogic(Integer id, Statement statement) throws SQLException {
        statement.executeUpdate("UPDATE students SET town = NULL WHERE town = " + id);

        statement.executeUpdate("DELETE FROM towns WHERE towns_id = " + id);
    }

    @Override
    public List<Town> findAllLogic(Statement statement) throws SQLException {
        List<Town> lst = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT towns.name FROM towns");
        while (resultSet.next()) {
            Town town = new Town();
            town.setName(resultSet.getString(1));
            lst.add(town);
        }
        return lst;
    }

    public static boolean townExistsByName(String name) {
        try (Connection connection = DataBaseConfig.connection();
             ResultSet resultSet = connection.createStatement().executeQuery("SELECT name FROM towns WHERE name = '" + name + "'")) {
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public static int getIdByName(String name) {
        try (Connection connection = DataBaseConfig.connection();
             ResultSet resultSet = connection.createStatement().executeQuery("SELECT towns_id FROM towns WHERE name = '" + name + "'")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


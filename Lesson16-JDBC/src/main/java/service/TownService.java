package service;

import config.DataBaseConfig;
import domain.Town;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TownService {
    public static void save(Town town) {
        if(townExistsByName(town.getName())) {
            System.out.println("Town exists!");
            return;
        }
        try (Connection connection = DataBaseConfig.connection();
             ResultSet resultSet = connection.createStatement().executeQuery("select max(towns.towns_id) + 1 from towns")) {
            resultSet.next();

            int idNext = resultSet.getInt(1);

            var preparedStatement = DataBaseConfig.connection().prepareStatement("insert into towns (towns_id, name) values (?,?)");

            preparedStatement.setInt(1, idNext);
            preparedStatement.setString(2, town.getName());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Cannot save this town");
        }
    }

    public static void delete(Integer idTown) {
        try (Connection connection = DataBaseConfig.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("update students set town = null where town = " + idTown);

            statement.executeUpdate("delete from towns where towns_id = " + idTown);
        } catch (SQLException e) {
            System.out.println("Cannot delete this town");
        }
    }
    public static boolean townExistsByName(String name) {
        try (Connection connection = DataBaseConfig.connection();
             ResultSet resultSet = connection.createStatement().executeQuery("select name from towns where name = '" + name + "'")) {
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }
    public static int getIdByName(String name) {
        try (Connection connection = DataBaseConfig.connection();
             ResultSet resultSet = connection.createStatement().executeQuery("select towns_id from towns where name = '" + name + "'")) {
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


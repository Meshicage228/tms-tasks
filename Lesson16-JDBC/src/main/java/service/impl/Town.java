package service.impl;

import config.DataBaseConfig;
import service.TownService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Town implements TownService {
    private String name;

    @Override
    public void save() {
        try (Statement statement = DataBaseConfig.createStatement();
             ResultSet resultSet = statement.executeQuery("select max(towns.towns_id) + 1 from towns")) {
            resultSet.next();

            int id = resultSet.getInt(1);

            var preparedStatement = DataBaseConfig.connection().prepareStatement("insert into towns (towns_id, name) values (?,?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Cannot save this town");
        }
    }

    @Override
    public void delete(String name) {
        try (Statement statement = DataBaseConfig.createStatement();
             ResultSet resultSet = statement.executeQuery("select towns_id from towns where name = '" + name + "'")) {
            resultSet.next();

            int id = resultSet.getInt(1);

            statement.executeUpdate("update students set town = null where town = " + id);

            statement.executeUpdate("delete from towns where name = '" + name + "'");
        } catch (SQLException e) {
            System.out.println("Cannot delete this town");
        }
    }

    public static int getIdByName(String name) {
        try (Statement statement = DataBaseConfig.createStatement();
             ResultSet resultSet = statement.executeQuery("select towns_id from towns where name = '" + name + "'")) {
            resultSet.next();

            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean townExists(String nameOfTown) {
        try (ResultSet resultSet = DataBaseConfig.createStatement().executeQuery("select name from towns where towns.name like '" + nameOfTown + "'")) {
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }
}

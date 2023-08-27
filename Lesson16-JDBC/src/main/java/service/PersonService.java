package service;

import config.DataBaseConfig;
import domain.Person;
import domain.Town;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public static void save(List<Person> persons) throws SQLException {
        Connection connection = DataBaseConfig.connection();
        Statement statement = connection.createStatement();
        for (Person student : persons) {
            ResultSet resultSet = statement.executeQuery("select max(students.stud_id) + 1 from students");
            resultSet.next();
            int id = resultSet.getInt(1);

            var preparedStatement = connection.prepareStatement(
                    "insert into students (stud_id, name, surname, town) values (?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());

            TownService.save(new Town(student.getTown()));
            preparedStatement.setInt(4, TownService.getIdByName(student.getTown()));
            preparedStatement.execute();
        }
        connection.close();
        statement.close();
    }
    public static List<Person> findAll() {
        List<Person> lst = new ArrayList<>();
        try (Connection connection = DataBaseConfig.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select stud.name, stud.surname, t.name from students stud left join towns t on stud.stud_id = t.towns_id")) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setName(resultSet.getString(1));
                person.setSurname(resultSet.getString(2));
                person.setTown(resultSet.getString(3));
                lst.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
    public static void delete(Integer id) {
        try ( Connection connection = DataBaseConfig.connection();
              Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from students where stud_id = " + id);
        } catch (SQLException e) {
            System.out.println("Cannot delete this person");
        }
    }
}

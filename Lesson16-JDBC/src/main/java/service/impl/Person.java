package service.impl;

import config.DataBaseConfig;
import service.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements PersonService {
    private String name;
    private String surname;
    private String town;

    @Override
    public void save(List<Person> persons) throws SQLException {
        Connection connection = DataBaseConfig.connection();
        Statement statement = connection.createStatement();
        for (Person student : persons) {
            ResultSet resultSet = statement.executeQuery("select max(students.stud_id) + 1 from students");
            resultSet.next();
            int id = resultSet.getInt(1);

            var preparedStatement = connection.prepareStatement(
                    "insert into students (stud_id, name, surname, town) values (?, ?, ?, ?)");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, student.name);
            preparedStatement.setString(3, student.surname);

            if (!Town.townExists(student.town)) {
                new Town(student.town).save();
            }
            preparedStatement.setInt(4, Town.getIdByName(student.town));
            preparedStatement.execute();
        }
        connection.close();
        statement.close();
    }

    @Override
    public List<Person> findAll() {
        List<Person> lst = new ArrayList<>();
        try (Statement statement = DataBaseConfig.createStatement();
             ResultSet resultSet = statement.executeQuery("select stud.name, stud.surname, t.name from students stud left join towns t on stud.stud_id = t.towns_id")) {
            while (resultSet.next()) {
                Person person = new Person();
                person.name = resultSet.getString(1);
                person.surname = resultSet.getString(2);
                person.town = resultSet.getString(3);
                lst.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    @Override
    public void deleteByNameSurname(String name, String surname) {
        try (Statement statement = DataBaseConfig.createStatement()) {
            statement.executeUpdate("delete from students where name = '" + name + "' and surname = '" + surname + "'");
        } catch (SQLException e) {
            System.out.println("Cannot delete this person");
        }
    }
}

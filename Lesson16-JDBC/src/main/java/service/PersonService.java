package service;

import domain.Person;
import domain.Town;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService extends PatterMatch<Person, Integer> {
    @Override
    void saveLogic(Person person, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT max(students.stud_id) + 1 FROM students");
        resultSet.next();
        int id = resultSet.getInt(1);

        var preparedStatement = connection.prepareStatement(
                "INSERT INTO students (stud_id, name, surname, town) VALUES (?, ?, ?, ?)");

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getSurname());

        new TownService().save(new Town(person.getTown()));
        preparedStatement.setInt(4, TownService.getIdByName(person.getTown()));
        preparedStatement.execute();
    }

    @Override
    void deleteLogic(Integer id, Statement statement) throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE stud_id = " + id);
    }

    @Override
    List<Person> findAllLogic(Statement statement) throws SQLException {
        List<Person> lst = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(
                "SELECT stud.name, stud.surname, t.name " +
                        "FROM students stud LEFT JOIN towns t ON stud.stud_id = t.towns_id");
        while (resultSet.next()) {
            Person person = new Person();
            person.setName(resultSet.getString(1));
            person.setSurname(resultSet.getString(2));
            person.setTown(resultSet.getString(3));
            lst.add(person);
        }
        return lst;
    }
}

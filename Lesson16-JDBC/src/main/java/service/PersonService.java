package service;

import service.impl.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    void save(List<Person> person) throws SQLException;

    List<Person> findAll();

    void deleteByNameSurname(String name, String surname);
}

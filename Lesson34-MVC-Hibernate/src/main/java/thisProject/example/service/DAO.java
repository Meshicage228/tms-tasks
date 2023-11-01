package thisProject.example.service;

import org.hibernate.Session;

import java.util.List;

public interface DAO<T>{
    void save(T entity);

    List<T> getAll();

    T getById(Integer id);

    void update(T entity);

    void delete(T obj);

}

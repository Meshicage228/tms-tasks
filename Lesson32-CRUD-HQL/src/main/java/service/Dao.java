package service;

import config.DataBaseConfiguration;
import entity.PersonEntity;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    void save(T entity);

    List<T> getAll();

    Optional<T> getById(Integer id);

    void update(T entity);

    void delete(T obj);

    static Session openSessionAndTransaction(){
        Session session = DataBaseConfiguration.sessionFactory.openSession();
        session.getTransaction().begin();
        return session;
    }
    static void closeSessionAndTransaction(Session session){
        session.getTransaction().commit();
        session.close();
    }
}

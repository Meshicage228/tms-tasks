package project.com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.com.config.DataBaseConfiguration;

import java.util.UUID;

public abstract class EntityService<T> {
    public T getById(UUID uuid){
        Session session = DataBaseConfiguration.createSession();
        Transaction transaction = session.beginTransaction();

        T entity = getByIdActon(uuid, session);

        System.out.println(entity);

        transaction.commit();
        session.close();

        return entity;
    };
    protected abstract T getByIdActon(UUID uuid, Session session);

    public UUID saveEntity(T entity){
        Session session = DataBaseConfiguration.createSession();
        Transaction transaction = session.beginTransaction();

        UUID uuid = saveAction(session, entity);

        transaction.commit();
        session.close();

        return uuid;

    };
    protected abstract UUID saveAction(Session session, T entity);
}

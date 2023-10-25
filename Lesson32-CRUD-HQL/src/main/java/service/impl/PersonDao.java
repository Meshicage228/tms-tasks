package service.impl;

import config.DataBaseConfiguration;
import entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.Dao;

import java.util.List;
import java.util.Optional;

public class PersonDao implements Dao<PersonEntity> {
    @Override
    public void save(PersonEntity entity) {
        Session session = Dao.openSessionAndTransaction();
        session.save(entity);
        Dao.closeSessionAndTransaction(session);
    }

    @Override
    public List<PersonEntity> getAll() {
        Session session = Dao.openSessionAndTransaction();
        Query fromPersonEntity = session.createQuery("FROM PersonEntity");
        List list = fromPersonEntity.list();
        Dao.closeSessionAndTransaction(session);
        return list;
    }

    @Override
    public Optional<PersonEntity> getById(Integer id) {
        Session session = Dao.openSessionAndTransaction();
        Optional<PersonEntity> personEntity = Optional.ofNullable(session.find(PersonEntity.class, id));
        Dao.closeSessionAndTransaction(session);
        return personEntity;
    }

    @Override
    public void update(PersonEntity entity) {
        Session session = Dao.openSessionAndTransaction();

        Dao.closeSessionAndTransaction(session);
    }

    @Override
    public void delete(Integer id) {
        Session session = Dao.openSessionAndTransaction();

        Dao.closeSessionAndTransaction(session);
    }

}

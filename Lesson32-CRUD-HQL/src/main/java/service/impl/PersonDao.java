package service.impl;

import config.DataBaseConfiguration;
import entity.PersonEntity;
import entity.TaskEntity;
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
    public void delete(PersonEntity entity) {
        Session session = Dao.openSessionAndTransaction();

        //Передумать

        Query query = session.createQuery("UPDATE TaskEntity SET person.id = NULL  WHERE person.id =: idPerson");
        query.setParameter("idPerson", entity.getId());
        query.executeUpdate();

        Query query1 = session.createQuery("DELETE FROM PersonEntity WHERE id =: pId");
        query1.setParameter("pId", entity.getId());
        query1.executeUpdate();

        Dao.closeSessionAndTransaction(session);
    }

}

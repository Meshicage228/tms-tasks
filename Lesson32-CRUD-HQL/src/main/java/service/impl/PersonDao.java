package service.impl;

import config.DataBaseConfiguration;
import domain.Readiness;
import entity.PersonEntity;
import entity.TaskEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.Dao;

import java.util.ArrayList;
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
        Criteria criteria = session.createCriteria(PersonEntity.class);
        List list = criteria.list();
        Dao.closeSessionAndTransaction(session);
        return list;
    }

    @Override
    public PersonEntity getById(Integer id) {
        Session session = Dao.openSessionAndTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, id);
        Dao.closeSessionAndTransaction(session);
        return personEntity;
    }

    public List<PersonEntity> getByTaskReadiness(Readiness readiness){
        Session session = Dao.openSessionAndTransaction();
        Query query = session.createQuery("SELECT ps FROM PersonEntity ps JOIN ps.entityList as lst where lst.readiness=: task");
        query.setParameter("task", readiness);
        List<PersonEntity> list = query.list();
        Dao.closeSessionAndTransaction(session);
        return list;
    }

    @Override
    public void update(PersonEntity entity) {
        Session session = Dao.openSessionAndTransaction();

        Dao.closeSessionAndTransaction(session);
    }

    @Override
    public void delete(PersonEntity entity) {
        Session session = Dao.openSessionAndTransaction();

        session.delete(entity);

        Dao.closeSessionAndTransaction(session);
    }


}

package service.impl;

import domain.Readiness;
import entity.TaskEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.Dao;

import java.util.List;
import java.util.Optional;

public class TaskDao implements Dao<TaskEntity> {
    @Override
    public void save(TaskEntity entity) {
        Session session = Dao.openSessionAndTransaction();
        session.save(entity);
        Dao.closeSessionAndTransaction(session);
    }

    @Override
    public List<TaskEntity> getAll() {
        Session session = Dao.openSessionAndTransaction();
        Query query = session.createQuery("FROM TaskEntity");
        List list = query.list();
        Dao.closeSessionAndTransaction(session);
        return list;
    }

    @Override
    public TaskEntity getById(Integer id) {
        Session session = Dao.openSessionAndTransaction();

        TaskEntity taskEntity = session.get(TaskEntity.class, id);

        Dao.closeSessionAndTransaction(session);
        return taskEntity;
    }

    @Override
    public void update(TaskEntity entity) {

    }
    public void update(TaskEntity entity, Readiness readiness){
        Session session = Dao.openSessionAndTransaction();
        Query query = session.createQuery("UPDATE TaskEntity as ts SET ts.readiness =: newReady WHERE ts.id =: curId");
        query.setParameter("curId", entity.getId());
        query.setParameter("newReady", readiness).executeUpdate();
        Dao.closeSessionAndTransaction(session);
    }

    @Override
    public void delete(TaskEntity obj) {
        Session session = Dao.openSessionAndTransaction();

        session.delete(obj);

        Dao.closeSessionAndTransaction(session);
    }
}

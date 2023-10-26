package service.impl;

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
    public Optional<TaskEntity> getById(Integer id) {
        Session session = Dao.openSessionAndTransaction();

        Optional<TaskEntity> taskEntity = Optional.ofNullable(session.find(TaskEntity.class, id));
        Dao.closeSessionAndTransaction(session);
        return taskEntity;
    }

    @Override
    public void update(TaskEntity entity) {

    }

    @Override
    public void delete(TaskEntity obj) {
        Session session = Dao.openSessionAndTransaction();
        Query query = session.createQuery("DELETE FROM TaskEntity WHERE id =: taskId");
        query.setParameter("taskId", obj.getId());
        session.delete(obj);

        Dao.closeSessionAndTransaction(session);
    }
}

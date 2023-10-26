package service.impl;

import entity.TaskEntity;
import org.hibernate.Session;
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
        return null;
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

        session.delete(obj);

        Dao.closeSessionAndTransaction(session);
    }
}

package project.com.service.impl;

import org.hibernate.Session;
import project.com.entity.PersonEntity;
import project.com.service.EntityService;

import java.util.UUID;

public class PersonEntityServiceImpl extends EntityService<PersonEntity> {
    @Override
    protected PersonEntity getByIdActon(UUID uuid, Session session) {
        return session.find(PersonEntity.class, uuid);
    }

    @Override
    protected UUID saveAction(Session session, PersonEntity entity) {
        return (UUID)session.save(entity);
    }
}

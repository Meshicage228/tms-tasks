package project.com.service.impl;

import org.hibernate.Session;
import project.com.entity.PhoneEntity;
import project.com.service.EntityService;

import java.util.UUID;

public class PhoneEntityServiceImpl extends EntityService<PhoneEntity> {
    @Override
    protected PhoneEntity getByIdActon(UUID uuid, Session session) {
        return session.find(PhoneEntity.class, uuid);
    }

    @Override
    protected UUID saveAction(Session session, PhoneEntity entity) {
        return (UUID)session.save(entity);
    }
}

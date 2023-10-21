package project.com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.com.config.DataBaseConfiguration;
import project.com.entity.PersonEntity;

import java.util.UUID;

public class PersonServiceImpl implements PersonService {
    @Override
    public PersonEntity getById(UUID uuid) {
        Session session = DataBaseConfiguration.createSession();
        Transaction transaction = session.beginTransaction();

        PersonEntity personEntity = session.find(PersonEntity.class, uuid);
        System.out.println(personEntity);

        transaction.commit();
        session.close();

        return personEntity;
    }
}

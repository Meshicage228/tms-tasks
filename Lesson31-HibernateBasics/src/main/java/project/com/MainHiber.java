package project.com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.com.config.DataBaseConfiguration;
import project.com.entity.JobTitle;
import project.com.entity.PersonEntity;

import java.util.UUID;

public class MainHiber {
    public static void main(String[] args) {
        Session session = DataBaseConfiguration.createSession();
        Transaction transaction = session.beginTransaction();

     /*   PersonEntity personEntity = PersonEntity.builder()
                .id(UUID.randomUUID())
                .name("Vlad")
                .title(JobTitle.MANAGER)
                .build();

        session.save(personEntity);*/

        PersonEntity personEntity = session.find(PersonEntity.class, UUID.fromString("a0ec2160-c92d-4553-bcec-eb45c8a22f13"));
        System.out.println(personEntity);
        transaction.commit();
        session.close();
        System.out.println("hello");
    }
}

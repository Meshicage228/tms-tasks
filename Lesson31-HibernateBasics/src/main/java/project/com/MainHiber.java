package project.com;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.com.config.DataBaseConfiguration;
import project.com.domain.JobTitle;
import project.com.entity.PersonEntity;
import project.com.domain.Sex;
import project.com.entity.PhoneEntity;
import project.com.service.PersonServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainHiber {
    public static void main(String[] args) {
        /*Session session = DataBaseConfiguration.createSession();
        Transaction transaction = session.beginTransaction();

        PersonEntity vlad = PersonEntity.builder()
                .sex(Sex.MAN)
                .name("Vlad")
                .jobTitle(JobTitle.DIRECTOR)
                .someInfo("Like pizza")
                .date(new Date())
                .build();

        PersonEntity sasha = PersonEntity.builder()
                .sex(Sex.WOMAN)
                .name("Sasha")
                .jobTitle(JobTitle.MANAGER)
                .someInfo("Like cheese of navarro")
                .date(new Date())
                .build();

        PhoneEntity phone1 = PhoneEntity.builder()
                .phone("+375 (29) 333-33-33")
                .personEntity(vlad)
                .build();
        PhoneEntity phone2 = PhoneEntity.builder()
                .phone("+375 (29) 123-54-645")
                .personEntity(vlad)
                .build();
        PhoneEntity phone3 = PhoneEntity.builder()
                .phone("+375 (29) 666-66-645")
                .personEntity(sasha)
                .build();

        session.save(phone1);
        session.save(phone2);
        session.save(phone3);
        session.save(vlad);
        session.save(sasha);

        transaction.commit();
        session.close();*/

        PersonServiceImpl personService = new PersonServiceImpl();
        PersonEntity byId = personService.getById(UUID.fromString("d0cfae9e-1b68-4dd1-bfcb-62ca7d3323e0"));
        System.out.println(byId);
    }
}

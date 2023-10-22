package project.com;

import project.com.domain.JobTitle;
import project.com.domain.Sex;
import project.com.entity.PersonEntity;
import project.com.entity.PhoneEntity;
import project.com.service.impl.PersonEntityServiceImpl;
import project.com.service.impl.PhoneEntityServiceImpl;

import java.util.Date;
import java.util.UUID;

public class MainHiber {
    public static void main(String[] args) {
        PersonEntityServiceImpl personService = new PersonEntityServiceImpl();
        PhoneEntityServiceImpl phoneService = new PhoneEntityServiceImpl();

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

        personService.saveEntity(vlad);
        UUID uuidSasha = personService.saveEntity(sasha);

        UUID uuidPhone = phoneService.saveEntity(phone1);
        phoneService.saveEntity(phone2);
        phoneService.saveEntity(phone3);

        PersonEntity fromDB1 = personService.getById(uuidSasha);
        PhoneEntity byId = phoneService.getById(uuidPhone);

    }
}

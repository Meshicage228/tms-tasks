package thisProject.example.service.impl;

import lombok.RequiredArgsConstructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import thisProject.example.dto.PersonDto;
import thisProject.example.entity.PersonEntity;
import thisProject.example.mapper.PersonMapper;
import thisProject.example.service.DAO;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonDaoImpl implements DAO<PersonDto> {

    private final SessionFactory factory;

    private final PersonMapper mapper;

    @Override
    public PersonDto save(PersonDto dto) {
        Session session = factory.openSession();
        session.getTransaction().begin();

        PersonEntity personEntity = mapper.fromDtoToEntity(dto);

        session.save(personEntity);

        PersonDto personDto = mapper.fromEntityToDto(personEntity);

        session.getTransaction().commit();
        session.close();

        return personDto;
    }

    @Override
    public List<PersonDto> getAll() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM PersonEntity");
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public PersonDto getById(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        PersonDto personDto = session.get(PersonDto.class, id);

        transaction.commit();
        session.close();

        return personDto;
    }

    @Override
    public void update(PersonDto entity) {

    }

    @Override
    public void delete(PersonDto obj) {

    }

    @Override
    public void deleteById(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM PersonEntity WHERE id =: myId");
        query.setParameter("myId", id);
        query.executeUpdate();

        transaction.commit();
        session.close();

    }
}

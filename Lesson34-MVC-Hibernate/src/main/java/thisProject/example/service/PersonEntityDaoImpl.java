package thisProject.example.service;

import lombok.RequiredArgsConstructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import thisProject.example.entity.PersonEntity;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PersonEntityDaoImpl implements DAO<PersonEntity> {
    private final SessionFactory factory;

    @Override
    public void save(PersonEntity entity) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<PersonEntity> getAll() {
        return null;
    }

    @Override
    public PersonEntity getById(Integer id) {
        return null;
    }

    @Override
    public void update(PersonEntity entity) {

    }

    @Override
    public void delete(PersonEntity obj) {

    }
}

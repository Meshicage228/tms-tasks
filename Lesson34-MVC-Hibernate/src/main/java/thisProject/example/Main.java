package thisProject.example;


import org.hibernate.Session;
import thisProject.example.config.DataBaseConfiguration;
import thisProject.example.entity.PersonEntity;

public class Main {
    public static void main(String[] args) {
        PersonEntity ps = PersonEntity.builder()
                .name("Vlad")
                .build();

        Session session = DataBaseConfiguration.createSession();
        session.getTransaction().begin();

        session.save(ps);

        session.getTransaction().commit();
        session.close();
    }
}

package project.com.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project.com.entity.PersonEntity;

public class DataBaseConfiguration {

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection-driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate_test");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "28072004");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.show_sql" ,"true");
        configuration.addAnnotatedClass(PersonEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session createSession(){
        return sessionFactory.openSession();
    }
}

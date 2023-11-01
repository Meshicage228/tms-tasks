package thisProject.example.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import thisProject.example.entity.PersonEntity;

@Configuration
public class WebAppConfig {
    @Bean
    SessionFactory sessionFactory(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(PersonEntity.class);
        configuration.setProperty("hibernate.connection-driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/for_personal");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "28072004");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.show_sql" ,"true");
        configuration.setProperty("hibernate.hbm2ddl.auto" ,"update");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        System.out.println("hello");

        return sessionFactory;
    }

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setSuffix("/pages/");
        view.setSuffix(".jsp");
        return view;
    }
}

package thisProject.example.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import thisProject.example.entity.PersonEntity;

@Configuration
@EnableWebMvc
public class WebAppConfig {
    @Bean
    SessionFactory sessionFactory() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return new org.hibernate.cfg.Configuration()
        .setProperty("hibernate.connection-driver_class", "org.postgresql.Driver")
        .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/for_personal")
        .setProperty("hibernate.connection.username", "postgres")
        .setProperty("hibernate.connection.password", "28072004")
        .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect")
        .setProperty("hibernate.show_sql" ,"true")
        .setProperty("hibernate.hbm2ddl.auto" ,"update")
        .addAnnotatedClass(PersonEntity.class)
        .buildSessionFactory();
    }

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setSuffix("/pages/");
        view.setSuffix(".jsp");
        return view;
    }
}

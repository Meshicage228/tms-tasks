package horseRacing.com.config;

import horseRacing.com.domain.Couple;
import horseRacing.com.domain.Horse;
import horseRacing.com.domain.Rider;
import horseRacing.com.domain.Wallet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "horseRacing.com.domain")
public class CoupleConfig {
    @Bean
    Couple firstCouple() {
        return new Couple(horse1(), rider1());
    }

    @Bean
    Couple secondCouple() {
        return new Couple(horse2(), rider2());
    }

    @Bean
    Couple thirdCouple() {
        return new Couple(horse3(), rider3());
    }
    @Bean
    Horse horse1() {
        return new Horse("Lora");
    }

    @Bean
    Horse horse2() {
        return new Horse("Poka");
    }

    @Bean
    Horse horse3() {
        return new Horse("Shella");
    }

    @Bean
    Rider rider1() {
        return new Rider("Vlad");
    }

    @Bean
    Rider rider2() {
        return new Rider("Navarro");
    }

    @Bean
    Rider rider3() {
        return new Rider("Georgy");
    }
    @Bean
    @Scope("prototype")
    Wallet wallet() {
        return new Wallet();
    }
}

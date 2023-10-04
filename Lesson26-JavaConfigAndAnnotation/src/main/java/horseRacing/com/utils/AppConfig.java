package horseRacing.com.utils;

import horseRacing.com.domain.*;
import horseRacing.com.services.impl.CoupleServiceImpl;
import horseRacing.com.services.impl.WalletServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"horseRacing.com"})
public class AppConfig {
    @Bean
    @Scope("prototype")
    RacingGame racingGame() {
        return new RacingGame(walletService(), coupleService());
    }

    @Bean
    @Scope("prototype")
    WalletServiceImpl walletService() {
        return new WalletServiceImpl(wallet());
    }

    @Bean
    @Scope("prototype")
    Wallet wallet() {
        return new Wallet();
    }

    @Bean
    CoupleServiceImpl coupleService() {
        return new CoupleServiceImpl(List.of(firstCouple(), secondCouple(), thirdCouple()));
    }

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


}
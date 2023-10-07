package horseRacing.com.config;

import horseRacing.com.domain.*;
import horseRacing.com.services.impl.CoupleServiceImpl;
import horseRacing.com.services.impl.WalletServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(basePackages = {"horseRacing.com.services"})
public class AppConfig {
    @Bean
    @Scope("prototype")
    RacingGame racingGame(WalletServiceImpl walletService, CoupleServiceImpl coupleService) {
        return new RacingGame(walletService, coupleService);
    }

}
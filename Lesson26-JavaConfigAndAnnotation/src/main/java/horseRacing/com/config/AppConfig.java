package horseRacing.com.config;

import horseRacing.com.domain.*;
import horseRacing.com.services.impl.CoupleServiceImpl;
import horseRacing.com.services.impl.WalletServiceImpl;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"horseRacing.com.services"})
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    @Scope("prototype")
    RacingGame racingGame(WalletServiceImpl walletService, CoupleServiceImpl coupleService) {
        return new RacingGame(walletService, coupleService);
    }

}
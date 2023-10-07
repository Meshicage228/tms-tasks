package horseRacing.com.config;

import horseRacing.com.domain.Couple;
import horseRacing.com.domain.Wallet;
import horseRacing.com.services.impl.CoupleServiceImpl;
import horseRacing.com.services.impl.WalletServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "horseRacing.com.services")
public class ServiceConfig {
    @Bean
    CoupleServiceImpl coupleService(List<Couple> couples) {
        return new CoupleServiceImpl(couples);
    }
    @Bean
    @Scope("prototype")
    WalletServiceImpl walletService(Wallet wallet) {
        return new WalletServiceImpl(wallet);
    }

}

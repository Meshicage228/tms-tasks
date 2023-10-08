package horseRacing.com.domain;

import horseRacing.com.services.impl.CoupleServiceImpl;
import horseRacing.com.services.impl.WalletServiceImpl;
import horseRacing.com.utils.TimeCalc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Service
public class RacingGame {
    private final WalletServiceImpl walletService;
    private final CoupleServiceImpl couples;

    @TimeCalc
    public void startGame() {
        do {
            Couple maybeWin = couples.chooseCouple();

            walletService.makeBid();

            System.out.println("Game started");
            startRaces();

            System.out.println("Winner rider" + couples.getWinner().getRider() + " horse : " + couples.getWinner().getHorse());

            if (maybeWin.equals(couples.getWinner())) {
                System.out.println("Congratulations! You have won!");
                walletService.addMoney();
            } else {
                System.out.println("Lost!");
                walletService.withdrawMoney();
            }
        } while (walletService.getWallet().getMoney() > 0);
        System.out.println("You run out of money! The end");
    }

    private void startRaces() {
        for (int i = 0; i < 5; i++) {
            try {
                couples.getCouples().stream()
                        .map(Couple::getHorse)
                        .forEach(horse -> {
                            horse.setKoefOfSpeed(horse.getKoefOfSpeed() + new Random().nextFloat(2));
                        });
                Thread.sleep(100);
                System.out.println(i + " round finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

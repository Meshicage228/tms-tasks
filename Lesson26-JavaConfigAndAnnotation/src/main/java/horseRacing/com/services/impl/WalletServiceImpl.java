package horseRacing.com.services.impl;

import horseRacing.com.domain.Wallet;
import horseRacing.com.services.WalletService;
import horseRacing.com.utils.CreateScanner;
import lombok.Getter;
import org.springframework.stereotype.Service;


@Getter
@Service
public class WalletServiceImpl implements WalletService {
    private final Wallet wallet;
    private float bid;

    public WalletServiceImpl(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public void makeBid() {
        float bid;
        System.out.println("Your amount of money : " + wallet.getMoney());
        do {
            System.out.print("Make your bid : ");
            bid = CreateScanner.scanner().nextFloat();
        } while (bid > wallet.getMoney() || bid <= 0);

        this.bid = bid;
    }

    @Override
    public void addMoney() {
        wallet.setMoney(wallet.getMoney() + bid * 2);
    }

    @Override
    public void withdrawMoney() {
        wallet.setMoney(wallet.getMoney() - bid * 2);
    }
}

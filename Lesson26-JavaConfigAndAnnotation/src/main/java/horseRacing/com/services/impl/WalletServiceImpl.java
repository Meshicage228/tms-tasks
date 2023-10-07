package horseRacing.com.services.impl;

import horseRacing.com.domain.Wallet;
import horseRacing.com.services.WalletService;
import horseRacing.com.utils.CreateScanner;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Getter
@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {
    @NonNull
    private final Wallet wallet;
    private float bid;

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

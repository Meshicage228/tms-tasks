package horseRacing.com.services.impl;


import horseRacing.com.domain.Couple;
import horseRacing.com.services.CoupleService;
import horseRacing.com.utils.CreateScanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@Service
public class CoupleServiceImpl implements CoupleService {
    private final List<Couple> couples;

    @Override
    public Couple chooseCouple() {
        int coupleIndex;
        do {
            for (int i = 0; i < couples.size(); i++) {
                System.out.println(i + "." + couples.get(i));
            }
            System.out.print("Choose your couple : ");
            coupleIndex = CreateScanner.scanner().nextInt();
        } while (coupleIndex < 0 || coupleIndex >= couples.size());

        return couples.get(coupleIndex);
    }

    @Override
    public Couple getWinner() {
        List<Double> doubles = new ArrayList<>();
        for (Couple couple : couples) {
            doubles.add(couple.getHorse().getKoefOfSpeed());
        }
        Double max = Collections.max(doubles);

        int i = doubles.indexOf(max);

        return couples.get(i);

    }
}

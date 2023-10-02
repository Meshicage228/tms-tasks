package services.impl;

import domain.Couple;
import domain.Horse;
import domain.Rider;
import lombok.Getter;
import services.CoupleService;
import utils.CreateScanner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class CoupleServiceImpl implements CoupleService {
    private final List<Couple> couples;

    public CoupleServiceImpl(List<Couple> couples) {
        this.couples = couples;
    }

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

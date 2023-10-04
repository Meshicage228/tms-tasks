package services;

import domain.Couple;
import domain.Horse;

public interface CoupleService {
    Couple chooseCouple();
    Couple getWinner();
}

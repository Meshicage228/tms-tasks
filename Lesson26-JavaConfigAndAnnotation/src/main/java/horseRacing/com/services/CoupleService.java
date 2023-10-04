package horseRacing.com.services;


import horseRacing.com.domain.Couple;

public interface CoupleService {
    Couple chooseCouple();
    Couple getWinner();
}

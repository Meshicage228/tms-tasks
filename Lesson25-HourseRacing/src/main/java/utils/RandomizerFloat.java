package utils;

import services.Randomizer;

import java.util.Random;

public class RandomizerFloat implements Randomizer {
    @Override
    public float createRandome() {
        return new Random().nextFloat(2);
    }
}

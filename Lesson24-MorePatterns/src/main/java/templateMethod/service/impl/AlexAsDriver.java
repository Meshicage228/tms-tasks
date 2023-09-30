package templateMethod.service.impl;

import templateMethod.service.CarMethod;

public class AlexAsDriver extends CarMethod {
    @Override
    protected float showSpeed() {
        return 90.3f;
    }

    @Override
    protected String carDriver() {
        return "Alex as driver";
    }

    @Override
    protected String changeMusic(String name) {
        return "Rammstein : 'Muter'";
    }
}

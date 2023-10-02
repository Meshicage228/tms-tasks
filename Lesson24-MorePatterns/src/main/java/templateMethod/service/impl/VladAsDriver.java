package templateMethod.service.impl;

import templateMethod.service.CarMethod;

public class VladAsDriver extends CarMethod {
    @Override
    protected float showSpeed() {
        return 120.4f;
    }

    @Override
    protected String carDriver() {
        return "Vlad";
    }

    @Override
    protected String changeMusic(String name) {
        return "Sunboy : 'What is love'";
    }
}

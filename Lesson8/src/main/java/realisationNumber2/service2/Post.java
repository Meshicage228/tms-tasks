package realisationNumber2.service2;

public enum Post {
    DIRECTOR(2.5f),
    WORKER(1.3f);
    private float coef;

    Post(float coef) {
        this.coef = coef;
    }

    public float getCoef() {
        return coef;
    }
}

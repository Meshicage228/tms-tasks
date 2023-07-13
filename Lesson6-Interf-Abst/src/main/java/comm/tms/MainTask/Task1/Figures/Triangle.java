package comm.tms.MainTask.Task1.Figures;

import comm.tms.MainTask.Task1.service.SolveFigure;

public class Triangle extends SolveFigure {
    private float side;
    private float height;

    public Triangle(float side, float height) {
        this.side = side;
        this.height = height;
    }
    @Override
    public void calcAreaAndPerim(){
        this.area = (float) (0.5 * side * height);
        this.perimetr = side * 3;
    }

    @Override
    public float getPerimetr() {
        return this.perimetr;
    }
}

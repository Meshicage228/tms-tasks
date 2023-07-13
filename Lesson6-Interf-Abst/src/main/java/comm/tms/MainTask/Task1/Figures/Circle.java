package comm.tms.MainTask.Task1.Figures;

import comm.tms.MainTask.Task1.service.SolveFigure;

public class Circle extends SolveFigure {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }
    @Override
    public void calcAreaAndPerim(){
        this.perimetr = (float) (2 * Math.PI * radius);
        this.area = (float) (Math.PI * Math.pow(radius, 2));
    }
    @Override
    public float getPerimetr() {
        return this.perimetr;
    }
}

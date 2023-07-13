package comm.tms.MainTask.Task1.Figures;

import comm.tms.MainTask.Task1.service.SolveFigure;

public class Rectangle extends SolveFigure {
    private float width;
    private float length;

    public Rectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }
    @Override
    public void calcAreaAndPerim(){
        this.perimetr = (width + length) * 2;
        this.area = width * length;
    }
    @Override
    public float getPerimetr() {
        return this.perimetr;
    }
}

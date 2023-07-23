package comm.tms.mainTask.task1.mathFigures;

import comm.tms.mainTask.task1.figuresService.SolveFigure;

public class Rectangle extends SolveFigure {
    private float width;
    private float length;

    public Rectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public float calcArea() {
        return  width * length;
    }

    @Override
    public float calcPerim() {
        return (width + length) * 2;
    }
}

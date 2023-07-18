package comm.tms.mainTask.task1.mathFigures;

import comm.tms.mainTask.task1.figuresService.SolveFigure;

public class Triangle extends SolveFigure {
    private float side;
    private float height;

    public Triangle(float side, float height) {
        this.side = side;
        this.height = height;
    }
    @Override
    public float calcArea(){
        return (float) (0.5 * side * height);
    }
    @Override
    public float calcPerim() {
        return side * 3;
    }
}

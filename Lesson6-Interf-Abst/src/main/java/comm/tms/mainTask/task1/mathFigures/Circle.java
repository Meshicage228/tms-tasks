package comm.tms.mainTask.task1.mathFigures;

import comm.tms.mainTask.task1.figuresService.SolveFigure;

public class Circle extends SolveFigure {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }
    @Override
    public float calcArea() {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public float calcPerim() {
        return (float) (2 * Math.PI * radius);
    }
}

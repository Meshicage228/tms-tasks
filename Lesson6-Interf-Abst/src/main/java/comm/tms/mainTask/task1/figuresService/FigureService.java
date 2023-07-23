package comm.tms.mainTask.task1.figuresService;

public class FigureService {
    public float calculate(SolveFigure... figures) {
        float sum = 0;
        for (SolveFigure fig : figures) {
            fig.calcArea();
            sum += fig.calcPerim();
        }
        return sum;
    }
}

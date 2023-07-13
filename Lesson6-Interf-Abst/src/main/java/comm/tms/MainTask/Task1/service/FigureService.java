package comm.tms.MainTask.Task1.service;

public class FigureService {
    public float calculate(SolveFigure... figures) {
        float sum = 0;
        for (SolveFigure fig : figures) {
            fig.calcAreaAndPerim();
            sum += fig.getPerimetr();
        }
        return sum;
    }
}

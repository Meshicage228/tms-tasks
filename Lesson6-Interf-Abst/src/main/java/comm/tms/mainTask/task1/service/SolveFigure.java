package comm.tms.mainTask.task1.service;

public abstract class SolveFigure {
    protected float area;
    protected float perimetr;

    public abstract void calcAreaAndPerim();

    public float getPerimetr(){
        return perimetr;
    }
}

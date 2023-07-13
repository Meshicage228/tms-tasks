package comm.tms.MainTask.Task1.service;

public abstract class SolveFigure {
    protected float area;
    protected float perimetr;
    public float getPerimetr(){
        return perimetr;
    }
    public abstract void calcAreaAndPerim();
}

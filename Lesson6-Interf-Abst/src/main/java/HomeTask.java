import comm.tms.MainTask.Task2.People.*;
import comm.tms.MainTask.Task2.Service.*;

public class HomeTask {
    public static void main(String[] args) {
        //1.
       /* SolveFigure triangle = new Triangle(12,2.5f);
        SolveFigure rectangle = new Rectangle(5,10);
        SolveFigure rectangle2 = new Rectangle(12,3);
        SolveFigure circle = new Circle(15);
        SolveFigure circle2 = new Circle(3);

        SolveFigure[] arr = {triangle, rectangle, rectangle2, circle, circle2};

        FigureService service = new FigureService();

        System.out.println("Sum of all perimetrs of all figures is - " + service.calculate(arr));*/

        //2.

        PostInterface director = new Director();
        PostInterface accountant = new Accountant();
        PostInterface worker = new Worker();

    }
}

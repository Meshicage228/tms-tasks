import comm.tms.additionalTask.docEmployee.*;
import comm.tms.additionalTask.serviceDocument.*;
import comm.tms.mainTask.task1.figuresService.*;
import comm.tms.mainTask.task1.mathFigures.*;
import comm.tms.mainTask.task2.people.*;
import comm.tms.mainTask.task2.peopleService.*;

import java.util.Date;

public class Hometask6 {
    public static void main(String[] args) {
        //1.
        SolveFigure triangle = new Triangle(12, 2.5f);
        SolveFigure rectangle = new Rectangle(5, 10);
        SolveFigure rectangle2 = new Rectangle(12, 3);
        SolveFigure circle = new Circle(15);
        SolveFigure circle2 = new Circle(3);

        SolveFigure[] arr = {triangle, rectangle, rectangle2, circle, circle2};

        FigureService service = new FigureService();

        System.out.println("Sum of all perimetrs of all figures is - " + service.calculate(arr));

        //2.

        new Director(Post.DIRECTOR);
        new Accountant(Post.ACCOUNTANT);
        new Worker(Post.WORKER);


        //3.

        Document productContract = new ContractProduct("Milk", 124, 67, new Date());
        Document workerContract = new ContractWithWorker(new Date(), "Chel", 68, new Date());
        Document finance = new FinanceDoc("12435Hx34", 7900.64f, 70, new Date());

        Registr registr = new Registr();
        registr.saveDocument(productContract);
        registr.saveDocument(workerContract);
        registr.saveDocument(finance);

        registr.showInfoAboutAllDocuments();

    }
}

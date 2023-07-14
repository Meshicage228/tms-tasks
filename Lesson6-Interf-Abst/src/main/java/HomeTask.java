import comm.tms.AdditionalTask.Documents.*;
import comm.tms.MainTask.Task1.Figures.*;
import comm.tms.AdditionalTask.Service.Registr;
import comm.tms.AdditionalTask.Service.*;
import comm.tms.MainTask.Task1.service.*;
import comm.tms.MainTask.Task2.People.*;

import java.util.Date;

public class HomeTask {
    public static void main(String[] args) {
        //1.
        SolveFigure triangle = new Triangle(12,2.5f);
        SolveFigure rectangle = new Rectangle(5,10);
        SolveFigure rectangle2 = new Rectangle(12,3);
        SolveFigure circle = new Circle(15);
        SolveFigure circle2 = new Circle(3);

        SolveFigure[] arr = {triangle, rectangle, rectangle2, circle, circle2};

        FigureService service = new FigureService();

        System.out.println("Sum of all perimetrs of all figures is - " + service.calculate(arr));

        //2.

        new Director();
        new Accountant();
        new Worker();

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
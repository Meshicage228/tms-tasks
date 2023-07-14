package comm.tms.AdditionalTask.Documents;

import comm.tms.AdditionalTask.Service.DocumentInter;
import comm.tms.AdditionalTask.Service.Document;

import java.util.Date;

public class ContractWithWorker extends Document implements DocumentInter {
    Date endOfContract;
    String nameOfWorker;

    public ContractWithWorker() {
    }

    public ContractWithWorker(Date endOfContract, String nameOfWorker,int numberOfDocument, Date data) {
        super(numberOfDocument, data);
        this.endOfContract = endOfContract;
        this.nameOfWorker = nameOfWorker;
    }
    @Override
    public void getDocInfo() {
        System.out.println("End of contract : " + endOfContract + "; name of Emploee : "
                + nameOfWorker + "; date of document : " + this.data + "; number of document :" + this.numberOfDocument);
    }
}

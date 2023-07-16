package comm.tms.additionalTask.documents;

import comm.tms.additionalTask.service.Document;

import java.util.Date;

public class ContractWithWorker extends Document{
    private Date endOfContract;
    private String nameOfWorker;

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

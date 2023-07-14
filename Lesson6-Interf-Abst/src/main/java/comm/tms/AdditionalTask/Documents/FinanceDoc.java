package comm.tms.AdditionalTask.Documents;

import comm.tms.AdditionalTask.Service.DocumentInter;
import comm.tms.AdditionalTask.Service.Document;

import java.util.Date;

public class FinanceDoc extends Document implements DocumentInter {
    String departmentCode;
    float totalSum;

    public FinanceDoc() {
    }

    public FinanceDoc(String departmentCode, float totalSum, int numberOfDocument, Date data) {
        super(numberOfDocument, data);
        this.departmentCode = departmentCode;
        this.totalSum = totalSum;
    }
    @Override
    public void getDocInfo() {
        System.out.println("Department code : " + departmentCode + "; Total sum for this month : "
                + totalSum + "; date of document : " + this.data + "; number of document :" + this.numberOfDocument);
    }
}

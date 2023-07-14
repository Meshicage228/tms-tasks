package comm.tms.AdditionalTask.Service;

import java.util.Date;

public abstract class Document implements DocumentInter{
    protected int numberOfDocument;
    protected Date data;

    protected Document() {
        data = new Date(0);
        numberOfDocument = 0;
    }

    protected Document(int numberOfDocument, Date data) {
        this.numberOfDocument = numberOfDocument;
        this.data = data;
    }

}

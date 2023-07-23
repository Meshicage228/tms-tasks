package comm.tms.additionalTask.docEmployee;

import comm.tms.additionalTask.serviceDocument.DocumentInter;

import java.util.Date;

public abstract class Document implements DocumentInter {
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

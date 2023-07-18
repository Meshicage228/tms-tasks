package comm.tms.additionalTask.serviceDocument;

import comm.tms.additionalTask.docEmployee.Document;

public class Registr {
    private Document[] documents = new Document[10];
    public void saveDocument(Document docum){
        for (int i = 0; i < documents.length; i++) {
            if(documents[i] == null){
                documents[i] = docum;
                break;
            }
        }
    }
    public void showInfoAboutAllDocuments(){
        for (Document doc : documents) {
            if(doc != null) {
                doc.getDocInfo();
            }
        }
    }
}

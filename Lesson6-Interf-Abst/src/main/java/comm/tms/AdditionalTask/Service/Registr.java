package comm.tms.AdditionalTask.Service;
public class Registr {
    public Document[] documents = new Document[10];
    public static int index = 0;
    public void saveDocument(Document doc){
        documents[index++] = doc;
    }
    public void showInfoAboutAllDocuments(){
        for (int i = 0; i < index; i++) {
            documents[i].getDocInfo();
        }
    }
}

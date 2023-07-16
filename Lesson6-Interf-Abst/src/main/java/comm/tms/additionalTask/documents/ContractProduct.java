package comm.tms.additionalTask.documents;

import comm.tms.additionalTask.service.Document;

import java.util.Date;

public class ContractProduct extends Document{
    private String typeOfProduct;
    private int amountOfProduct;

    public ContractProduct() {
    }

    public ContractProduct(String typeOfProduct, int amountOfProduct, int numberOfDocument, Date data) {
        super(numberOfDocument, data);
        this.typeOfProduct = typeOfProduct;
        this.amountOfProduct = amountOfProduct;
    }

    @Override
    public void getDocInfo() {
        System.out.println("Type of product : " + typeOfProduct + "; amount of product : "
                + amountOfProduct + "; date of document : " + this.data + "; number of document :" + this.numberOfDocument);
    }
}

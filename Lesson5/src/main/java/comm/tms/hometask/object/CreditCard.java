package comm.tms.hometask.object;

public class CreditCard {
    private String accountNumber;
    private float amountOfMoney;

    public CreditCard() {
    }

    public CreditCard(String accountNumber) {
        this(accountNumber, 0);
    }
    public CreditCard(float amountOfMoney){
        this("0", amountOfMoney);
    }

    public CreditCard(String accountNumber, float amountOfMoney) {
        this.accountNumber = accountNumber;
        this.amountOfMoney = amountOfMoney;
    }

    public void addMoney(float amountOfMoney) {
        if(amountOfMoney < 0) return;
        this.amountOfMoney += amountOfMoney;
    }

    public void subtractMoney(float amountOfMoney) {
        if(amountOfMoney < 0) return;
        if (this.amountOfMoney >= amountOfMoney) {
            this.amountOfMoney -= amountOfMoney;
        } else {
            System.out.println("Your amount of money is " + this.amountOfMoney + " you cannot subtract " + amountOfMoney);
        }
    }
    @Override
    public String toString() {
        return "CreditCard{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}

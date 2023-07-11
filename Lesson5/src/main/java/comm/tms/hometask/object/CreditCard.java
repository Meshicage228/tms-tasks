package comm.tms.hometask.object;

public class CreditCard {
    private String accountNumber;
    private float amountOfMoney;

    public CreditCard() {
    }

    public CreditCard(String accountNumber) {
        this(accountNumber, 0);
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
        if (checkAmountOfMoney(amountOfMoney)) {
            this.amountOfMoney -= amountOfMoney;
        } else {
            System.out.println("Your amount of money is " + this.amountOfMoney + " you cannot subtract " + amountOfMoney);
        }
    }

    private boolean checkAmountOfMoney(float toSubtract) {
        return amountOfMoney > toSubtract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(float amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}

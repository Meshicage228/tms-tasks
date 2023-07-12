package comm.tms.hometask.startTask;

import comm.tms.hometask.object.CreditCard;

public class Main {
    public static void main(String[] args) {
        CreditCard firstCard = new CreditCard(2600);
        CreditCard secondCard = new CreditCard("987654321");
        CreditCard thirdCard = new CreditCard("123498765", 12);

        firstCard.addMoney(-34);
        secondCard.addMoney(987);
        thirdCard.subtractMoney(45);
        thirdCard.subtractMoney(12);

        CreditCard[] arr = {firstCard, secondCard, thirdCard};

        for (CreditCard info : arr) {
            System.out.println(info.toString());
        }

    }
}

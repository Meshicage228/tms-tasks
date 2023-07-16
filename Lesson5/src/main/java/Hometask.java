import comm.tms.additional.Task1.objectTask1.*;
import comm.tms.additional.Task2.objectTask2.CashMachine;
import comm.tms.hometask.object.CreditCard;

public class Hometask {
    public static void main(String[] args) {
        //1. Кредитная карточка
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

        //2. Компьютер

        Computer computer1 = new Computer(894.5f, "80XL");
        System.out.println(computer1);
        Computer computer2 = new Computer(1245.53f, "80XL", new HDD("Western", 500, TypeOfHdd.INTERNAL), new RAM("RAM", 1024));
        System.out.println(computer2);

        //3. Банкомат
        CashMachine machine = new CashMachine(12,20,60);
        machine.addMoney(20);
        machine.addMoney(50);
        machine.subtractMoney();
        machine.showInfoMachine();

    }
}

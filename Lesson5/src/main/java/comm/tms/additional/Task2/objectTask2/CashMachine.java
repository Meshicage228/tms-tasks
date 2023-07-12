package comm.tms.additional.Task2.objectTask2;

import java.util.Arrays;
import java.util.Scanner;

public class CashMachine {
    private int[] money = {100, 50, 20};
    private int[] amount = new int[money.length];
    private int[] billCounter;
    public CashMachine() {
    }
    public CashMachine(int... value) {
        System.arraycopy(value, 0, amount, 0, value.length);
    }

    public void addMoney(int cash) {
        for (int i = 0; i < money.length; i++) {
            if (money[i] - cash == 0) {
                amount[i]++;
                break;
            }
        }
    }
    private boolean tryToSubtract() {
        int moneyToSubtract = enterNumber();
        billCounter = new int[amount.length];
        int[] copyMoney = Arrays.copyOf(amount,amount.length);

        if (checkTotalMoney(moneyToSubtract)) {
            int index = 0;
            int counter;
            while (moneyToSubtract > 0 && index < amount.length) {
                counter = 0;
                while (copyMoney[index] != 0 && moneyToSubtract >= money[index]) {
                    moneyToSubtract -= money[index];
                    copyMoney[index]--;
                    counter++;
                }
                billCounter[index] = counter;
                index++;
            }
            if(moneyToSubtract == 0){
                amount = copyMoney;
                return true;
            }
        }
        return false;
    }
    public void subtractMoney(){
        if (tryToSubtract()) {
            for (int i = 0; i < money.length; i++) {
                if(billCounter[i] == 0) continue;
                System.out.println("Было снято " + money[i] + " д.е по " + billCounter[i]);
            }
        }
        else {
            System.out.println("Не можем снять");
        }
    }
    private boolean checkTotalMoney(int moneyToSubtract) {
        int sum = 0;
        for (int i = 0; i < money.length; i++) {
            sum += money[i] * amount[i];
        }
        return sum >= moneyToSubtract;
    }

    public void showInfoMachine() {
        for (int i = 0; i < money.length; i++) {
            System.out.println(money[i] + " its amount -- " + amount[i]);
        }
    }
    private int enterNumber(){
        return new Scanner(System.in).nextInt();
    }
}

package comm.tms.additional.Task2.startTask2;

import comm.tms.additional.Task2.objectTask2.CashMachine;

public class Main {
    public static void main(String[] args) {
        CashMachine machine = new CashMachine(12,20,60);
        machine.addMoney(20);
        machine.addMoney(50);
        machine.subtractMoney();
        machine.showInfoMachine();
    }
}

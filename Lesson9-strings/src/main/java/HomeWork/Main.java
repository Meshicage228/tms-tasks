package HomeWork;

import HomeWork.StringMethods;

public class Main {
    public static void main(String[] args) {
        // Без ввода, решил готовую строку передавать, долго ввводить
        String code = "5555-ABC-5678-DeF-9g10k";

        StringMethods.showTwoFirstNumberBlocks(code);

        StringMethods.replaceFourNumbers(code);

        System.out.println(StringMethods.getLettersOnly(code));

        StringMethods.showLettersUpRegister(code);

        StringMethods.checkSequence(code);

        StringMethods.checkFirst(code);

        StringMethods.checkLast(code);

    }
}

package HomeWork;

public abstract class StringMethods {
    public static void showTwoFirstNumberBlocks(String code){
        System.out.println(String.join("", code.substring(0,4), code.substring(9, 13)));
    }
    public static void replaceFourNumbers(String code){
        StringBuilder stringBuilder = new StringBuilder(code);
        stringBuilder.replace(5, 8 , "***").replace(14, 17, "***");
        System.out.println(stringBuilder);
    }
    public static String getLettersOnly(String code){
        return String.join("/", code.substring(5, 8), code.substring(14, 17), code.substring(19, 20), code.substring(22)).toLowerCase();
    }
    public static void showLettersUpRegister(String code){
        StringBuilder answer = new StringBuilder(getLettersOnly(code).toUpperCase());
        answer.insert(0, "Letters:");
        System.out.println(answer);
    }
    public static void checkSequence(String code){
        if(code.contains("abc") || code.contains("ABC")){
            System.out.println("Contains");
        } else {
            System.out.println("Doesnt contain");
        }
    }
    public static void checkFirst(String code){
        System.out.println(code.startsWith("555"));
    }
    public static void checkLast(String code){
        System.out.println(code.endsWith("1a2b"));
    }
}

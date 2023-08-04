import Additional.Additional;
import MainTask.MyArrayList;
import MainTask.MyList;

public class Main {
    public static void main(String[] args) {
        //Основное :
        MyList<String> stringMyList = new MyArrayList<>(3);
        stringMyList.add("hello");
        stringMyList.add("pip");
        stringMyList.add("lol");
        stringMyList.add("cheese");

        System.out.println(stringMyList.size());

        stringMyList.remove(2);

        System.out.println(stringMyList.getElement(2));

        stringMyList.remove("top");

        System.out.println(stringMyList.size());

        stringMyList.deleteAll();

        System.out.println(stringMyList.size());

        // Доп
        int[] arr = new int[]{1,1,5,6,3,6,6,6,3,6,89};
        Additional.byArray(arr);
        Additional.findDuplicates(arr);
    }
}

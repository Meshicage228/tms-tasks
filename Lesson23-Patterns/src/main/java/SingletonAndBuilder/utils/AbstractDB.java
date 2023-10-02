package SingletonAndBuilder.utils;

import SingletonAndBuilder.domain.Child;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class AbstractDB {
    private static volatile AbstractDB INSTANCE;

    private CopyOnWriteArrayList<Child> childsList = new CopyOnWriteArrayList<>();

    private AbstractDB() {
    }


    public static AbstractDB getInstance() {
        if (INSTANCE == null) {
            synchronized (AbstractDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AbstractDB();
                }
            }
        }
        return INSTANCE;
    }

    public void addChildToDB(Child... childs) {
        childsList.addAll(Arrays.asList(childs));
    }

    public void showAllFromDB() {
        System.out.println(childsList);
    }


}

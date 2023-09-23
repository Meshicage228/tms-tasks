package iterator.service;

import iterator.domain.IteratorContent;

import java.util.Iterator;

public class CheckIteratorService {
    public static void showAllInfo(IteratorContent checkIterator){
        Iterator<Integer> iterator = checkIterator.getIntegerList().iterator();

        iterator.forEachRemaining(System.out::println);
    }
}

package iterator;

import iterator.domain.SomeObject;
import iterator.service.impl.NumbersIteratorImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class IteratorMain {
    public static void main(String[] args) throws InterruptedException {
        // Кастомный итератор
        SomeObject<Integer> numbers = new SomeObject<>();

        numbers.add(23);
        numbers.add(53);
        numbers.add(-13);

        NumbersIteratorImpl iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Дефолтный
        List<Integer> list = Stream.generate(() -> new Random().nextInt(1000))
                .limit(10)
                .toList();

        Iterator<Integer> iterator1 = list.iterator();

        iterator1.forEachRemaining(System.out::println);

    }
}

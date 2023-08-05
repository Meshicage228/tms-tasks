package MainTask;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] arr;

    private int sizeCounter = 0;

    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int customCapacity) {
        if (customCapacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new Object[customCapacity];
    }

    @Override
    public int size() {
        return sizeCounter;
    }

    @Override
    public T getElement(int index) {
        if (index < 0 || index >= sizeCounter) {
            throw new IndexOutOfBoundsException();
        } else {
            return (T) arr[index];
        }
    }

    @Override
    public void add(T element) {
        if (sizeCounter == arr.length) {
            enlargeCapacity();
        }
        arr[sizeCounter++] = element;
    }

    @Override
    public void remove(T element) {
        if (!contains(element)) {
            return;
        }
        int i = 0;
        for (; i < sizeCounter; i++) {
            if (arr[i].equals(element)) {
                break;
            }
        }
        for (; i < sizeCounter; i++) {
            arr[i] = arr[i + 1];
        }
        sizeCounter--;
    }

    @Override
    public void remove(int index) {
        if (index >= sizeCounter || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < sizeCounter; i++) {
            arr[i] = arr[i + 1];
        }
        sizeCounter--;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < sizeCounter; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteAll() {
        Arrays.fill(arr, null);
        sizeCounter = 0;
    }

    @Override
    public void enlargeCapacity() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", sizeCounter=" + sizeCounter +
                '}';
    }
}

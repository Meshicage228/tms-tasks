package MainTask;

public interface MyList<T> {
    int size();

    T getElement(int index);

    void add(T element);

    void remove(T element);

    void remove(int index);

    boolean contains(T element);

    void deleteAll();

    void enlargeCapacity();

}

package iterator.service.impl;

import iterator.service.Iterator;

import java.util.List;

public class NumbersIteratorImpl<T> implements Iterator<T> {
    private final List<T> entity;
    private int idx = 0;

    public NumbersIteratorImpl(List<T> entity) {
        this.entity = entity;
    }

    @Override
    public boolean hasNext() {
        return idx < entity.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        T el = entity.get(idx);
        idx++;
        return el;
    }
}
